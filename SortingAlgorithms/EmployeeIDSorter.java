public class EmployeeIDSorter {

    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void printIDs(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIDs = {1052, 1023, 1101, 1008, 1077};

        System.out.println("Original Employee IDs:");
        printIDs(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending):");
        printIDs(employeeIDs);
    }
}
