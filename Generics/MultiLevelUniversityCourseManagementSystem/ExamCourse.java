package Generics.MultiLevelUniversityCourseManagementSystem;

public class ExamCourse extends CourseType {
    private int numberOfExams;

    public ExamCourse(String courseName, String courseCode, int numberOfExams) {
        super(courseName, courseCode);
        this.numberOfExams = numberOfExams;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Exam-Based Course: " + getCourseName() + " (" + getCourseCode() + ") - Number of Exams: " + numberOfExams);
    }
}