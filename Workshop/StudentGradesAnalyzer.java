package Workshop;
import java.util.Scanner;

public class StudentGradesAnalyzer {
    static final int MAX_SUBJECTS = 5;
    static final int MAX_STUDENTS = 3;

    static class Student {
        String name;
        String id;
        Integer[] grades = new Integer[MAX_SUBJECTS]; // Can be null for missing

        Student(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[MAX_STUDENTS];

        // Input student data
        for (int i = 0; i < MAX_STUDENTS; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter ID of student " + (i + 1) + ": ");
            String id = sc.nextLine();

            students[i] = new Student(name, id);

            for (int j = 0; j < MAX_SUBJECTS; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + " (or -1 if missing): ");
                try {
                    int grade = Integer.parseInt(sc.nextLine());
                    if (grade == -1) {
                        students[i].grades[j] = null;
                    } else if (grade >= 0 && grade <= 100) {
                        students[i].grades[j] = grade;
                    } else {
                        throw new IllegalArgumentException("Grade must be between 0 and 100");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Setting grade as missing.");
                    students[i].grades[j] = null;
                }
            }
        }

        // Display analysis
        System.out.println("\n--- Student Total and Average Grades ---");
        for (Student s : students) {
            int total = 0, count = 0;
            for (Integer g : s.grades) {
                if (g != null) {
                    total += g;
                    count++;
                }
            }
            double avg = (count > 0) ? (double) total / count : 0;
            System.out.println("Student " + s.name + " (ID: " + s.id + ") - Total: " + total + ", Average: " + avg);
        }

        System.out.println("\n--- Highest Grade in Each Subject ---");
        for (int subj = 0; subj < MAX_SUBJECTS; subj++) {
            int max = -1;
            for (Student s : students) {
                Integer grade = s.grades[subj];
                if (grade != null && grade > max) {
                    max = grade;
                }
            }
            System.out.println("Subject " + (subj + 1) + " - Highest Grade: " + ((max == -1) ? "No valid grades" : max));
        }

        System.out.println("\n--- Overall Class Average ---");
        int totalGrades = 0, validGrades = 0;
        for (Student s : students) {
            for (Integer g : s.grades) {
                if (g != null) {
                    totalGrades += g;
                    validGrades++;
                }
            }
        }
        double classAverage = (validGrades > 0) ? (double) totalGrades / validGrades : 0;
        System.out.println("Class Average: " + classAverage);
    }
}

