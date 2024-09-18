/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stringobjects;

/**
 *
 * @author mearley2025
 */
public class StringObjects {

    public static void main(String[] args) {
      String name = new String ("Meg Earley");
      System.out.println("My name is \"" + name + "\"");
      System.out.println("My name length is " + name.length());
      System.out.println("My name in upper case is \"" + name.toUpperCase() + "\"");
      System.out.println("My name in lower case is \"" + name.toLowerCase() + "\"");
      System.out.println("The first letter in my name is \"" + name.charAt(0) + "\"");
      System.out.println("The last letter in my name is \"" + name.charAt(name.length()-1) + "\"");
      System.out.println("The index of the space between the names is " + name.indexOf(" "));
    }
}
