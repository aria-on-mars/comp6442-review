package testing.c4;

/**
 * Example class for testing
 */
public class SomeClass {

	/*
	*  Example method for testing	
	*  @param a examble boolean input
	*  @param b examble boolean input
	*  @param c examble boolean input
	*/
	public static boolean someMethod(boolean a, boolean b, boolean c) {
		if(a) {
			a = true;
			return a;
		}else { 
			a = false;
			if(b) {
				b = true;
				return b;
			}
			return a;
		}
//		if(c) {
//			a = true;
//			return c;
//		};
	}
}