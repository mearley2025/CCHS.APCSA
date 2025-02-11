/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment71;

/**
 *
 * @author mearley2025
 */
public class Assignment71 {
    public static void main(String[] args) {
      Vehicle electricCar = new ElectricCar("Tesla", 135, 7, 4, "Model Y", 60, 8.25);
      Vehicle camperVan = new CamperVan ("Airstream", 90, 3, 4, "Atlas", 2, 1);
      Vehicle submarine = new Submarine("Seawolf", 35.0, 140, "Hydrodynamic", 1, 107, 1600);
      
      System.out.println(electricCar);
      System.out.println("\n" + camperVan);
      System.out.println("\n" + submarine);
    }
}

class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    
    //Base default constructor
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
    }
    public Vehicle(String inBrand, double inSpeed, int inPassengers){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
    }

    //getters and setters
    public String getBrand(){
    return brandName;
    }
    public void setBrandName(String inBrand){
    brandName = inBrand;
    }
    public double getSpeed(){
    return speed;
    }
    public void setSpeed(double inSpeed){
    speed = inSpeed;
    }
    public int getPassengers(){
    return passengers;
    }
    public void setPassengers(int inPassengers){
    passengers = inPassengers;
    }
    
    
    //Base toString
    public String toString(){
    String result = "";
    result = "Brand: "+ getBrand() + "\nTop Speed (mph): " + getSpeed() + "\nPassengers: " + getPassengers();
    return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
public void setSpeed(double inSpeed);
public double getSpeed();
}

//starting subclass, car
class Car extends Vehicle {
    protected int numberofDoors;
    protected String carModel;
    
    //constructor 
    public Car (String inBrand, double inSpeed, int inPassengers, int numberofDoors, String carModel){
        super (inBrand, inSpeed, inPassengers);
        this.numberofDoors = numberofDoors;
        this.carModel = carModel;
    }
    
    @Override
    public String toString (){
        return super.toString() + "\nNumber of doors: " + numberofDoors + "\nCar model: " + carModel;
    }
}  
//subclass of car, electric car
class ElectricCar extends Car{
    private int batteryCapacity;
    private double chargeTime;
    
    public ElectricCar(String inBrand, double inSpeed, int inPassengers, int numberofDoors, String carModel, int batteryCapacity, double chargeTime){
        super(inBrand, inSpeed, inPassengers, numberofDoors, carModel);
        this.batteryCapacity = batteryCapacity;
        this.chargeTime = chargeTime;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nBattery capacity (kWh): " + batteryCapacity + "\nCharge time (hours): " + chargeTime;
    }
}

//subclass of car, camper
class CamperVan extends Car{
    private int beds;
    private int bumpOuts;
    
    public CamperVan(String inBrand, double inSpeed, int inPassengers, int numberofDoors, String carModel, int beds, int bumpOuts){
        super(inBrand, inSpeed, inPassengers, numberofDoors, carModel);
        this.beds = beds;
        this.bumpOuts = bumpOuts;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nNumber of Beds: " + beds + "\nNumber of bumpouts: " + bumpOuts;
    }
}

//starting subclass, boat
class Boat extends Vehicle {
    private String hullType;
    private int poweredBy;
    private int length;//in feet
    
    public Boat (String inBrand, double inSpeed, int inPassengers, String hullType, int poweredBy, int length){
        super (inBrand, inSpeed, inPassengers);
        this.hullType = hullType;
        this.poweredBy = poweredBy;
        this.length = length;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nType of Hull: " + hullType + "Powered by: " + poweredBy;
    }
}

//sublass of boat, submarine
class Submarine extends Boat {
    private int divingDepth;
    
    public Submarine (String inBrand, double inSpeed, int inPassengers, String hullType, int poweredBy, int length, int divingDepth){
        super (inBrand, inSpeed, inPassengers, hullType, poweredBy, length);
        this.divingDepth = divingDepth;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nMax Diving Depth: " + divingDepth;
    }
}

