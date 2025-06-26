import java.util.ArrayList;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
}

class Company {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }
}
