import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileProcessor {
    static String fileName;

    static void readFile(String fName) throws FileNotFoundException{
        File f = new File(fName);
        Scanner scanner = new Scanner(f);
        
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            fileName = "input1.txt";
            readFile(fileName);
        }
        catch (FileNotFoundException e) {
            fileName = "";
            try {
                fileName = "input2.txt";
                readFile(fileName);
            }
            catch (FileNotFoundException ex) {
                fileName = "";
                System.out.println("The system cannot find the files.");
                System.out.println("Exception: \t" + ex.getClass().getName());
                // alternatively System.exit(0) without assigning fileName = "" and if statements in finally statement
            }
        }
        finally {
            System.out.println((fileName == "") ? "\n" + "Files were not opened." : "\n" + fileName + " was successfuly opened.");
        }
    }
}
