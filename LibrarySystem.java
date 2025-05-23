/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarysystem;

/**
 *
 * @author mearley2025
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import javax.sound.sampled.*;


public class LibrarySystem {//Building window for buttons and text field
    private JFrame frame;
    private JTextField nameField, idField, bookField;
    private JTextArea displayArea;    // GUI components
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> books = new ArrayList<>();    // Lists to store users and books
    private final String USERS_FILE = "users.csv";
    private final String BOOKS_FILE = "books.csv";    // Files to save user and book data

    public LibrarySystem() {
        frame = new JFrame("Library Book Loan System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        frame.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 25);
        frame.add(nameField);

        JLabel idLabel = new JLabel("User ID:");
        idLabel.setBounds(20, 60, 100, 25);
        frame.add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 60, 200, 25);
        frame.add(idField);

        JButton registerButton = new JButton("Register User");
        registerButton.setBounds(350, 20, 150, 30);
        registerButton.addActionListener(e -> registerUser());
        frame.add(registerButton);//registering new users

        JLabel bookLabel = new JLabel("Book Title:");
        bookLabel.setBounds(20, 100, 100, 25);
        frame.add(bookLabel);

        bookField = new JTextField();
        bookField.setBounds(120, 100, 200, 25);
        frame.add(bookField);

        JButton checkoutButton = new JButton("Checkout Book");
        checkoutButton.setBounds(350, 60, 150, 30);
        checkoutButton.addActionListener(e -> checkoutBook());
        frame.add(checkoutButton);

        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(350, 100, 150, 30);
        returnButton.addActionListener(e -> returnBook());
        frame.add(returnButton);

        JButton lookupButton = new JButton("Lookup Records");
        lookupButton.setBounds(350, 140, 150, 30);
        lookupButton.addActionListener(e -> lookupRecords());
        frame.add(lookupButton);

        displayArea = new JTextArea();
        displayArea.setBounds(20, 180, 550, 250);
        displayArea.setEditable(false);
        frame.add(displayArea);

        frame.setVisible(true);
    }

    private void registerUser() {//registering user
        String name = nameField.getText();
        String id = idField.getText();
        if (!name.isEmpty() && !id.isEmpty()) {
            if (isUserRegistered(name, id)) {
                displayArea.setText("Error: User already exists.");
                return;
            }
            users.add(name + "," + id);
            saveToFile(USERS_FILE, name + "," + id);
            displayArea.setText("User Successfully Registered!" + "\nName: " + name + "\nId: " + id
                    + "\n\nMake sure to remember your exact name and Id number, \nyou will need it to check out and return books");
        }
    }

    private boolean isUserRegistered(String name, String id) {// checking if user is duplicated based on name and id number
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(name) && parts[1].equals(id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private void checkoutBook() {
        String book = bookField.getText();
        String id = idField.getText();
        if (!book.isEmpty() && !id.isEmpty()) {
            books.add(id + "," + book);
            saveToFile(BOOKS_FILE, id + "," + book);
            displayArea.setText("Book Checked Out: " + book);
            
            
            playTingSound(); //Play sound
        }
   }

    private void returnBook() {//returning book function
        String book = bookField.getText();
        String id = idField.getText();
        boolean bookFound = false;

        if (!book.isEmpty() && !id.isEmpty()) {
            List<String> updatedBooks = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        if (parts[0].equals(id) && parts[1].equals(book)) {
                            bookFound = true;
                            continue; // Skip writing this line to "remove" the record
                        }
                    }
                    updatedBooks.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!bookFound) {
                displayArea.setText("Error: This book was not checked out by this user.");//making sure you cannot return a book you haven't checked out
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
                for (String record : updatedBooks) {
                    writer.write(record);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            displayArea.setText("Book Returned: " + book);
            
            generateLibraryReport();

        }
    }

    private void lookupRecords() {//looking up information for users so they can see books checked out
        String name = nameField.getText();
        String id = idField.getText();
        boolean found = false;
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(name) && parts[1].equals(id)) {
                    result.append("User Found: ").append(name).append(" (ID: ").append(id).append(")\n");
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            displayArea.setText("Error: No records found for this user.");
            return;
        }

        result.append("Checked Out Books:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(id)) {
                    result.append("- ").append(parts[1]).append("\n");//listing books in bulleted lines
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayArea.setText(result.toString());
    }
    
    private void generateLibraryReport() {//generating report that downloads to a PDF saved on desktop
        String userHome = System.getProperty("user.home");
        File reportFile = new File(userHome + "/Downloads/LibraryReport.txt");

        List<String[]> userList = new ArrayList<>();
        List<String[]> bookList = new ArrayList<>();

        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = userReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userList.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bookReader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = bookReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    bookList.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {//formatting report
            writer.write("Library User Book Checkout Report\n");
            writer.write("----------------------------------\n\n");

            for (String[] user : userList) {
                String name = user[0];
                String id = user[1];
                writer.write("User: " + name + " (ID: " + id + ")\n");
                boolean hasBooks = false;

                for (String[] record : bookList) {
                    if (record[0].equals(id)) {
                        if (!hasBooks) {
                            writer.write("  Books:\n");
                            hasBooks = true;
                        }
                        writer.write("   - " + record[1] + "\n");
                    }
                }

                if (!hasBooks) {
                    writer.write("  No books checked out.\n");
                }

                // line that goes after all books per user
                writer.write("___________________\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void playTingSound() {//playing sound, connected to checkout button
        try {
            File soundFile = new File("sounds/ting.wav.wav"); 
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new LibrarySystem();
    }
}