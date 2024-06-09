package finalreview.prefinal.pre20191.Q4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

	@Test
	public void test() {
		//TODO: Write a minimum set of test cases that are branch complete
		// to test StringUtil.collapseNewlines method via assertEquals for test cases.
		//
		// All test cases should be included in this method. Do not create another method.
		// Auto grader will not check the other methods created individually
        assertEquals("", StringUtil.collapseNewlines(""));
        assertEquals("ab\n", StringUtil.collapseNewlines("ab\n\n"));
	}

}
