package testing.c2;

public class PathComplete {

	/*
	 * This method finds something!
	 * 
	 */
	public static int findSomething(int a, int b, int c) {
		if(a > b) {
			if(a > c) {
				System.out.println("a");
				return a;
			}else {
				System.out.println("c");
				return c;
			}
		}else if(b > c) { 
			System.out.println("b");
			return b;
		}else {
			System.out.println("c");
			return c;
		}
	}
}
/*
* answer:
Statement:
TC 1: a = 5, b = 3, c = 1 (a > b, b > c)
TC 2: a = 5, b = 3, c = 8 (a > b, b < c)
TC 3: a = 5, b = 8, c = 1 (a < b, a > c)
TC 4: a = 5, b = 8, c = 10 (a < b, a < c)

Branch:
TC 1, 2, 3, 4 in statement

Path:
TC 1, 2, 3, 4 in statemetn
 */