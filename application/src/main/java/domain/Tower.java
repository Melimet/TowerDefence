package domain;

import java.util.Objects;

public class Tower {
    private int name;
    private int costToBuild;
    private int attackSpeed;
    private double attackRange;
    private int attackDamage;
    private double x; //Coordinates for the location where it was built
    private double y;
    private double pixelX;
    private double pixelY;

    public Tower(int name, int costToBuild, int attackSpeed, double attackRange, int attackDamage, double x, double y) {
        this.name = name;
        this.costToBuild = costToBuild;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
        this.x = x;
        this.y = y;

    }

    public boolean isInAttackRange(Invader invader) {

        // Using Pythagoras' theorem to calculate distance between the tower and invader

        double distance = Math.sqrt
                (Math.pow(invader.getX() - this.getX(), 2)
                        + (Math.pow(invader.getY() - this.getY(), 2)));

        if (distance <= this.attackRange) {
            return true;
        }

        return false;
    }

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

    public void setXY(double x, double y) {

        this.x = Math.round(x / 92);
        this.y = Math.round(y / 92);

        this.pixelX = this.x * 92;
        this.pixelY = this.y * 92 + 45;
    }

    public int getCostToBuild() {
        return this.costToBuild;
    }

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
}
