package domain;

import java.util.ArrayList;

public class Map {
    private String name;
    private ArrayList<Wave> waves;
    private int[][] mapRoute;

    public Map() {
        this.name = "hello_world2";
        this.mapRoute = new int[7][7];
        initializeMap();
    }

    private void initializeMap() {
        //TODO change this from being hardcoded to something less stupid
        this.mapRoute[0][0] = 1;
        this.mapRoute[0][1] = 1;
        this.mapRoute[1][1] = 1;
        this.mapRoute[1][2] = 1;
        this.mapRoute[1][3] = 1;
        this.mapRoute[1][4] = 1;
        this.mapRoute[1][5] = 1;
        this.mapRoute[2][5] = 1;
        this.mapRoute[3][5] = 1;
        this.mapRoute[4][5] = 1;
        this.mapRoute[4][4] = 1;
        this.mapRoute[4][3] = 1;
        this.mapRoute[3][3] = 1;
        this.mapRoute[3][2] = 1;
        this.mapRoute[3][1] = 1;
        this.mapRoute[4][1] = 1;
        this.mapRoute[5][1] = 1;
        for (int i = 1; i < 6; i++) {
            this.mapRoute[6][i] = 1;
        }
        this.mapRoute[6][6] = 2;
    }

    public int[][] getMapRoute() {
        return mapRoute;
    }
}
