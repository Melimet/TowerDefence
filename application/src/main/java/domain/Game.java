package domain;

import java.util.ArrayList;

public class Game {
    private int hpPct;
    private int wave;
    private int gold;
    private Map map;

    public Game(String mapFileName, int hpPct) {
        this.hpPct = hpPct;
        this.wave = 0;
        this.gold = 50;
        this.map = new Map(mapFileName);
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
        return this.map.getMapRoute();
    }
    public String getMapName(){
        return this.map.getName();
    }

    public ArrayList<int[]> getPathThroughMap(){
        return this.map.getPathThroughMap();
    }


}
