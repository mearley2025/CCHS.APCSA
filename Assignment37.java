/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment37;

/**
 * @author mearley2025
 */

/** Answer the following questions:

1) What is the difference between a class and an object?
A class defines the structure and behavior of objects, while an object is an instance of a class that embodies those definitions.
Multiple objects can be created from the same class. 
 
2) What happens when you pass an object to a print or println method?
When you pass an object to a print or print ln method it will print out the object as a string (automatically converts the object 
into a string via the toString() method from the object class UNLESS you override it).

3) What is the scope of a variable in a method? In a class?
Data declared at Class level can be referenced anywhere in the Class, where as data declared in a method (or local data) can 
only be referenced in that method, or if a variable is declared within an "if" statement.

*/

public class Assignment37 {

    public static void main(String[] args) {
       Car car1 = new Car(); //creating new object
       
       car1.setBrand("Volkswagen");
       car1.setModel("Beetle");
       car1.setPower(174);
       car1.setSpeed(205);
       car1.setPrice(20895);//assigning values to all class details for a VW bug
       
       System.out.println(car1);//printing object will all of class details
       System.out.println(""); //newline
       
       //repeating above but with a different car, same class
       Car car2 = new Car ();
       car2.setBrand("Toyota");
       car2.setModel("Prius");
       car2.setPower(150);
       car2.setSpeed(112);
       car2.setPrice(2045);
       System.out.println(car2);
       System.out.println("");
       
       Car car3 = new Car ();
       car3.setBrand("BMW");
       car3.setModel("i8");
       car3.setPower(369);
       car3.setSpeed(155);
       car3.setPrice(148495);
       System.out.println(car3);
       System.out.println("");
       
       Car car4 = new Car ();
       car4.setBrand ("Tesla");
       car4.setModel ("Model 3");
       car4.setPower(510);
       car4.setSpeed(145);
       car4.setPrice(42490);
       System.out.println(car4);
    }
}

class Car{ // creating a class that will be used to define the state of object(s)
    
    private String carBrand = "";
    private String carModel = "";
    private int enginePower = 0;
    private double maxSpeed = 0;
    private double price = 0;
    //creating strings/varables to be used
    
    public void setBrand(String inBrand){
        carBrand = inBrand;
    }//making input (to be set to different things in the object(s)) a string and = to carbrand
    public void setModel(String inModel){
        carModel = inModel;
    }
    public void setPower (int inPower){
        enginePower = inPower;
    }//same thing but with int
    public void setSpeed (double inSpeed){
        maxSpeed = inSpeed;
    }//same thing but with double
    public void setPrice (double inPrice){
        price = inPrice;
        
        
    }
   
    
    public String toString(){
        String result = ""; //returns the state of the object (class) as a string
        result = "Car Brand: " + carBrand + "\n" +
                 "Car Model: " + carModel + "\n" +
                 "Engine Horse Power: " + enginePower + " hp" + "\n" +
                 "Maximum speed: " + maxSpeed + " mph" + "\n" +
                 "Price of car: $" + price;
        return result; //formatting the string that will be returned/printed
    }
}
