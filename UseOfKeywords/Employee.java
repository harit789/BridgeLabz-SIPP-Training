package UseOfKeywords;

public class Employee {
    
    // Static variable shared by all Employee objects
    static String companyName = "TechNova Solutions";
    private static int totalEmployees = 0;

    // Instance variables
    private String name;
    private final int id; // Final variable (cannot be changed)
    private String designation;

    // Constructor using 'this' keyword
    public Employee(String name, int id, String designation) {
        this.name = name;                // Resolves ambiguity
        this.id = id;
        this.designation = designation;
        totalEmployees++;               // Increments count
    }

    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {  // instanceof check
            System.out.println("\n--- Employee Details ---");
            System.out.println("Company Name : " + companyName);
            System.out.println("Employee ID  : " + id);
            System.out.println("Name         : " + name);
            System.out.println("Designation  : " + designation);
        } else {
            System.out.println("Invalid object type!");
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Displaying company name using static variable
        System.out.println("Welcome to " + Employee.companyName);

        // Creating employee objects
        Employee emp1 = new Employee("Sumit Kumar", 101, "Software Engineer");
        Employee emp2 = new Employee("Anjali Sharma", 102, "HR Manager");

        // Displaying employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();

        // Displaying total number of employees
        Employee.displayTotalEmployees();
    }
}

