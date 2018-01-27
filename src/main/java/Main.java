import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by antiz_000 on 1/25/2018.
 */
public class Main {

    public static void main(String... args) {
        NumberConverter numberConverter = new NumberConverter();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String readStr = "";
        while (true) {
            System.out.println("Введите число или строку:");
            try {
                readStr = keyboard.readLine();
                if (!"".equals(readStr))
                    System.out.println(numberConverter.convertFromNumber(Long.valueOf(readStr)));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                try {
                    System.out.println(numberConverter.convertFromString(readStr));
                } catch (NullPointerException e1) {
                    System.out.println("неизвестная строка");
                }
            }
            System.out.println("-------------------------------------");
        }
    }
}
