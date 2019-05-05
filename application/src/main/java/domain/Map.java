package domain;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * Map class holds information about the map and about the path that the invaders will go through.
 */
public class Map {
    private String name;
    private ArrayList<Wave> waves;
    private int[][] mapRoute;
    private ArrayList<int[]> pathThroughMap;

    /**
     * Constructor for Map. Initializes a 7x7 grid.
     *
     * @param filename Filename given by user in the configuration menu.
     */
    public Map(String filename) {
        this.mapRoute = new int[7][7];
        this.pathThroughMap = new ArrayList<>();
        initializeMap(filename);
    }

    /**
     * Initializes the map for the game. This is done by reading the .txt file.
     *
     * @param filename Filename given by user in the configuration menu.
     */
    private void initializeMap(String filename) {

        ArrayList<String> fileContents = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/"+filename))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                fileContents.add(row);
            }

            this.name = fileContents.get(0);

            for (int i = 1; i < fileContents.size(); i++) {

                String[] coordinates = fileContents.get(i).split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                this.pathThroughMap.add(new int[]{x, y});

                //If true, it is the end of the route
                if (i == fileContents.size() - 1) {
                    this.mapRoute[x][y] = 2;
                } else { //Normal road
                    this.mapRoute[x][y] = 1;
                }
            }
        } catch (Exception e) {
            //TODO: Make a more user friendly error report
            System.out.println(e);
        }
    }

    public String getName() {
        return this.name;
    }

    public int[][] getMapRoute() {
        return mapRoute;
    }

    public ArrayList<int[]> getPathThroughMap() {
        return this.pathThroughMap;
    }
}
