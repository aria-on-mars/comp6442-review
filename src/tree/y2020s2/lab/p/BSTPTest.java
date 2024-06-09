package tree.y2020s2.lab.p;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTPTest {
    BSTP<Integer> BSTP;
    /* Diagram of "BSTP"
     *      5
     *    /  \
     *    3   10
     *  /  \    \
     * 1    4    15
     *          /
     *        13
     */

    @Before
    public void setUpBSTP() {
        BSTP = new BSTP<>(5);
        BSTP.insert(10);
        BSTP.insert(15);
        BSTP.insert(13);
        BSTP.insert(3);
        BSTP.insert(1);
        BSTP.insert(4);
    }

    @Test
    public void testInsertion() {
        Assert.assertEquals("5 3 1 4 10 15 13", BSTP.preOrderShow());
    }

    @Test
    public void testDeleteNoChild() {
        BSTP = BSTP.delete(1);
        Assert.assertEquals("5 3 4 10 15 13", BSTP.preOrderShow());
    }

    @Test
    public void testDeleteOneChild() {
        BSTP = BSTP.delete(10);
        Assert.assertEquals("5 3 1 4 15 13", BSTP.preOrderShow());
    }

    @Test
    public void testDeleteTwoChildren() {
        BSTP = BSTP.delete(5);
        Assert.assertEquals("10 3 1 4 15 13", BSTP.preOrderShow());
    }
}
