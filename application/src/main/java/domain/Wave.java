package domain;

import java.util.ArrayList;

public class Wave {
    private int index;
    private ArrayList<Invader> invaders;
    private int endRoundBonusGold;

    public Wave(int index, ArrayList<Invader> invaders, int endRoundBonusGold) {

        this.index = index;
        this.invaders = invaders;
        this.endRoundBonusGold = endRoundBonusGold;

    }
}
