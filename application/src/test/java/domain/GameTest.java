package domain;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameTest{

    private Game game;

    @Before
    public void setUp(){
        this.game = new Game("Hello_World2",50);
    }

    @Test
    public void getGold() {
        assertThat(this.game.getGold(),is(50));
    }

    @Test
    public void getWave() {
        assertThat(this.game.getWave(),is(0));
    }
}
