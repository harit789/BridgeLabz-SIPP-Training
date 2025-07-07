package EncapsulationAndPlymorphism;

import java.util.*;

// GPS Interface
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Abstract class: Vehicle
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID    : " + vehicleId);
        System.out.println("Driver Name   : " + driverName);
        System.out.println("Rate per Km   : ₹" + ratePerKm);
        System.out.println("Current Loc.  : " + getCurrentLocation());
    }

    // Getters for encapsulation (no setters for sensitive data)
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // GPS methods
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Car class
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // Additional base fare
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // No extra charges
    }
}

// Auto class
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // Auto meter charge
    }
}

// Main class
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();

        Vehicle v1 = new Car("CAR001", "Ravi", 15.0, "MG Road");
        Vehicle v2 = new Bike("BIKE001", "Amit", 8.0, "Indiranagar");
        Vehicle v3 = new Auto("AUTO001", "Sunil", 10.0, "Jayanagar");

        rides.add(v1);
        rides.add(v2);
        rides.add(v3);

        double rideDistance = 12.5; // km

        System.out.println("=== Ride Fare Summary for " + rideDistance + " km ===");
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.printf("Estimated Fare: ₹%.2f\n", v.calculateFare(rideDistance));
            System.out.println("--------------------------------");
        }
    }
}
