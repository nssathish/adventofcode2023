import java.util.ArrayList;
import java.util.TreeMap;

public class Problem2 {
    public static int solve() {
        String[] input = new String[] {
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen",
        };

        return _solve(input);
    }

    private static int _solve(String[] input) {
        int sum = 0;
        for (var str : input) {
            var numbers = getNumbersFromWords(str);
            var firstNumber = numbers[0];
            var lastNumber = numbers[numbers.length - 1];

            if (lastNumber.isBlank()) lastNumber = firstNumber;

            sum += Integer.parseInt ( firstNumber + lastNumber );
        }
        return sum;
    }

    private static String[] getNumbersFromWords (String str) {
        ArrayList<String> numbers = new ArrayList<> (  );
        int i = 0;
        while (i < str.length ( )) {
            var ch = str.charAt ( i );
            if (AocUtility.tryParse ( ch )) {
                numbers.add ( Character.toString ( ch ) );
                i++;
            }
            else {
                var number = AocUtility.parseNumberFromWord ( str, i );
                if (!number.isBlank ())
                    numbers.add ( number );
            }
        }

        return numbers.toArray ( new String[numbers.size ( )] );
    }
}