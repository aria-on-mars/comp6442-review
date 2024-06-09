package finalreview.prefinal.pre20192.Q3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyUtil.parseDouble} that is code complete.
 * 
 * @author dongwoo
 *
 */
public class MyUtilTest {

	@Test
	public void test() {
		//start your code
		assertEquals(0, MyUtil.parseDouble(null), 0.01);
		assertEquals(0, MyUtil.parseDouble(""), 0.01);
		assertEquals(2.2, MyUtil.parseDouble("a2.2"), 0.01);

		//end your code
	}

}
