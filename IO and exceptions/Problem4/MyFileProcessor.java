import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MyFileProcessor {
    protected static String text = "";

    public MyFileProcessor() {}

    public void execute() throws MyIllegalStateException {
        throw new MyIllegalStateException("The system could not find the input file.");
    }

    public static void main(String[] args) throws MyIllegalStateException {
        try {
            ReadProcessor rp = new ReadProcessor();
            WriteProcessor wp = new WriteProcessor();

            rp.execute();
            wp.execute();
        }
        catch (MyIllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyIllegalStateException extends Exception {
    public MyIllegalStateException() {}
    public MyIllegalStateException(String str) {
        super(str);
    }
}

class ReadProcessor extends MyFileProcessor {
    public ReadProcessor() {}

    @Override
    public void execute() {
        try {
            File f = new File("input.txt");
            Scanner scanner = new Scanner(f);
            
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                text += (scanner.hasNextLine()) ? data + "\n" : data;
            }
            scanner.close();   
        }
        catch (FileNotFoundException e) {
            text = null;
        }
    }
}

class WriteProcessor extends MyFileProcessor {
    public WriteProcessor() {}

    @Override
    public void execute() throws MyIllegalStateException {
        try {
            File output = new File("output.txt");
            PrintWriter printWriter = new PrintWriter(output);
            
            if (text == null) {
                printWriter.close();
                throw new FileNotFoundException();
            }
            else
            printWriter.write(text);
            
            printWriter.flush();
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            super.execute();
        }
    }
}