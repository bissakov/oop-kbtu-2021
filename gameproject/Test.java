import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        input.nextLine();
        char[][] mapVals = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] temp = input.nextLine().replace(" ","").toCharArray();
            if (temp[0] == 'R' || temp[0] == 'L' || temp[0] == 'U' || temp[0] == 'D') {
                System.out.println("Not enough map elements");
                System.exit(0);
            }
            mapVals[i] = temp;
        }

        input.close();

        // System.out.println("!" + mapVals[0][1] + "!");

        // int cnt = 0;

        // for (int i = 0; i < size; i++) {
        // 	System.out.println(cnt);
        // 	cnt += mapVals[i].length;
        // 	for (int j = 0; j < mapVals[i].length; j++) {
        // 		// System.out.print(mapVals[i][j]);
        // 		// System.out.print(" ");
        // 	}
        // 	// System.out.println();
        // }

        // System.out.println(cnt);

        System.out.println();

		for (char[] row : mapVals) {
            for (char c : row) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}