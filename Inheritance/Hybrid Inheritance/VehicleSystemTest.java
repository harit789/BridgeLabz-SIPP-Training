// Superclass: Vehicle
class Vehicle {
    String model;
    int maxSpeed;

    // Constructor
    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: PetrolVehicle (inherits from Vehicle and implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with petrol.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Petrol Vehicle");
    }
}

// Subclass: ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle {

    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    void charge() {
        System.out.println(model + " is charging the battery.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Electric Vehicle");
    }
}

// Main class
public class VehicleSystemTest {
    public static void main(String[] args) {
        PetrolVehicle petrolCar = new PetrolVehicle("Toyota Corolla", 180);
        ElectricVehicle electricCar = new ElectricVehicle("Tesla Model 3", 250);

        petrolCar.displayInfo();
        petrolCar.refuel();

        System.out.println();

        electricCar.displayInfo();
        electricCar.charge();
    }
}
