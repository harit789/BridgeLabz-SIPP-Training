import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
    }

    public void showEnrolledStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enroll(Course c) {
        courses.add(c);
        c.enrollStudent(this);
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    String name;
    ArrayList<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }
}
