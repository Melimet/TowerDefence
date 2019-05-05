package domain;

import java.util.ArrayList;

public class Invader {
    private int hp;
    private int movementSpeed;
    private int bounty;
    private double x; //Coordinates
    private double y;
    private double pixelX;
    private double pixelY;
    private ArrayList<int[]> path;
    private int currentStepIndex;

    public Invader(int hp, int movementSpeed, int bounty, ArrayList<int[]> path) {
        this.hp = hp;
        this.movementSpeed = movementSpeed;
        this.bounty = bounty;
        this.path = path;
        this.currentStepIndex = 1;
        setStartingCoordinates();
    }

    private void setStartingCoordinates() {
        this.x = (double) this.path.get(0)[0];
        this.y = (double) this.path.get(0)[1];
        convertXYtoPixelCoordinates();
    }

    public int takeDamage(int amount) {

        this.hp -= amount;
        //Invader returns it's bounty if it's hp goes below 0
        if (this.hp <= 0) {
            return this.bounty;
        }
        return 0;
    }

    public void convertXYtoPixelCoordinates() {

        this.pixelX = this.x * 92 - 43;
        this.pixelY = this.y * 92;
    }

    public void move() {

        if (this.x < this.path.get(this.currentStepIndex)[0]) {
            this.pixelX += 1.0;
        } else {
            this.pixelX -= 1.0;
        }

        if (this.y < this.path.get(this.currentStepIndex)[1]) {
            this.pixelY += 1.0;
        } else {
            this.pixelY -= 1.0;
        }
        checkIfNextStepHasBeenReached();
    }

    public void checkIfNextStepHasBeenReached() {
        if (Math.round(this.pixelX / 92) != this.path.get(currentStepIndex)[0]
                && Math.round(this.pixelY / 92) != this.path.get(currentStepIndex)[1]) {
            this.currentStepIndex++;
            this.x = this.path.get(this.currentStepIndex)[0];
            this.y = this.path.get(this.currentStepIndex)[1];
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
