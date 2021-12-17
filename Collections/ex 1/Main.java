import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        FileProcessor.fillList();
        FileProcessor.fillMap(map);
        FileProcessor.writeToFile(map);
    }
}

class FileProcessor {
    private static ArrayList<String> wordsList;

    public static void fillList() {
        wordsList = new ArrayList<>();
        try{
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
    
            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\W+");
                for (String word : arr) {
                    wordsList.add(word);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void fillMap(HashMap<String, Integer> map) {
        for (String word : wordsList) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word) + 1);
            }
        }
    }

    public static void writeToFile(HashMap<String, Integer> map) {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            for (String i : map.keySet()) {
                myWriter.write(i + " = " + map.get(i) + "\n");
            }
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}