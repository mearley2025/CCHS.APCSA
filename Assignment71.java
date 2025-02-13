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
      Vehicle submarine = new Submarine("Seawolf", 35.0, 140, "Hydrodynamic", "Neuclear Reactor", 107, 1600);
      Vehicle crewBoat = new CrewBoat ("Vespoli", 13.6, 2, "Displacement", "2 people", 34, "Sculling oars", "VHP 30");
      Vehicle cargoPlane = new CargoPlane("Boeing C-17 Globemaster III", 830.0, 102, 52, "4x Pratt & Whitney F117-PW-100 turbofan", 170900, "26.8m x 5.5m x 3.8m");
      Vehicle jetPlane = new JetPlane("Lockheed Martin F-22 Raptor", 2410.0, 1, 13, "Pratt & Whitney F119-PW-100 turbofan", 2);

      System.out.println("Electric Car\n" + electricCar);
      System.out.println("\nCamper Van\n" + camperVan);
      System.out.println("\nSubmarine\n" + submarine);
      System.out.println("\nCrew (rowing) Boat\n" + crewBoat);
      System.out.println ("\nCargo Plane\n" + cargoPlane);
      System.out.println ("\n Jet Plane\n" + jetPlane);
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
    @Override
    public double getSpeed(){
    return speed;
    }
    @Override
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

//starting base class, car
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

//starting base class, boat
class Boat extends Vehicle {
    protected String hullType;
    protected String poweredBy;
    protected int length;//in feet
    
    public Boat (String inBrand, double inSpeed, int inPassengers, String hullType, String poweredBy, int length){
        super (inBrand, inSpeed, inPassengers);
        this.hullType = hullType;
        this.poweredBy = poweredBy;
        this.length = length;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nType of Hull: " + hullType + "\nPowered by: " + poweredBy + "\nLength (ft): " + length;
    }
}

//sublass of boat, submarine
class Submarine extends Boat {
    private int divingDepth;
    
    public Submarine (String inBrand, double inSpeed, int inPassengers, String hullType, String poweredBy, int length, int divingDepth){
        super (inBrand, inSpeed, inPassengers, hullType, poweredBy, length);
        this.divingDepth = divingDepth;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nMax Diving Depth (ft): " + divingDepth;
    }
}

//subclass of boat, rowing boat (8 person)
class CrewBoat extends Boat{
    private String oarType;
    private String boatName;

    public CrewBoat (String inBrand, double inSpeed, int inPassengers, String hullType, String poweredBy, int length, String oarType, String boatName){
        super (inBrand, inSpeed, inPassengers, hullType, poweredBy, length);
        this.oarType = oarType;
        this.boatName = boatName;
    }
@Override
    public String toString(){
        return super.toString() + "\nOar Type: " + oarType + "\nBoat Name: " + boatName;
    }
}

//starting base class, airplane 
class Airplane extends Vehicle {
    protected int wingspan; //in feet
    protected String engine;
    
    public Airplane (String inBrand, double inSpeed, int inPassengers, int wingspan, String engine){
        super (inBrand, inSpeed, inPassengers);
        this.wingspan = wingspan;
        this.engine = engine;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nWingspan (ft): " + wingspan + "\nEngine Type: " + engine;
    }
}

//subclass of airplane, cargo plane
class CargoPlane extends Airplane{
    private double weightCapacity;//in lbs
    private String cargoArea;//length x width x height

    public CargoPlane (String inBrand, double inSpeed, int inPassengers, int wingspan, String engine, double weightCapacity, String cargoArea){
        super (inBrand, inSpeed, inPassengers, wingspan, engine);
        this.weightCapacity = weightCapacity;
        this.cargoArea = cargoArea;
    }
@Override
    public String toString(){
        return super.toString() + "\nWeight Capacity (lbs): " + weightCapacity + "\nCargo Area (lxwxh): " + cargoArea;
    }
}

//subclass of airplane, jetplane
class JetPlane extends Airplane{
    private int engineCount; //number of engines
    
    public JetPlane (String inBrand, double inSpeed, int inPassengers, int wingspan, String engine, int engineCount){
        super (inBrand, inSpeed, inPassengers, wingspan, engine);
        this.engineCount = engineCount;
    }
@Override
    public String toString(){
        return super.toString() + "\nNumber of Engines: " + engineCount;
    }
}
