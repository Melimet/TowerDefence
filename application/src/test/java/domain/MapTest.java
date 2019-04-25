package domain;

import org.junit.*;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MapTest {
    private Map map;

    @Before
    public void setUp(){
        this.map = new Map("hello_world2.txt");
    }

    @Test
    public void pathThroughMapIsCreatedCorrectly(){
        ArrayList<int[]> testPath = this.map.getPathThroughMap();
        assertThat(testPath.get(0)[0],is(0));
        assertThat(testPath.get(0)[1],is(0));
    }
    @Test
    public void mapRouteIsCreatedCorrectly(){
        int[][] testRoute = this.map.getMapRoute();
        assertThat(testRoute[0][0],is(1));
        assertThat(testRoute[6][6],is(2));
        assertThat(testRoute[0][4],is(0));
    }

}
