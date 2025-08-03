package Generics.MultiLevelUniversityCourseManagementSystem;

public class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(String courseName, String courseCode, int numberOfAssignments) {
        super(courseName, courseCode);
        this.numberOfAssignments = numberOfAssignments;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Assignment-Based Course: " + getCourseName() + " (" + getCourseCode() + ") - Number of Assignments: " + numberOfAssignments);
    }
}