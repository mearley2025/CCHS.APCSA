/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

    /**
     * @param args the command line arguments
     */
    //carry out calculations or circular items
    //such as a circle, a sphere, a cone, a column

package com.mycompany.radiuscalc;

import java.util.Scanner;

public class RadiusCalc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (pi r^2)\n" +
                "2 - Volume of a sphere (4/3 pi r^3)\n" +
                "3 - Volume of a cone (pi r^2 h/3)\n" +
                "4 - Volume of a column (pi r^2 h)");
        System.out.println("Type the number for which one you want to calculate");
        int i = s.nextInt();
        if (i == 1){
            cCalc();
        }else if (i == 2){
            sCalc();
        }else if(i == 3){
            cCalc2();
        }else if(i == 4){
            cCalc3();
        }
    }

     
     public static void cCalc(){
        System.out.println("enter the radius of your circle");
        Scanner scan = new Scanner (System.in);//added scanner
        int r = scan.nextInt();
        double result = Math.PI * Math.pow(r, 2);
        System.out.println(result);
    }
     
     public static void sCalc(){
        System.out.println("enter the radius of your sphere");//sphere not circle
        Scanner scan = new Scanner (System.in);//added scanner
        int r = scan.nextInt();
        double result = (4.0/3) * Math.PI * Math.pow(r, 3);//made it 4.0
        System.out.println(result);
    }

     public static void cCalc2(){
        System.out.println("enter the radius of your cone, then height of your cone");
        Scanner scan = new Scanner (System.in);//added scanner
        int r = scan.nextInt();
        int h = scan.nextInt();
        double result = Math.PI * Math.pow(r, 2) * ((double) h/3.0);//needed the h divided by 3
        System.out.println(result);
    }
    
    public static void cCalc3(){
        System.out.println("enter the radius of your cone, then height of your cone");
        Scanner scan = new Scanner (System.in);//added scanner
        int r = scan.nextInt();
        int h = scan.nextInt();//added this variable 
        double result = Math.PI * Math.pow(r, 2) * h;
        System.out.println(result);
    }
}
    
//I also reordred the public static voids to match up with the order of the numbrs in the main so it is easier to relate the different calculations