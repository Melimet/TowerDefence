package domain;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameTest{

    private Game game;
    private Tower tower;

    @Before
    public void setUp(){
        this.game = new Game("hello_world2.txt",50);
        this.tower = new Tower(0, 30, 2, 300, 30,2,3);
    }

    @Test
    public void getGold() {
        assertThat(this.game.getGold(),is(50000));
    }

    @Test
    public void getWave() {
        assertThat(this.game.getWave(),is(0));
    }

    @Test
    public void towerCantBeBuiltInThisTest(){
        assertFalse(this.game.towerCanBeBuiltThere(this.tower));
    }
}
