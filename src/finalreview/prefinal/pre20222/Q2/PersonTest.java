package finalreview.prefinal.pre20222.Q2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PersonTest {

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());

    @Test
    public void testPerson() {
        Person a = new Person("a", 14, "swimmer", true, true);
        assertEquals(340, a.getHealthInsurancePrice().intValue());

        Person b = new Person("b", 33, null, true, true);
        assertEquals(200, b.getHealthInsurancePrice().intValue());

        Person c = new Person("c", 55, "taxidriver", true, true);
        assertEquals(1100, c.getHealthInsurancePrice().intValue());

        Person d = new Person("d", 55, "", false, false);
        assertEquals(360, d.getHealthInsurancePrice().intValue());

        Person e = new Person("e", 55, "", true, false);
        assertEquals(500, e.getHealthInsurancePrice().intValue());

        Person f = new Person("f", 55, "", false, true);
        assertEquals(400, f.getHealthInsurancePrice().intValue());
    }
    // ########## YOUR CODE ENDS HERE ##########

}
