package Generics.MultiLevelUniversityCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create different types of course evaluations
        ExamCourse mathExam = new ExamCourse("Calculus I", "MATH101", 3);
        AssignmentCourse physicsAssignment = new AssignmentCourse("Physics II", "PHYS202", 5);
        ResearchCourse compSciResearch = new ResearchCourse("Advanced AI", "CS500", "Machine Learning");

        // Create courses using the generic Course class
        Course<ExamCourse> calculusCourse = new Course<>("C001", "Calculus I", mathExam);
        Course<AssignmentCourse> physicsCourse = new Course<>("C002", "Physics II", physicsAssignment);
        Course<ResearchCourse> aiCourse = new Course<>("C003", "Advanced AI", compSciResearch);

        // Enroll students
        calculusCourse.addStudent("Sohil");
        calculusCourse.addStudent("Raj");
        physicsCourse.addStudent("Tanuj");
        aiCourse.addStudent("Tanmay");

        System.out.println("\n============================================");
        System.out.println("  UNIVERSITY COURSE MANAGEMENT - COURSE INFO");
        System.out.println("============================================");

        // Display course information
        System.out.println("\n--- Displaying Course Information ---");
        System.out.println("--------------------------------------------");
        calculusCourse.displayCourseInfo();
        System.out.println("--------------------------------------------");
        physicsCourse.displayCourseInfo();
        System.out.println("--------------------------------------------");
        aiCourse.displayCourseInfo();
        System.out.println("--------------------------------------------");

        // Demonstrate wildcard usage with a list of different course types
        System.out.println("\n--- Displaying All Course Types (Wildcard) ---");
        System.out.println("--------------------------------------------");
        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(mathExam);
        allCourseTypes.add(physicsAssignment);
        allCourseTypes.add(compSciResearch);

        Course.displayCourses(allCourseTypes);
        System.out.println("--------------------------------------------");
    }
}