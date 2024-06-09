package testing.p2;

/*
 * There are two methods in AdvancedCalculator: greatestCommonDivisor and leastCommonMultiple.
 * There are 4 AdvancedCalculator classes: AdvancedCalculator0, AdvancedCalculator1, AdvancedCalculator2 and AdvancedCalculator3.
 * Note that if any of the input is non-positive, the result should be 0.
 * Please use the class and Junit test to find the class with correct methods.
 * */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdvancedCalculatorTest {
    // TODO: set up parameters and test cases to find the correct AdvancedCalculator class

    @Parameters
    public static AdvancedCalculator[] setCalculatorsData() {
            return new AdvancedCalculator[] {new AdvancedCalculator0(), new AdvancedCalculator1(), new AdvancedCalculator2(), new AdvancedCalculator3()};
    }

    @Parameter
    public AdvancedCalculator advancedCalculator;


    @Test
    public void testGreatestCommonDivisorLeftNegative() {
        assertEquals(0, advancedCalculator.greatestCommonDivisor(-1, 5));
    }

    @Test
    public void testGreatestCommonDivisorRightNegative() {
        assertEquals(0, advancedCalculator.greatestCommonDivisor(5, -1));
    }

    @Test
    public void testGreatestCommonDivisorLeftZero() {
        assertEquals(0, advancedCalculator.greatestCommonDivisor(0, 234));
    }

    @Test
    public void testGreatestCommonDivisorRightZero() {
        assertEquals(0, advancedCalculator.greatestCommonDivisor(45, 0));
    }

    @Test
    public void testGreatestCommonDivisorGeneral() {
        assertEquals(2, advancedCalculator.greatestCommonDivisor(6, 2));
    }

    @Test(timeout = 5000)
    public void testLestCommonMultipleLeftNegative() {
        assertEquals(0, advancedCalculator.leastCommonMultiple(-1, 4));
    }

    @Test(timeout = 5000)
    public void testLestCommonMultipleRightNegative() {
        assertEquals(0, advancedCalculator.leastCommonMultiple(6, -2));
    }

    @Test(timeout = 5000)
    public void testLestCommonMultipleLeftZero() {
        assertEquals(0, advancedCalculator.leastCommonMultiple(0, 4));
    }

    @Test(timeout = 5000)
    public void testLestCommonMultipleRightZero() {

        assertEquals(0, advancedCalculator.leastCommonMultiple(4, 0));
    }

    @Test(timeout = 5000)
    public void testLestCommonMultipleGeneral() {

        assertEquals(12, advancedCalculator.leastCommonMultiple(6, 4));
    }

}
