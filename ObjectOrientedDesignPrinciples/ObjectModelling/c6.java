import java.util.ArrayList;

class Patient {
    String name;

    public Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient p) {
        System.out.println("Doctor " + name + " is consulting Patient " + p.name);
    }
}

class Hospital {
    String name;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }
}
