package domain;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TowerTest {

    private Tower tower;
    private Invader invader;
    private Map map;

    @Before
    public void setUp(){
        this.map = new Map("hello_world2.txt");
        this.tower = new Tower("A",3,1,5.0,1,5,2);
        this.invader = new Invader(3,2,3,1,5, this.map.getPathThroughMap());
    }

    @Test
    public void getY() {
        assertThat(this.tower.getY(),is(2.0));
    }

    @Test
    public void getX() {
        assertThat(this.tower.getX(),is(5.0));
    }
    @Test
    public void towerAttacksIfInRange(){
        assertThat(this.tower.isInAttackRange(invader),is(true));
    }
    @Test
    public void towerDoesntAttackIfNotInRange(){
        Tower tower2 = new Tower("B",3,1,1.0,1,5,2);
        assertThat(tower2.isInAttackRange(invader),is(false));
    }
    @Test
    public void attackingReducesInvaderHp(){
        //assertThat(this.tower.attackInvader(invader),is(0));
        //TODO Update this when attackInvader method progresses
    }
}
