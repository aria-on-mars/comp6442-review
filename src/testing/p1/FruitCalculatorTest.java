package testing.p1;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * don't look at the actual code of Fruitcalculator class. Write the test method based on the description.
 * You need to write some test methods to test two static methods of Fruitcalculator class: fruitStringToInt and addFruit.
 * The relationship between the string and int is: "apple" -> 1, "banana" -> 3, "peach" -> 10, other string -> 0.
 * fruitStringToInt takes one string as its input, return one int as its output. Only lowercase is allowed for the fruit names.
 * addFruit takes two string and return the sum of the two strings based on the relationship between the string and the int above.
 * */

public class FruitCalculatorTest {
    @Test
    public void testApple() {

        assertEquals(1, FruitCalculator.fruitStringToInt("apple"));
    }

    @Test
    public void testBanana() {

        assertEquals(3, FruitCalculator.fruitStringToInt("banana"));
    }

    @Test
    public void testPeach() {

        assertEquals(10, FruitCalculator.fruitStringToInt("peach"));
    }

    @Test
    public void testWrongApple() {

        assertEquals(0, FruitCalculator.fruitStringToInt("Apple"));
    }

    @Test
    public void testWrongBanana() {

        assertEquals(0, FruitCalculator.fruitStringToInt("Banana"));
    }

    @Test
    public void testWrongPeach() {

        assertEquals(0, FruitCalculator.fruitStringToInt("Peach"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, FruitCalculator.fruitStringToInt(""));
    }

    @Test
    public void testOtherString() {
        assertEquals(0, FruitCalculator.fruitStringToInt("aweoji12o3"));
    }

    @Test
    public void testAddAppleBanana() {
        assertEquals(4, FruitCalculator.addFruit("apple", "banana"));
    }

    @Test
    public void testAddApplePeach() {
        assertEquals(11, FruitCalculator.addFruit("apple", "peach"));
    }

    @Test
    public void testAddBananaPeach() {
        assertEquals(13, FruitCalculator.addFruit("banana", "peach"));
    }

    @Test
    public void testAddTwoApples() {
        assertEquals(2, FruitCalculator.addFruit("apple", "apple"));
    }

    @Test
    public void testAddTwoBananas() {
        assertEquals(6, FruitCalculator.addFruit("banana", "banana"));
    }

    @Test
    public void testAddTwoPeaches() {
        assertEquals(20, FruitCalculator.addFruit("peach", "peach"));
    }

    @Test
    public void testAddAppleEmpty() {
        assertEquals(1, FruitCalculator.addFruit("apple", ""));
    }

    @Test
    public void testAddAppleRandom() {
        assertEquals(1, FruitCalculator.addFruit("apple", "wer234"));
    }

    @Test
    public void testAddBananaEmpty() {
        assertEquals(5, FruitCalculator.addFruit("banana", ""));
    }

    @Test
    public void testAddBananaRandom() {
        assertEquals(5, FruitCalculator.addFruit("banana", "wer234"));
    }

    @Test
    public void testAddPeachEmpty() {
        assertEquals(10, FruitCalculator.addFruit("peach", ""));
    }

    @Test
    public void testAddPeachRandom() {
        assertEquals(10, FruitCalculator.addFruit("peach", "wer234"));
    }
}
