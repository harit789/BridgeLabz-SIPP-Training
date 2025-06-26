import java.util.ArrayList;

class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;

    public Department(String name) {
        this.name = name;
    }
}

class University {
    String name;
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }
}
