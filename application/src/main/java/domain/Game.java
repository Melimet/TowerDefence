package domain;

public class Game {
    private String mapName;
    private int hpPct;
    private int wave;
    private int gold;
    private Map map;

    public Game(String mapName, int hpPct) {
        this.mapName = mapName;
        this.hpPct = hpPct;
        this.wave = 0;
        this.gold = 50;
        this.map = new Map();
    }

    private void createMap() {
        Map map = new Map();
    }

    private void nextWave() {

    }

    public int getGold() {
        return this.gold;
    }

    public int getWave() {
        return this.wave;
    }

    public int[][] getMapRoute() {
        return map.getMapRoute();
    }


}
