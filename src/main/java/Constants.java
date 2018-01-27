import java.util.HashMap;
import java.util.Map;

/**
 * Created by antiz_000 on 1/26/2018.
 */
public class Constants {

    public static Map<Long, String> getFirstConditionNumbers() {
        Map<Long, String> result = new HashMap<>();

        result.put(1L, "один");
        result.put(2L, "два");
        result.put(3L, "три");
        result.put(4L, "четыре");
        result.put(5L, "пять");
        result.put(6L, "шесть");
        result.put(7L, "семь");
        result.put(8L, "восемь");
        result.put(9L, "девять");
        result.put(10L, "десять");
        result.put(11L, "одиннадцать");
        result.put(12L, "двенадцать");
        result.put(13L, "тринадцать");
        result.put(14L, "четырнадцать");
        result.put(15L, "пятнадцать");
        result.put(16L, "шестнадцать");
        result.put(17L, "семнадцать");
        result.put(18L, "восемнадцать");
        result.put(19L, "девятнадцать");
        result.put(20L, "двадцать");
        result.put(30L, "тридцать");
        result.put(40L, "сорок");
        result.put(50L, "пятьдесят");
        result.put(60L, "шестьдесят");
        result.put(70L, "семьдесят");
        result.put(80L, "восемьдесят");
        result.put(90L, "девяносто");
        result.put(100L, "сто");
        result.put(200L, "двести");
        result.put(300L, "триста");
        result.put(400L, "четыреста");
        result.put(500L, "пятьсот");
        result.put(600L, "шестьсот");
        result.put(700L, "семьсот");
        result.put(800L, "восемьсот");
        result.put(900L, "девятьсот");
        result.put(1000L, "тысяча");
        result.put(1000000L, "миллион");
        result.put(1000000000L, "миллиард");
        result.put(1000000000000L, "триллион");
        result.put(1000000000000000L, "квадриллион");

        return result;
    }

    public static Map<Long, String> getSecondConditionNumbers() {
        Map<Long, String> result = new HashMap<>();

        result.put(1L, "одна");
        result.put(2L, "две");
        result.put(1000L, "тысячи");
        result.put(1000000L, "миллиона");
        result.put(1000000000L, "миллиарда");
        result.put(1000000000000L, "триллиона");
        result.put(1000000000000000L, "квадриллиона");

        return result;
    }

    public static Map<Long, String> getThirdConditionNumbers() {
        Map<Long, String> result = new HashMap<>();

        result.put(1000L, "тысяч");
        result.put(1000000L, "миллионов");
        result.put(1000000000L, "миллиардов");
        result.put(1000000000000L, "триллионов");
        result.put(1000000000000000L, "квадриллионов");

        return result;
    }
}
