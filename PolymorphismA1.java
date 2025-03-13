/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polymorphisma1;

/**
 *
 * @author mearley2025
 */

import java.util.ArrayList;
public class PolymorphismA1 {
    public static void main(String[] args) {
        // Creating objects
        Aircraft basicAircraft = new Aircraft();
        Aircraft plane = new SingleEnginePlane();
        Aircraft helicopter = new Helicopter();

        // Storing in an ArrayList
        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(basicAircraft);
        aircraftList.add(plane);
        aircraftList.add(helicopter);

        // Printing details
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.getDescription());
        }
    }
}

// base class
class Aircraft {
    String wings;

    public Aircraft() {
        this.wings = "fixed wings";
    }

    public String getDescription() {
        return "Aircraft with " + wings;
    }
}

// child class, SingleEnginePlane
class SingleEnginePlane extends Aircraft {
    protected String engine;

    public SingleEnginePlane() {
        super();
        this.engine = "rotary engine";
    }

    @Override
    public String getDescription() {
        return "Single Engine Plane with " + wings + " and " + engine;
    }
}

// child class, Helicopter
class Helicopter extends SingleEnginePlane {
    protected String rotorBlades;

    public Helicopter() {
        super();
        this.rotorBlades = "rotating helicopter blades";
    }

    @Override
    public String getDescription() {
        return "Helicopter with " + wings + ", " + engine + ", and " + rotorBlades;
    }
}
