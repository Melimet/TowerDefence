package domain;

import java.util.ArrayList;

public class Invader {
    private int hp;
    private int movementSpeed;
    private int bounty;
    private double x; //Coordinates
    private double y;
    private ArrayList<int[]> path;

    public Invader(int hp, int movementSpeed, int bounty, ArrayList<int[]> path) {
        this.hp = hp;
        this.movementSpeed = movementSpeed;
        this.bounty = bounty;
        this.path = path;
        setStartingCoordinates();
    }

    private void setStartingCoordinates(){
        this.x = (double) this.path.get(0)[0];
        this.y = (double) this.path.get(0)[1];
    }

    public int takeDamage(int amount) {

        this.hp -= amount;
        //Invader returns it's bounty if it's hp goes below 0
        if (this.hp <= 0) {
            return this.bounty;
        }
        return 0;
    }

    public int getHp() {
        return this.hp;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
