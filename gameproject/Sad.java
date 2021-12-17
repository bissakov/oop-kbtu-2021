package Important;

import java.util.Scanner;
import java.util.NoSuchElementException;



/*
Enter your code here.
Create all the necessary classes and methods as per the requirements.
*/
class Position{
    public int x;
    public int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean equals(Position position){
        boolean result = (this.x == position.getX() && this.y == position.getY());
        return result;
    }
    public String toString(){
        String result = "(" + getX() + "," + getY() + ")";
        return result;
    }
}

class Map {
    public Scanner input;
    public int size;
    public char[][] array;
    Map(Scanner input) throws InvalidMapException {
        try{
            throw new InvalidMapException("123456");
        } catch (InvalidMapException e) {
            e.getMessage();
        }
        this.input = input;
        size = input.nextInt();
        array = new char[size][size];
        try{
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String str = input.next();
                    array[i][j] = str.charAt(0);
                }
            }
        }catch(NoSuchElementException e){
            System.out.println("Not enough map elements");
            System.exit(0);
        }


    }
    public int getSize(){
        return size;
    }
    public char getValueAt(int x, int y){
        return array[x][y];
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MyPlayer implements Player {
    public Map map;
    public Position position;

    public void setMap(Map map){
        this.map = map;
        Position position = null;
        for (int i = 0; i < map.getSize(); i++){
            for (int j = 0; j < map.getSize(); j++){
                if (map.array[i][j] == 'P'){
                    position = new Position(j, i);
                }
            }
        }
        this.position = position;
    }
    public void moveRight(){
        int horizontalPos = position.getX();
        int verticalPos = position.getY();
        boolean isPlayerOnMap = horizontalPos+1 > -1 && horizontalPos+1 < map.size;
        if (isPlayerOnMap) {
            if (map.array[verticalPos][horizontalPos+1] == '0') {
                map.array[verticalPos][horizontalPos + 1] = 'P';
                map.array[verticalPos][horizontalPos] = '0';
                position.setX(position.getX() + 1);
            }
        }
        else position.setX(position.getX());
    }
    public void moveLeft(){
        int horizontalPos = position.getX();
        int verticalPos = position.getY();
        boolean isPlayerOnMap = horizontalPos-1 > -1 && horizontalPos-1 < map.size;
        if (isPlayerOnMap){
            if (map.array[verticalPos][horizontalPos-1] == '0'){
                map.array[verticalPos][horizontalPos-1] = 'P';
                map.array[verticalPos][horizontalPos] = '0';
                position.setX(position.getX()-1);
            }
        }
        else position.setX(position.getX());
    }
    public void moveUp(){
        int horizontalPos = position.getX();
        int verticalPos = position.getY();
        boolean isPlayerOnMap = verticalPos-1 > -1 && verticalPos-1 < map.size;
        if (isPlayerOnMap) {
            if (map.array[verticalPos-1][horizontalPos] == '0') {
                map.array[verticalPos - 1][horizontalPos] = 'P';
                map.array[verticalPos][horizontalPos] = '0';
                position.setY(position.getY() - 1);
            }
        }
        else position.setY(position.getY());
    }
    public void moveDown() {
        int horizontalPos = position.getX();
        int verticalPos = position.getY();
        boolean isPlayerOnMap = verticalPos+1 > -1 && verticalPos+1 < map.size;
        if (isPlayerOnMap){
            if (map.array[verticalPos+1][horizontalPos] == '0') {
                map.array[verticalPos +1][horizontalPos] = 'P';
                map.array[verticalPos][horizontalPos] = '0';
                position.setY(position.getY() + 1);
            }
        }
        else position.setY(position.getY());
    }
    public Position getPosition(){
        return position;
    }
}

interface Player{
    void setMap(Map map);
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    Position getPosition();
}

class Game{
    public Map map;
    public Player player;

    Game(Map map) throws InvalidMapException {
        this.map = map;
        if(map.size == 0){
            throw new InvalidMapException("Map size can not be zero");
        }
    }
    public void setMap(Map map){
    }
    public void addPlayer(Player player){
        this.player = player;
        player.setMap(map);
    }
}

class InvalidMapException extends Exception{
    private static final long serialVersionUID = 1L;

    public InvalidMapException(){
        super();
    }

    public InvalidMapException(String string){
        super(string);
    }
}
/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points
for implementing some classes completely and correctly,
even if other classes are complete but still may not work properly.
*/
public class TanksOfSDU-frame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();

        // Checking the implementation of the Examples.Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());

            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        }

        // Checking the implementation of the Examples.Map class
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

        // Checking the Examples.Player interface and the Examples.MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }

        // Checking the Examples.InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }

        // Checking the Examples.Game class and all of its components
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