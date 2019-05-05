package domain;

import java.util.ArrayList;

/**
 * Wave class holds all the information about specific waves.
 */
public class Wave {
    private int index;
    private ArrayList<Invader> invaders;
    private int endRoundBonusGold;

    /**
     * Constructor for wave class.
     *
     * @param index             This is used to tell the difference between wave 1 and 3.
     * @param invaders          Holds all the invaders that are going to be spawned.
     * @param endRoundBonusGold Bonus gold given at the end of a round.
     */
    public Wave(int index, ArrayList<Invader> invaders, int endRoundBonusGold) {

        this.index = index;
        this.invaders = invaders;
        this.endRoundBonusGold = endRoundBonusGold;

    }

    /**
     * Method for spawning invaders. Invader is removed from this.invaders so the same invader wont be spawned multiple times.
     *
     * @return Returns an invader to be spawned.
     */
    public Invader spawnInvader() {
        if (this.invaders.isEmpty()) {
            return null;
        }

        Invader invader = this.invaders.get(0);
        this.invaders.remove(0);
        return invader;
    }

    public int getEndRoundBonusGold() {
        return endRoundBonusGold;
    }
}