package UseOfKeywords;

public class Student {

    // Static variable shared by all students
    static String universityName = "Global University";
    private static int totalStudents = 0;

    // Instance variables
    private String name;
    private final int rollNumber;  // Final variable
    private String grade;

    // Constructor using 'this' keyword
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;  // Increment count on student creation
    }

    // Static method to display total number of students
    public static void displayTotalStudents() {
        System.out.println("Total Enrolled Students: " + totalStudents);
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name);
        } else {
            System.out.println("Invalid student object!");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("\n--- Student Details ---");
            System.out.println("University Name: " + universityName);
            System.out.println("Name           : " + name);
            System.out.println("Roll Number    : " + rollNumber);
            System.out.println("Grade          : " + grade);
        } else {
            System.out.println("Invalid student object!");
        }
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        // Create student objects
        Student s1 = new Student("Amit Verma", 101, "A");
        Student s2 = new Student("Neha Sharma", 102, "B");

        // Display student details
        s1.displayStudentDetails();
        s2.displayStudentDetails();

        // Update grade for one student
        s2.updateGrade("A+");

        // Display updated details
        s2.displayStudentDetails();

        // Display total students
        Student.displayTotalStudents();
    }
}
