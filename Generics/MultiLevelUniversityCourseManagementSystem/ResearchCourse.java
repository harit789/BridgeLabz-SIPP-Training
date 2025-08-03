package Generics.MultiLevelUniversityCourseManagementSystem;

public class ResearchCourse extends CourseType {
    private String researchArea;

    public ResearchCourse(String courseName, String courseCode, String researchArea) {
        super(courseName, courseCode);
        this.researchArea = researchArea;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Research-Based Course: " + getCourseName() + " (" + getCourseCode() + ") - Research Area: " + researchArea);
    }
}