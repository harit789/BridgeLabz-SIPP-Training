package EncapsulationAndPlymorphism;

import java.util.*;

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

// Abstract class: Patient
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.printf("Total Bill : ₹%.2f\n", calculateBill());
        viewRecords();
        System.out.println("------------------------------------");
    }

    // Implement interface methods
    @Override
    public void addRecord(String diagnosis) {
        medicalHistory.add(diagnosis);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        if (medicalHistory.isEmpty()) {
            System.out.println("No records available.");
        } else {
            for (String record : medicalHistory) {
                System.out.println(" - " + record);
            }
        }
    }

    // Encapsulated getters (no public setters to restrict changes)
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
}

// InPatient class
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge + 1500; // fixed service fee
    }
}

// OutPatient class
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        Patient p1 = new InPatient("IP001", "Alice", 30, 5, 2000); // 5 days * 2000 + 1500 = 11500
        Patient p2 = new OutPatient("OP101", "Bob", 25, 800);
        Patient p3 = new InPatient("IP002", "Charlie", 45, 3, 2500);

        // Add records (encapsulated)
        p1.addRecord("Fever");
        p1.addRecord("Typhoid");

        p2.addRecord("Cough and Cold");

        p3.addRecord("Fracture - Left Arm");
        p3.addRecord("Surgery Done");

        // Add to list
        patientList.add(p1);
        patientList.add(p2);
        patientList.add(p3);

        // Display using polymorphism
        for (Patient patient : patientList) {
            patient.getPatientDetails();
        }
    }
}
