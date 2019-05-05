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
}