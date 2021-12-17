package app;

public class Game {
    private Map map;
    private Player player;

    public Game(Map map) {
        this.map = map;
    }

    public void setMap(Map map) {

    }

    public void addPlayer(Player player) {
        this.player = player;
        this.player.setMap(map);
    }
}
