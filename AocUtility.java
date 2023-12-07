import java.util.HashMap;

public class AocUtility {
    public static boolean tryParse(char ch) {
        try {
            Integer.parseInt ( Character.toString ( ch ) );
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    private static HashMap<String, String[]> numbers = new HashMap<> (  ) {{
        put ( "on", new String[] {"one", "1"} );
        put ( "tw", new String[] {"two", "2"} );
        put ( "th", new String[] {"three", "3"} );
        put ( "fo", new String[] {"four", "4"} );
        put ( "fi", new String[] {"five", "5"} );
        put ( "si", new String[] {"six", "6"} );
        put ( "se", new String[] {"seven", "7"} );
        put ( "ei", new String[] {"eight", "8"} );
        put ( "ni", new String[] {"nine", "9"} );
    }};
    public static boolean tryParse(String str) {
        if (str.length () > 1)
            throw new IllegalArgumentException ( "String length can be 1" );

        try {
            Integer.parseInt ( str );
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public static String[] parseNumberFromWord(String str, int index) {
        if (index >= str.length () - 1)
            return new String[] { "", "" };

        var startCharacter = Character.toString(str.charAt ( index )) + str.charAt(index + 1);
        var potentialItem = numbers.getOrDefault ( startCharacter, new String[] { "", "" } );
        var potentialNumberWord = potentialItem[0];
        for (int i = index, j = 0; j < potentialNumberWord.length () && i < str.length (); i++,j++) {
            if (str.charAt ( i ) != potentialNumberWord.charAt ( j )) {
                return new String[] {"", ""};
            }
        }
        return potentialItem;
    }
}
