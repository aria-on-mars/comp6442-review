package finalreview.prefinal.pre20222.Q1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TreeBuilderTest {



    @Test(timeout = 1000)
    public void testBuildLowerCase() {
        String text = "i Am the KING of THE 10 castle. The castle is my HOME.";
        TreeBuilder builder = new TreeBuilder();
        RBTree<Integer, List<String>> tree = builder.build(text);
        assertEquals(1, tree.getData(1).size());
        assertEquals(3, tree.getData(2).size());
        assertEquals(1, tree.getData(3).size());
        assertNull(tree.getData(4));
        assertNull(tree.getData(5));
        assertEquals(2, tree.getData(6).size());

        assertTrue(tree.getData(1).contains("i"));
        assertTrue(tree.getData(2).contains("of") && tree.getData(2).contains("is") && tree.getData(2).contains("my"));
        assertTrue(tree.getData(3).contains("the"));
        assertTrue(tree.getData(6).contains("castle"));

    }


}
