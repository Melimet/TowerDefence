package domain;

import org.junit.*;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WaveTest {

    private Wave wave;
    private ArrayList<Invader> invaders;

    @Before
    public void setUp() {
        ArrayList<int[]> testPath = new ArrayList<>();
        testPath.add(new int[]{0, 0});
        this.invaders = new ArrayList<>();
        this.invaders.add(new Invader(1, 1, testPath));
        this.wave = new Wave(1, this.invaders, 10);
    }

    @Test
    public void spawnInvaderReturnsNullIfNothingToSpawn() {
        this.wave.spawnInvader();
        assertNull(this.wave.spawnInvader());
    }

}
