package finalreview.prefinal.pre20191.Q4;//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MyIntegerTest {

	@Test
	public void test() {
		// TODO: Write a minimum set of test cases that are code complete
//		 for MyInteger.parseInt method.
//		 Use assertEquals and assertThrows to test whether the method works as expected.
//
//		 All test cases should be included in this method. Do not create another method.
//		 Auto grader will not check the other methods created individually.
        assertEquals(4, MyInteger.parseInt("4"));
        assertThrows(NumberFormatException.class, () -> MyInteger.parseInt("<"));
        assertThrows(NumberFormatException.class, () -> MyInteger.parseInt("("));
    }
}
