package domain;

public class Game {
    private String mapName;
    private int hpPct;
    private int wave;
    private int gold;
    private Map map;

    public Game(String mapFileName, int hpPct) {
        this.hpPct = hpPct;
        this.wave = 0;
        this.gold = 50;
        this.map = new Map(mapFileName);
        this.mapName = this.map.getName();
    }


    private void findPathThroughMap(){
        int[][] mapCopy = getMapRoute();
        for (int i = 0; i < mapCopy.length; i++){
            for (int j = 0; j < mapCopy[0].length; j++){
            }
        }
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
