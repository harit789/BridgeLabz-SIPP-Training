package Generics.MultiLevelUniversityCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
    private String courseId;
    private String courseTitle;
    private T courseType;
    private List<String> enrolledStudents;

    public Course(String courseId, String courseTitle, T courseType) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public T getCourseType() {
        return courseType;
    }

    public void addStudent(String studentName) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled in " + courseTitle);
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        courseType.displayCourseDetails();
        System.out.println("Enrolled Students: " + (enrolledStudents.isEmpty() ? "None" : String.join(", ", enrolledStudents)));
    }

    // Wildcard method to display details of any list of courses
    public static void displayCourses(List<? extends CourseType> courses) {
        System.out.println("\n--- Displaying Courses (Wildcard) ---");
        if (courses.isEmpty()) {
            System.out.println("No courses to display.");
            return;
        }
        for (CourseType course : courses) {
            course.displayCourseDetails();
        }
    }
}