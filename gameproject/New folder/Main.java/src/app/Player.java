package app;

public interface Player {
    public void setMap(Map map);
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public Position getPosition();
}
