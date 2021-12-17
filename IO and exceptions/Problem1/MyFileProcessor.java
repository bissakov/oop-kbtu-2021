import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MyFileProcessor {
    public static void main(String[] args) {
        String fileName = "input.txt";
        try {
            File f = new File(fileName);
            Scanner scanner = new Scanner(f);

            //throw exception if file is empty instead of not printing anything
            if (!scanner.hasNextLine()) {
                scanner.close();
                throw new NoSuchElementException();
            }
            
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The system cannot find the file " + fileName);
            System.out.println("Exception: \t" + e.getClass().getName());
        }
        catch (NoSuchElementException e) {
            System.out.println("No line found in the file " + fileName);
            System.out.println("Exception: \t" + e.getClass().getName());
        }
    }
}
