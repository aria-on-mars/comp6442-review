package testing.p1;

public class FruitCalculator {
    public static int fruitStringToInt(String fruit) {
        return switch (fruit) {
            case "apple" -> 1;
            case "Banana" -> 3;
            case "peach" -> 10;
            case "Peach" -> 11;
            case "" -> 100;
            default -> 1;
        };
    }

    public static int addFruit(String fruit1, String fruit2) {
        return fruitStringToInt(fruit1) + fruitStringToInt(fruit2) * 2;
    }
}
