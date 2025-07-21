public class FibonacciBenchmark {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println("\nFibonacci of " + n);

            if (n <= 30) { // Avoids infinite wait
                long startRec = System.nanoTime();
                int resultRec = fibonacciRecursive(n);
                long endRec = System.nanoTime();
                System.out.println("Recursive result: " + resultRec + " | Time: " + (endRec - startRec) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Recursive result: Skipped (Too Slow)");
            }

            long startItr = System.nanoTime();
            int resultItr = fibonacciIterative(n);
            long endItr = System.nanoTime();
            System.out.println("Iterative result: " + resultItr + " | Time: " + (endItr - startItr) / 1_000_000.0 + " ms");
        }
    }
}
