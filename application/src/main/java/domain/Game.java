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
        this.gold = 50000;
        this.hitPoints = 20;
        this.towers = new ArrayList<>();
        this.map = new Map(mapFileName);
        this.towerDao = new TowerDao();
    }

    public void buildTower(int typeId, double x, double y) {

        Tower tower = this.towerDao.getTowerById(typeId);

        tower.setXY(x, y);

        if (tower.getCostToBuild() <= this.gold && towerCanBeBuiltThere(tower)) {
            this.gold -= tower.getCostToBuild();
            this.towers.add(tower);

        } else {
            //TODO: Tell user that building a tower isn't possible
            System.out.println("Cant build a tower there.");
        }
    }

    public boolean towerCanBeBuiltThere(Tower tower) {

        for (Tower index : this.towers) {
            if (tower.equals(index)) {
                return false;
            }
        }

        int[][] map = getMapRoute();
        if (map[(int) tower.getY()][(int) tower.getX()] != 0){
            return false;
        }

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

    public ArrayList<Tower> getTowers(){
        return this.towers;
    }
    public ArrayList<int[]> getPathThroughMap() {
        return this.map.getPathThroughMap();
    }


}
