import java.util.HashMap;
import java.util.Map;

/**
 * Created by antiz_000 on 1/26/2018.
 */
public class Constants {

    private static Map<Long, String> firstConditionNumbers;
    private static Map<Long, String> secondConditionNumbers;
    private static Map<Long, String> thirdConditionNumbers;
    private static Map<Long, String> basicNumbers;

    static {
        firstConditionNumbers = new HashMap<>();

        firstConditionNumbers.put(1L, "один");
        firstConditionNumbers.put(2L, "два");
        firstConditionNumbers.put(3L, "три");
        firstConditionNumbers.put(4L, "четыре");
        firstConditionNumbers.put(5L, "пять");
        firstConditionNumbers.put(6L, "шесть");
        firstConditionNumbers.put(7L, "семь");
        firstConditionNumbers.put(8L, "восемь");
        firstConditionNumbers.put(9L, "девять");
        firstConditionNumbers.put(10L, "десять");
        firstConditionNumbers.put(11L, "одиннадцать");
        firstConditionNumbers.put(12L, "двенадцать");
        firstConditionNumbers.put(13L, "тринадцать");
        firstConditionNumbers.put(14L, "четырнадцать");
        firstConditionNumbers.put(15L, "пятнадцать");
        firstConditionNumbers.put(16L, "шестнадцать");
        firstConditionNumbers.put(17L, "семнадцать");
        firstConditionNumbers.put(18L, "восемнадцать");
        firstConditionNumbers.put(19L, "девятнадцать");
        firstConditionNumbers.put(20L, "двадцать");
        firstConditionNumbers.put(30L, "тридцать");
        firstConditionNumbers.put(40L, "сорок");
        firstConditionNumbers.put(50L, "пятьдесят");
        firstConditionNumbers.put(60L, "шестьдесят");
        firstConditionNumbers.put(70L, "семьдесят");
        firstConditionNumbers.put(80L, "восемьдесят");
        firstConditionNumbers.put(90L, "девяносто");
        firstConditionNumbers.put(100L, "сто");
        firstConditionNumbers.put(200L, "двести");
        firstConditionNumbers.put(300L, "триста");
        firstConditionNumbers.put(400L, "четыреста");
        firstConditionNumbers.put(500L, "пятьсот");
        firstConditionNumbers.put(600L, "шестьсот");
        firstConditionNumbers.put(700L, "семьсот");
        firstConditionNumbers.put(800L, "восемьсот");
        firstConditionNumbers.put(900L, "девятьсот");
        firstConditionNumbers.put(1000L, "тысяча");
        firstConditionNumbers.put(1000000L, "миллион");
        firstConditionNumbers.put(1000000000L, "миллиард");
        firstConditionNumbers.put(1000000000000L, "триллион");
        firstConditionNumbers.put(1000000000000000L, "квадриллион");

        secondConditionNumbers = new HashMap<>();

        secondConditionNumbers.put(1L, "одна");
        secondConditionNumbers.put(2L, "две");
        secondConditionNumbers.put(1000L, "тысячи");
        secondConditionNumbers.put(1000000L, "миллиона");
        secondConditionNumbers.put(1000000000L, "миллиарда");
        secondConditionNumbers.put(1000000000000L, "триллиона");
        secondConditionNumbers.put(1000000000000000L, "квадриллиона");

        thirdConditionNumbers = new HashMap<>();

        thirdConditionNumbers.put(1000L, "тысяч");
        thirdConditionNumbers.put(1000000L, "миллионов");
        thirdConditionNumbers.put(1000000000L, "миллиардов");
        thirdConditionNumbers.put(1000000000000L, "триллионов");
        thirdConditionNumbers.put(1000000000000000L, "квадриллионов");

        basicNumbers = new HashMap<>();
        firstConditionNumbers.keySet()
                .stream()
                .filter(x -> x >= 1000 && (x % 1000 == 0))
                .forEach(aLong -> basicNumbers.put(aLong, firstConditionNumbers.get(aLong)));
    }

    public static Map<Long, String> getFirstConditionNumbers() {
        return firstConditionNumbers;
    }

    public static Map<Long, String> getSecondConditionNumbers() {
        return secondConditionNumbers;
    }

    public static Map<Long, String> getThirdConditionNumbers() {
        return thirdConditionNumbers;
    }

    public static Map<Long, String> getBasicNumbers() {
        return basicNumbers;
    }

}
