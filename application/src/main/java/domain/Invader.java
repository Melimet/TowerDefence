package domain;

import java.util.ArrayList;

/**
 * Invader class
 */
public class Invader {
    private int hp;
    private int bounty;
    private double x; //Coordinates
    private double y;
    private double pixelX;
    private double pixelY;
    private ArrayList<int[]> path;
    private int currentStepIndex;

    /**
     * Constructor for Invader class.
     * @param hp Hit points
     * @param bounty Amount of gold given when invader dies
     * @param path Path that the invader is meant to take to reach end
     */
    public Invader(int hp, int bounty, ArrayList<int[]> path) {
        this.hp = hp;
        this.bounty = bounty;
        this.path = path;
        this.currentStepIndex = 0;
        setStartingCoordinates();
    }

    /**
     * Sets starting coordinates
     */
    private void setStartingCoordinates() {
        this.x = (double) this.path.get(0)[0];
        this.y = (double) this.path.get(0)[1];
        convertXYtoPixelCoordinates();
    }

    /**
     * Invader loses hp
     * @param amount Amount of hp reduced
     * @return Returns a value other than 0 if it died
     */
    public int takeDamage(int amount) {

        this.hp -= amount;
        //Invader returns it's bounty if it's hp goes below 0
        if (this.hp <= 0) {
            return this.bounty;
        }
        return 0;
    }

    /**
     * Multiplies normal coordinate values by 92 for pixel values used in ui class
     */
    public void convertXYtoPixelCoordinates() {

        this.pixelX = this.x * 92;
        this.pixelY = this.y * 92;
    }

    /**
     * moves invader
     */
    public void move() {

        if (this.x < this.path.get(this.currentStepIndex)[0]) {
            this.pixelX+= 1.0;
        } else if (this.x > this.path.get(this.currentStepIndex)[0]){
            this.pixelX -= 1.0;
        }

        if (this.y < this.path.get(this.currentStepIndex)[1]) {
            this.pixelY += 1.0;
        } else if (this.y > this.path.get(this.currentStepIndex)[1]){
            this.pixelY -= 1.0;
        }
        checkIfNextStepHasBeenReached();
    }

    /**
     * Updates next direction for invader
     */
    public void checkIfNextStepHasBeenReached() {
        if (Math.floor(this.pixelX / 92) == this.path.get(currentStepIndex)[0]
                && Math.floor(this.pixelY / 92) == this.path.get(currentStepIndex)[1]) {

            this.x = this.path.get(this.currentStepIndex)[0];
            this.y = this.path.get(this.currentStepIndex)[1];
            this.currentStepIndex++;
        }
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

    public double getPixelX() {
        return this.pixelX;
    }

    public double getPixelY() {
        return this.pixelY;
    }
}
