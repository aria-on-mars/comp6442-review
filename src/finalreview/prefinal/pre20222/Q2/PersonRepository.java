package finalreview.prefinal.pre20222.Q2;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    static Map<Integer, Person> personMap = new HashMap<Integer, Person>();
    SequenceGenerator sequenceGenerator;

    public Person save(Person person) {
        try {
            System.out.println("Saving person with id = " + person.getId());
            person.setId(sequenceGenerator.nextVal());
            personMap.put(person.getId(), person);
            return person;
        } catch (Exception e) {
            throw new RuntimeException("Problem found!");
        }
    }

    public Person findById(Integer id) {
        return personMap.get(id);
    }

    public boolean setSequenceGenerator(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        return true;
    }
}
