package domain;

public class Tower {
    private String name;
    private int costToBuild;
    private int attackSpeed;
    private double attackRange;
    private int attackDamage;
    private double x; //Coordinates for the location where it was built

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    private double y;

    public Tower(String name, int costToBuild, int attackSpeed, double attackRange, int attackDamage, double x, double y) {
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
        if(possibleBounty>0){
            //TODO Remove invader from ArrayList
        }
        //TODO Create cooldown after attacking so turret wont attack everything on each turn
    }
}
