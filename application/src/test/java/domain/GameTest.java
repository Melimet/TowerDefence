package domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest{

    @Before
    public void setUp(){
        Game game = new Game("Hello_World2",50);
    }

    @Test
    public void getGold() {
        AssertTrue(game.getGold,is(50));
    }

    @org.junit.Test
    public void getWave() {
        AsserThat(game.getWave,is(0));
    }
}
