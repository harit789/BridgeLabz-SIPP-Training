import java.util.ArrayList;

class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }
}

class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.name + " assigned to " + courseName);
    }

    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
        System.out.println(s.name + " enrolled in " + courseName);
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course c) {
        c.enrollStudent(this);
    }
}
