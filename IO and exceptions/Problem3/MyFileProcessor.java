import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class MyFileProcessor {
    static int lineCount = 0;
    static int wordCount = 0;

    static void readFile(String inputName) throws FileNotFoundException {
        File input = new File(inputName);
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\\W+");
            lineCount += 1;
            wordCount += arr.length;
        }

        scanner.close();
    }

    static void writeToFile(String outputName) throws FileNotFoundException{
        File output = new File(outputName);
        PrintWriter printWriter = new PrintWriter(output);
        printWriter.write(outputName + "\n\n" + "Lines " + lineCount + "\n" + "Words " + wordCount);
        printWriter.flush();
        printWriter.close();
    }
    
    public static void main(String[] args) {
        try {
            readFile("input.txt");
            writeToFile("output.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("The system cannot find the file input.txt");
            System.out.println("Exception: \t" + e.getClass().getName());
        }
    }
}
