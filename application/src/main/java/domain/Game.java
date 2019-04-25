package domain;

import dao.TowerDao;

import java.util.ArrayList;

/**
 * This class contains most of the logic and keeps everything together.
 */
public class Game {

    private int hpPct;
    private int wave;
    private int gold;
    private int hitPoints;
    private Map map;
    private ArrayList<Tower> towers;
    private TowerDao towerDao;

    /**
     * Constructor for the game class.
     *
     * @param mapFileName Name for the .txt file that is used for building the map. This file is located in application folder.
     * @param hpPct       This value changes the % of invader hitpoints. With this the difficulty of the game can be altered. Default value is 100.
     */
    public Game(String mapFileName, int hpPct) {
        this.hpPct = hpPct;
        this.wave = 0;
        this.gold = 50000;
        this.hitPoints = 20;
        this.towers = new ArrayList<>();
        this.map = new Map(mapFileName);
        this.towerDao = new TowerDao();
    }

    /**
     * Building of towers is done here. It checks if building a tower is even possible and then proceeds as planned.
     *
     * @param typeId Different towers have different id's in the database so this makes getting the right tower stats possible
     * @param x      x coordinate for where the turret is going to be build
     * @param y      y coordinate for where the turret is going to be build
     */
    public void buildTower(int typeId, double x, double y) {

        Tower tower = this.towerDao.getTowerById(typeId);

        tower.convertXY(x, y);

        if (tower.getCostToBuild() <= this.gold && towerCanBeBuiltThere(tower)) {
            this.gold -= tower.getCostToBuild();
            this.towers.add(tower);

        } else {
            //TODO: Tell user that building a tower isn't possible
            System.out.println("Cant build a tower there.");
        }
    }

    private boolean towerCanBeBuiltThere(Tower tower) {

        for (Tower index : this.towers) {
            if (tower.equals(index)) {
                return false;
            }
        }

        int[][] map = getMapRoute();
        if (map[(int) tower.getY()][(int) tower.getX()] != 0) {
            return false;
        }

        return true;
    }

    private void nextWave() {
        //TODO: this thing
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

    public ArrayList<Tower> getTowers() {
        return this.towers;
    }

    public ArrayList<int[]> getPathThroughMap() {
        return this.map.getPathThroughMap();
    }


}
