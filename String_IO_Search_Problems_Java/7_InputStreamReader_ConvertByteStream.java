// Problem: Convert Byte Stream to Character Stream Using InputStreamReader
import java.io.*;

public class InputStreamReader_ConvertByteStream {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("sample.txt"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File reading error.");
        }
    }
}