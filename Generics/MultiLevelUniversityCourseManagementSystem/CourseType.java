package Generics.MultiLevelUniversityCourseManagementSystem;

public abstract class CourseType {
    private String courseName;
    private String courseCode;

    public CourseType(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public abstract void displayCourseDetails();
}