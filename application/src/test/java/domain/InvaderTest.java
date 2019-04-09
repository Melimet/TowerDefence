package domain;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InvaderTest {

    private Invader invader;

    @Before
    public void setUp(){
        this.invader = new Invader(3,2,2,1,5);
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
