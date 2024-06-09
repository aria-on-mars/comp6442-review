package finalreview.prefinal.pre20222.Q2;

public class Person {

    Integer id;
    String name;
    Integer age;
    String occupation;
    boolean diabetes;
    boolean heartDisease;
    Integer healthInsurancePrice;

    public Person(String name, Integer age, String occupation, boolean diabetes, boolean heartDisease) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.diabetes = diabetes;
        this.heartDisease = heartDisease;
        calcInsurancePrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean getDiabetes() {
        return diabetes;
    }

    public boolean getHeartDisease() {
        return heartDisease;
    }

    public Integer getHealthInsurancePrice() {
        return healthInsurancePrice;
    }
    
    /**
	 * HINT ABOUT COMPOUND CONDITIONS:
	 * 
	 * Note that Java performs lazy evaluation. When evaluating conditions involving `&&` and
	 * `||`, the language is smart enough to stop evaluating when the rest of the
	 * expression becomes unimportant. 
	 * 
	 * For example, given three conditions <A>, <B>, <C>, there are six branches for <A> && <B> && <C>:
	 * if(<A> && <B> && <C>) {
     *   STMT1;
     * } else{
     * 	 STMT2;
     * }
	 *
	 *      T        T        T
	 * <A>  ——  <B>  ——  <C>  —— STMT1
	 * F| 	    F|       F|
     * STMT2   STMT2    STMT2
     * 
     * So, if <A> is false (F), then <B> and <C> are ignored when evaluating <A> && <B> && <C>. 
     * On the other hand, if <A> is true (T), then <B> will be evaluated as <A> does.
     * 
     * Likewise, there are six branches for <A> || <B> || <C>:
     * 
     * if(<A> || <B> || <C>) {
     *   STMT1;
     * } else{
     * 	 STMT2;
     * }
     * 
     *      F        F        F
	 * <A>  ——  <B>  ——  <C>  ——  STMT2
	 * T| 	    T|       T|
     * STMT1   STMT1    STMT1
     * 
	 */
    public void calcInsurancePrice() {
        if(occupation == null || occupation.equals("taxidriver") || occupation.length() == 0) {
            if(age < 40) {
//                System.out.println("f1");
                this.healthInsurancePrice = 200;
            } else {
                if(heartDisease && diabetes) {
//                    System.out.println("f2");
                    this.healthInsurancePrice = 1100;
                } else if(!heartDisease && !diabetes) {
//                    System.out.println("f3");
                    this.healthInsurancePrice = 360;
                } else if(!heartDisease) {
//                    System.out.println("f4");
                    this.healthInsurancePrice = 500;
                } else {
//                    System.out.println("f5");
                    this.healthInsurancePrice = 400;
                }
            }
        } else {
//            System.out.println("f6");
            this.healthInsurancePrice = 340;
        }
    }
}
