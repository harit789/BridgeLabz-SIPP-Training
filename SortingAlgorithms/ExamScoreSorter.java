public class ExamScoreSorter {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void printScores(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] examScores = {85, 72, 90, 60, 78, 88};

        System.out.println("Original Exam Scores:");
        printScores(examScores);

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores (Ascending):");
        printScores(examScores);
    }
}
