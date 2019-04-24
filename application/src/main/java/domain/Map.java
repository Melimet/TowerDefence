package domain;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Map {
    private String name;
    private ArrayList<Wave> waves;
    private int[][] mapRoute;

    public Map(String filename) {
        this.mapRoute = new int[7][7];
        initializeMap(filename);
    }

    private void initializeMap(String filename) {

        ArrayList<String> fileContents = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                fileContents.add(row);
            }

            this.name = fileContents.get(0);

            for(int i = 1; i < fileContents.size(); i++){

                String[] coordinates = fileContents.get(i).split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                //If true, it is the end of the route
                if (i == fileContents.size()-1){
                    this.mapRoute[x][y]=2;
                }else { //Normal road
                    this.mapRoute[x][y]=1;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String getName(){
        return this.name;
    }

    public int[][] getMapRoute() {
        return mapRoute;
    }
}
