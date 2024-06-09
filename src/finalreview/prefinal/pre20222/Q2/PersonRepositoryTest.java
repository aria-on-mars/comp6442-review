package finalreview.prefinal.pre20222.Q2;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    @Test(expected = RuntimeException.class)
    public void TestPersonRepository() {
        Person a = new Person("a", 14, "swimmer", true, true);
        personRepository.save(a);
        assertEquals(a, personRepository.findById(1));
        personRepository.setSequenceGenerator(null);
        personRepository.save(a);
    }

    // ########## YOUR CODE ENDS HERE ##########


}
