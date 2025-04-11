import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandlerDemo {

    // File path
    static String filePath = "example.txt";

    public static void main(String[] args) {
        try {
            // Step 1: Write to file
            writeFile("Hello, this is a test file.\nJava is fun to learn!");

            // Step 2: Read the file
            System.out.println("Original File Content:");
            readFile();

            // Step 3: Modify content (replace 'Java' with 'Python')
            modifyFile("Java", "Python");

            // Step 4: Read again to confirm change
            System.out.println("\nModified File Content:");
            readFile();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Function to write content to file
    public static void writeFile(String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
        System.out.println("✅ File written successfully.");
    }

    // Function to read and display file content
    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Function to modify content in file
    public static void modifyFile(String oldWord, String newWord) throws IOException {
        // Read entire content
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        // Replace word
        content = content.replaceAll(oldWord, newWord);

        // Write back to file
        Files.write(Paths.get(filePath), content.getBytes());

        System.out.println("🔁 File modified successfully: '" + oldWord + "' ➝ '" + newWord + "'");
    }
}
