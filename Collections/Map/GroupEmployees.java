import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class GroupEmployees {

    public static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return new HashMap<>();
        }

        return employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        System.out.println("--- Group Objects by Property ---");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        employees.add(new Employee("David", "Finance"));
        employees.add(new Employee("Eve", "IT"));

        System.out.println("Employees: " + employees);
        Map<String, List<Employee>> groupedEmployees = groupEmployeesByDepartment(employees);
        System.out.println("Grouped by Department: " + groupedEmployees);

        List<Employee> emptyList = new ArrayList<>();
        System.out.println("\nEmpty Employee List: " + emptyList);
        System.out.println("Grouped by Department (empty): " + groupEmployeesByDepartment(emptyList));
    }
}
