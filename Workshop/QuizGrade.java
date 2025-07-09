package Workshop;
public class QuizGrade {

    // Method to calculate score and print feedback
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Correct");
                score++;
            } else {
                System.out.println("Incorrect (Your answer: " + student[i] + ", Correct: " + correct[i] + ")");
            }
        }

        return score;
    }

    // Main method to test the quiz grading
    public static void main(String[] args) {
        // Sample correct answers
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "B", "C", "D", "A", "B"
        };

        // Sample student answers (can be collected via Scanner too)
        String[] studentAnswers = {
            "a", "b", "d", "D", "A",
            "c", "c", "d", "A", "b"
        };

        System.out.println("Grading Quiz...\n");
        int score = calculateScore(correctAnswers, studentAnswers);

        System.out.println("\nFinal Score: " + score + " out of " + correctAnswers.length);
    }
}