package domain;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InvaderTest {

    private Invader invader;
    private Map map;

    @Before
    public void setUp(){
        this.map = new Map("hello_world2.txt");
        this.invader = new Invader(3, 2, this.map.getPathThroughMap());
    }

    @Test
    public void invadersTakeDamage(){
        assertThat(invader.getHp(),is(3));
        invader.takeDamage(1);
        assertThat(invader.getHp(),is(2));
    }
    public void invadersReturnBountyWhenDying(){
        assertThat(invader.takeDamage(3),is(2));
    }
}
