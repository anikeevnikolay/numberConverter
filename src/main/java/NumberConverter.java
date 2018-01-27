import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antiz_000 on 1/25/2018.
 */
public class NumberConverter {

    private Map<Long, String> basicNumbers;
    private Map<Long, String> firstConditionNumbers;
    private Map<Long, String> secondConditionNumbers;
    private Map<Long, String> thirdConditionNumbers;
    private final String SPACE = " ";
    private long maxValue;

    {
        firstConditionNumbers = Constants.getFirstConditionNumbers();
        secondConditionNumbers = Constants.getSecondConditionNumbers();
        thirdConditionNumbers = Constants.getThirdConditionNumbers();

        firstConditionNumbers.forEach((aLong1, s) -> {
            if (!secondConditionNumbers.containsKey(aLong1))
                secondConditionNumbers.put(aLong1, s);
            if (!thirdConditionNumbers.containsKey(aLong1))
                thirdConditionNumbers.put(aLong1, s);
        });

        /* /1000 */
        basicNumbers = new HashMap<>();
        firstConditionNumbers.keySet()
                .stream()
                .filter(x -> x >= 1000 && (x % 1000 == 0))
                .forEach(aLong -> basicNumbers.put(aLong, firstConditionNumbers.get(aLong)));

        maxValue = firstConditionNumbers.keySet().stream().max(Long::compare).get();
    }

    public String convertFromNumber(long n) {
        Object[] res = convertFromNumber(n, (short) 1);
        return (String) res[0];
    }

    private Object[] convertFromNumber(long n, short condition) {
        /* if we don't know name of this number */
        if (n >= maxValue * 1000) {
            Object[] result = convertFromNumber(n / maxValue, getCondition(n));
            String theBiggestResult = (String) result[0];
            String normalResult = (String) convertFromNumber(n % maxValue, (Short) result[1])[0];
            Object[] output = {theBiggestResult + SPACE + normalResult, 1};
            return output;
        }
        /* if we know the name we will divide it by 1000 into necessary number of parts */
        StringBuilder sb = new StringBuilder();
        Comparator<Long> longComparator = Long::compare;
        basicNumbers.keySet()
                .stream()
                .sorted(longComparator.reversed())
                .filter(basis -> basis < n)
                .forEach(basis -> {
                    long curNum = (n / basis) % 1000;
                    sb.append(printThreeNumbers(curNum, (short) (basis == 1000L ? 2 : 1)));
                    if (basis >= 1000) {
                        short newCondition = getCondition(curNum);
                        switch (newCondition) {
                            case 1:
                                sb.append(firstConditionNumbers.get(basis));
                                break;
                            case 2:
                                sb.append(secondConditionNumbers.get(basis));
                                break;
                            case 3:
                                sb.append(thirdConditionNumbers.get(basis));
                                break;
                        }
                        sb.append(SPACE);
                    }
                });
        sb.append(printThreeNumbers(n % 1000, (short) 1));
        return new Object[]{sb.toString(), getCondition(n)};
    }

    private String printThreeNumbers(long curNum, short condition) {
        StringBuilder sb = new StringBuilder();
        if (curNum / 100 != 0)
            sb.append(firstConditionNumbers.get((curNum / 100) * 100))
                    .append(SPACE);
        if (curNum % 100 <= 20 && curNum % 100 > 0) {
            if (condition == 1)
                sb.append(firstConditionNumbers.get(curNum % 100))
                        .append(SPACE);
            else
                sb.append(secondConditionNumbers.get(curNum % 100))
                        .append(SPACE);
        } else {
            if ((curNum % 100) / 10 > 0) {
                sb.append(firstConditionNumbers.get(((curNum % 100) / 10) * 10))
                        .append(SPACE);
            }
            if (curNum % 10 != 0) {
                if (condition == 1)
                    sb.append(firstConditionNumbers.get(curNum % 10));
                else
                    sb.append(secondConditionNumbers.get(curNum % 10));
                sb.append(SPACE);
            }
        }
        return sb.toString();
    }

    public long convertFromString(String n) {
        long result = 0;

        /* all numbers */
        Map<String, Long> allNumbers = new HashMap<>();

        firstConditionNumbers.forEach((aLong, s) -> allNumbers.put(s, aLong));
        secondConditionNumbers.forEach((aLong, s) -> allNumbers.put(s, aLong));
        thirdConditionNumbers.forEach((aLong, s) -> allNumbers.put(s, aLong));

        Map<String, Long> reversedBasis = new HashMap<>();
        basicNumbers.forEach((aLong, s) -> {
            reversedBasis.put(s, aLong);
            reversedBasis.put(secondConditionNumbers.get(aLong), aLong);
            reversedBasis.put(thirdConditionNumbers.get(aLong), aLong);
        });


        String[] numbersStr = n.split(" ");
        int currNum = 0;
        for (String numStr : numbersStr) {
            if (reversedBasis.containsKey(numStr)) {
                if (currNum == 0)
                    result += 1 * reversedBasis.get(numStr);
                else {
                    result += currNum * reversedBasis.get(numStr);
                    currNum = 0;
                }
            } else {
                currNum += allNumbers.get(numStr);
            }
        }
        result += currNum;

        return result;
    }

    /* condition: 1 = 1; 2 = 2..4; 3 = 5..20*/
    private short getCondition(long n) {
        n = n % 100;
        if (n > 4 && n <= 20)
            return 3;
        n = n % 10;
        if (n == 1)
            return 1;
        if (n > 1 && n < 5)
            return 2;
        return 3;
    }
}
