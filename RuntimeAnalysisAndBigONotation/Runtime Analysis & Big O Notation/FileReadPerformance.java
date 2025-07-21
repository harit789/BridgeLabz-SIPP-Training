import java.io.*;

public class FileReadPerformance {

    // Method 1: Using FileReader
    public static void readWithFileReader(String path) throws IOException {
        long start = System.nanoTime();
        try (FileReader fr = new FileReader(path)) {
            while (fr.read() != -1); // Read char by char
        }
        long end = System.nanoTime();
        System.out.println("FileReader time: " + (end - start) / 1_000_000.0 + " ms");
    }

    // Method 2: Using InputStreamReader
    public static void readWithInputStreamReader(String path) throws IOException {
        long start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(path))) {
            while (isr.read() != -1); // Read char by char
        }
        long end = System.nanoTime();
        System.out.println("InputStreamReader time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "large_test_file.txt"; // Replace with your actual file path

        System.out.println("Reading: " + filePath);
        readWithFileReader(filePath);
        readWithInputStreamReader(filePath);
    }
}
