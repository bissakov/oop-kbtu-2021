import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMapException {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        
        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());
            
            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));            
        }
        
        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);		
                System.out.println(map.getValueAt(size/2, size/2)); 
            }
            catch(Exception e){}
        }
        
        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());  
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }
        
        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }
        
        // Checking the Game class and all of its components
        else if(className.equals("Game")){
            
            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
    }
}

class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Position pos) {
        return (this.x == pos.x && this.y == pos.y);
    }

    public String toString() {
        return "Row: " + Integer.toString(x) + "\nCol: " + Integer.toString(y);
    }
}

class Map {
    private int size;
    private char[][] mapVals;

    public Map(Scanner input) {       
        size = input.nextInt();
        input.nextLine();
        mapVals = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] temp = input.nextLine().toCharArray();
            mapVals[i] = temp;
        }

        input.close();        
    }

    public int getSize() {
        return size;
    }

    public char getValueAt(int x, int y) {
        return mapVals[x][y];
    }

    public void print() {
        for (char[] row : mapVals) {
            System.out.println(row);
        }
    }
}

interface Player {
    public void setMap(Map map);
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public Position getPosition();
}

class MyPlayer implements Player {
    // private int x, y;

    public void setMap(Map map) {

    }

    public void moveRight() {

    }

    public void moveLeft() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    public Position getPosition() {
        
    }   
}

class InvalidMapException extends Exception {
    public InvalidMapException(String str) {
        super(str);
    }
}

class Game {
    public Game(Map map) {

    }

    public void setMap(Map map) {

    }

    public void addPlayer(Player player) {

    }
}

