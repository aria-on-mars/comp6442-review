package testing.p3;

public class CodeCoverageQuiz {
    public void workMethod(int a, int b) {
        if (a > b) {
            if (a > 1) {
                System.out.println(a);
                a = b + 1;
            }
            System.out.println(b);
        }
        for (int i = 0; i < 2; i++) {
            if (a > b) {
                b++;
            }
            System.out.println(a);
        }
    }
}

/*
* answer:
Statement:
TC 1: a = 6, b = 3 (a > b, a > 1, a > b, a <= b)
TC 2: a = 0, b = - 3 (a > b, a <= 1, a – b > 2)

Branch:
TC 1 in statement
TC 2 in statement
TC 3: a = 0, b = 3 (a <= b, a <= b, a <= b)

Path:
TC 1, 2, 3 in branch
TC 4: a = 0, b = - 1 (a > b, a <= 1, a – b <= 1)

* */