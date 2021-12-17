package app;

public class MyPlayer implements Player {
    private Map map;
    private Position position;
    private int mapSize;
    private int posX, posY;
    private boolean isWithinBounds;

    public void setMap(Map mp) {
        map = mp;
        position = null;

        mapSize = map.getSize();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map.getValueAt(i, j) == 'P') {
                    position = new Position(j, i);
                }
            }
        }
    }

    public void moveRight() {
        posX = position.getX();
        posY = position.getY();
        isWithinBounds = (posX + 1) > -1 && (posX + 1) < mapSize;

        if (isWithinBounds) {
            if (map.getValueAt(posY, posX + 1) == '0') {
                map.setValueAt(posY, posX + 1, 'P');
                map.setValueAt(posY, posX, '0');
                position.setX(position.getX() + 1);
            }
        }
        else {
            position.setX(position.getX());
        }
    }

    public void moveLeft() {
        posX = position.getX();
        posY = position.getY();
        isWithinBounds = (posX - 1) > -1 && (posX - 1) < mapSize;

        if (isWithinBounds) {
            if (map.getValueAt(posY, posX - 1) == '0') {
                map.setValueAt(posY, posX - 1, 'P');
                map.setValueAt(posY, posX, '0');
                position.setX(position.getX() - 1);
            }
        }
        else {
            position.setX(position.getX());
        }
    }

    public void moveUp() {
        posX = position.getX();
        posY = position.getY();
        isWithinBounds = (posY - 1) > -1 && (posY - 1) < mapSize;

        if (isWithinBounds) {
            if (map.getValueAt(posY - 1, posX) == '0') {
                map.setValueAt(posY - 1, posX, 'P');
                map.setValueAt(posY, posX, '0');
                position.setY(position.getY() - 1);
            }
        }
        else {
            position.setY(position.getY());
        }
    }

    public void moveDown() {
        posX = position.getX();
        posY = position.getY();
        isWithinBounds = (posY + 1) > -1 && (posY + 1) < mapSize;

        if (isWithinBounds) {
            if (map.getValueAt(posY + 1, posX) == '0') {
                map.setValueAt(posY + 1, posX, 'P');
                map.setValueAt(posY, posX, '0');
                position.setY(position.getY() + 1);
            }
        }
        else {
            position.setY(position.getY());
        }
    }

    public Position getPosition() {
        return position;
    }   
}