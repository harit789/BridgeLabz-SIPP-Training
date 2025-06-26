package UseOfKeywords;

public class Vehicle {

    // Static variable shared by all vehicles
    static double registrationFee = 5000.00;

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }

    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber; // Final variable

    // Constructor using 'this' keyword
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\n--- Vehicle Registration Details ---");
            System.out.println("Owner Name         : " + ownerName);
            System.out.println("Vehicle Type       : " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee   : ₹" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object!");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Update registration fee using static method
        Vehicle.updateRegistrationFee(6000.00);

        // Create vehicle objects
        Vehicle v1 = new Vehicle("Rajesh Kumar", "Car", "KA01AB1234");
        Vehicle v2 = new Vehicle("Priya Mehra", "Scooter", "DL05XY9876");

        // Display vehicle details
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
