package app;
import java.util.Scanner;

public class Map {
    private int size;
    private char[][] mapVals;

    public Map(Scanner input) throws InvalidMapException {
        size = input.nextInt();
        if (size == 0) {
            throw new InvalidMapException("Map size can not be zero");
        }
        input.nextLine();
        mapVals = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] temp = input.nextLine().replace(" ","").toCharArray();
            if (temp[0] == 'R' || temp[0] == 'L' || temp[0] == 'U' || temp[0] == 'D') {
                throw new InvalidMapException("Not enough map elements");
            }
            mapVals[i] = temp;
        }

        // input.close();
    }

    public int getSize() {
        return size;
    }

    public char getValueAt(int x, int y) {
        return mapVals[x][y];
    }

    public void setValueAt(int x, int y, char val) {
        mapVals[x][y] = val;
    }

    public void print() {
        for (char[] row : mapVals) {
            for (char c : row) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
