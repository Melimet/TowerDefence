package domain;

public class Invader {
    private int hp;
    private int movementSpeed;
    private int bounty;
    private int x; //Coordinates
    private int y;

    public Invader(int hp, int movementSpeed, int bounty, int startX, int startY){
        this.hp=hp;
        this.movementSpeed=movementSpeed;
        this.bounty=bounty;
        this.x=startX;
        this.y=startY;
    }
    public void takeDamage(int amount){
        this.hp-=amount;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
