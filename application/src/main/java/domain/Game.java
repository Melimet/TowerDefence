package domain;

import dao.TowerDao;

import java.util.ArrayList;

public class Game {

    private int hpPct;
    private int wave;
    private int gold;
    private int hitPoints;
    private Map map;
    private ArrayList<Tower> towers;
    private TowerDao towerDao;

    public Game(String mapFileName, int hpPct) {
        this.hpPct = hpPct;
        this.wave = 0;
        this.gold = 50;
        this.hitPoints = 20;
        this.towers = new ArrayList<>();
        this.map = new Map(mapFileName);
        this.towerDao = new TowerDao();
    }

    public boolean buildTurret(int typeId, double x, double y) {
        return true;
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

    public String getMapName() {
        return this.map.getName();
    }

    public int getCurrentHitPoints() {
        return this.hitPoints;
    }

    public int getCurrentGold() {
        return this.gold;
    }

    public ArrayList<int[]> getPathThroughMap() {
        return this.map.getPathThroughMap();
    }


}
