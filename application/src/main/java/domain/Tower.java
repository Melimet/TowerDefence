package domain;

import java.util.Objects;

/**
 * Class for towers.
 */
public class Tower {
    private int id;
    private int costToBuild;
    private int attackSpeed;
    private double attackRange;
    private int attackDamage;
    private double x; //Coordinates for the location where it was built
    private double y;
    private double pixelX;
    private double pixelY;

    /**
     * Constructor for Tower.
     *
     * @param id           Used to tell what type of a tower it is.
     * @param costToBuild  How much building one of these is going to cost.
     * @param attackSpeed  How fast the turret attacks.
     * @param attackRange  How far the turret can attack.
     * @param attackDamage How much damage the turret does with each attack.
     * @param x            x coordinate, converted to 7x7 grid instead of pixel values
     * @param y            y coordinate, converted to 7x7 grid instead of pixel values
     */
    public Tower(int id, int costToBuild, int attackSpeed, double attackRange, int attackDamage, double x, double y) {
        this.id = id;
        this.costToBuild = costToBuild;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
        this.x = x;
        this.y = y;

    }

    /**
     * Using Pythagoras' theorem to calculate distance between the tower and invader.
     *
     * @param invader The invader who is going to be checked if attacking is possible.
     * @return Returns true if attacking is possible, else false.
     */
    public boolean isInAttackRange(Invader invader) {

        double distance = Math.sqrt
                (Math.pow(invader.getX() - this.getX(), 2)
                        + (Math.pow(invader.getY() - this.getY(), 2)));

        if (distance <= this.attackRange) {
            return true;
        }

        return false;
    }

    /**
     * Damages an invader and checks if it died. If an invader dies it returns a value that is higher than 0.
     *
     * @param invader Invader who is going to be attacked
     */
    public void attackInvader(Invader invader) {
        //If invader dies it returns a value that is higher than 0
        int possibleBounty = invader.takeDamage(this.attackDamage);
        if (possibleBounty > 0) {
            //TODO Remove invader from ArrayList
        }
        //TODO Create cooldown after attacking so turret wont attack everything on each turn
    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }

    public double getPixelX() {
        return this.pixelX;
    }

    public double getPixelY() {
        return this.pixelY;
    }

    /**
     * Converts x and y from pixel values to 7x7 grid. Then changes pixel values so they are in the middle of the grid.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public void convertXY(double x, double y) {

        this.x = Math.round(x / 92);
        this.y = Math.round(y / 92);

        this.pixelX = this.x * 92;
        this.pixelY = this.y * 92 + 45;
    }

    public int getCostToBuild() {
        return this.costToBuild;
    }

    /**
     * Checks if the turrets are on the same tile.
     *
     * @param o Tower that is going to be compared to this object
     * @return Returns true if both towers share the same x and y coordinates
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tower tower = (Tower) o;
        return Double.compare(tower.x, x) == 0 &&
                Double.compare(tower.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getId(){
        return this.id;
    }
}
