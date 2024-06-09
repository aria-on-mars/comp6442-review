package finalreview.prefinal.pre20201.Q3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 *
 * @author nanwang
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE
		// method1: find reminder
		// method2: find the greatest common divisor
		// method3: find the least common multiple

		// method2(n1, n2) == 36, method3(n1, n3) == method3(n2, n4), n3 > n4, method1(n3, n4) != 15
		assertEquals(504, Something.someMethod(108, 180, 180, 108));
		// method2(n1, n2) == 36, method3(n1, n3) != method3(n2, n4), n3 < n4, method1(n3, n4) != 15
		assertEquals(288, Something.someMethod(108, 180, 7, 10));
		// method2(n1, n2) != 36, n3 > n4, method1(n3, n4) == 15
		assertEquals(47, Something.someMethod(108, 181, 31, 16));

		// END YOUR CODE
	}
}
