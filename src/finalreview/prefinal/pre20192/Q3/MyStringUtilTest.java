package finalreview.prefinal.pre20192.Q3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyStringUtil.isMixedCase} that is branch complete.
 */
public class MyStringUtilTest {

	@Test
	public void test() {
		//start your code
		assertEquals(false, MyStringUtil.isMixedCase(null));
		assertEquals(false, MyStringUtil.isMixedCase(""));
		assertEquals(false, MyStringUtil.isMixedCase("a"));
		assertEquals(true, MyStringUtil.isMixedCase("Aaa"));

		//end your code
	}

}
