public class StudentMarksSorter {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void printMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentMarks = {78, 95, 45, 89, 62, 55};

        System.out.println("Original Marks:");
        printMarks(studentMarks);

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks (Ascending):");
        printMarks(studentMarks);
    }
}
