package UseOfKeywords;

public class Patient {

    // Static variable shared among all patients
    static String hospitalName = "CityCare Hospital";
    private static int totalPatients = 0;

    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final String patientID;  // Final variable

    // Constructor using 'this' keyword
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;  // Increase patient count
    }

    // Static method to get total admitted patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("\n--- Patient Details ---");
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID   : " + patientID);
            System.out.println("Name         : " + name);
            System.out.println("Age          : " + age);
            System.out.println("Ailment      : " + ailment);
        } else {
            System.out.println("Invalid patient object!");
        }
    }

    // Main method to test the Patient class
    public static void main(String[] args) {
        // Creating patient objects
        Patient p1 = new Patient("Ravi Kumar", 45, "Fever", "P001");
        Patient p2 = new Patient("Sunita Singh", 30, "Fracture", "P002");

        // Display patient details
        p1.displayPatientDetails();
        p2.displayPatientDetails();

        // Display total patients admitted
        Patient.getTotalPatients();
    }
}
