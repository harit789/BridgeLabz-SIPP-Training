public class StringConcatPerformance {

    public static void testStringConcat(int n) {
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a"; // creates new object every time
        }
        long end = System.nanoTime();
        System.out.println("String concat time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void testStringBuilderConcat(int n) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder concat time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void testStringBufferConcat(int n) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("StringBuffer concat time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        int n = 1_000_000; // Try 1_000 or 10_000 for shorter tests

        System.out.println("Testing with " + n + " concatenations:\n");

        // Uncomment String test for small n, as it's very slow for 1_000_000
        // testStringConcat(n);

        testStringBuilderConcat(n);
        testStringBufferConcat(n);
    }
}
