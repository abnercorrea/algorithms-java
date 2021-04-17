package java;

import java.util.Arrays;
import java.util.regex.Pattern;


public class StringDemo {

    public static void main(String[] args) {
        String word = "   Word   ";

        System.out.println(word + " , length = " + word.length());
        word = word.trim();
        System.out.println(word + " , length after trim() = " + word.length());
        System.out.println("equals(word): " + "word".equals(word));
        System.out.println("equalsIgnoreCase(word): " + "word".equalsIgnoreCase(word));

        // StringBuffer is thread safe
        // StringBuilder in NOT
        // Choose accordingly... if in a data race (multi-thread, at least one is writing), use buffer otherwise use builder.
        StringBuilder alphabetBuilder = new StringBuilder("ABC");
        alphabetBuilder.append("DEFGHIJKLMN");
        alphabetBuilder.append("OPQRST");
        alphabetBuilder.append("UVWXYZ");

        String alphabet = alphabetBuilder.toString();

        System.out.println(alphabet);

        // REVERSE
        System.out.println("Reverse (from StringBuilder): " + alphabetBuilder.reverse());

        System.out.println("substring(5): " + alphabet.substring(5)); // begin index INCLUSIVE
        // end index is EXCLUSIVE!!!
        System.out.println("substring(2, 6): " + alphabet.substring(2, 6));

        System.out.println("Upper case: " + alphabet.toUpperCase());
        System.out.println("Lower case: " + alphabet.toLowerCase());
        System.out.println("to char array: " + Arrays.toString(alphabet.toCharArray()));

        System.out.println("endsWith(XYZ): " + alphabet.endsWith("XYZ"));
        System.out.println("startsWith(ABC): " + alphabet.startsWith("ABC"));

        int pos = alphabet.indexOf("OPQ", 0);
        System.out.println("indexOf(OPQ, 0): " + pos);
        // pos in INCLUSIVE!!! RETURNS -1 IF NOT FOUND!!!!
        System.out.println("indexOf(OPQ, pos + 1): " + alphabet.indexOf("OPQ", pos + 1));

        String splitStr = "All  poems have   wolves in    them";

        System.out.println("String to split: " + splitStr);

        // " " can be used to represent a space. \\s is better.
        System.out.println("Split array (' '): " + Arrays.toString(splitStr.split(" ")));
        // in \\s{1,3}, \\s represents a space and {1,3} is a counter specifying 1 to 3 spaces. VERY USEFULL!!!
        System.out.println("Split array (\\s{1,3}): " + Arrays.toString(splitStr.split("\\s{1,3}")));
        // in \\s{1,}, {1,} means at least 1 space (unbounded upper limit). VERY USEFULL!!!
        System.out.println("Split array (\\s{1,}): " + Arrays.toString(splitStr.split("\\s{1,}")));

        // SPLIT STRING using pattern
        Pattern spaces = Pattern.compile("\\s{1,}");
        System.out.println("Pattern split (\\s{1,}): " + Arrays.toString(spaces.split(splitStr)));


        String str = "adddadacbbcbbbbcccb";
        System.out.println("longestUnique2CharSubStr(" + str + ") = " + longestUnique2CharSubStr(str));

    }

    /**
     * @param input
     * @return
     */
    public static String longestUnique2CharSubStr(String input) {
        int start = 0, end = 0, maxStart = 0, maxEnd = 0, i = 0;
        int length = input.length();
        char char1 = 0, char2 = 0;

        char1 = input.charAt(start);
        for (i = 1; i < length && input.charAt(i) == char1; i++) ;

        if (i == length) {
            return null; // only 1 char type in the string
        }

        char2 = input.charAt(i);
        end = i;
        maxStart = start;
        maxEnd = end;
        i++;

        while (i < length && (length - 1 - start) > (maxEnd - maxStart)) {
            for (; i < length && (input.charAt(i) == char1 || input.charAt(i) == char2); i++) ;

            end = i - 1;

            if (end - start > maxEnd - maxStart) {
                maxEnd = end;
                maxStart = start;
            }

            if (i < length) {
                char1 = input.charAt(i - 1);
                char2 = input.charAt(i);
                end = i;
                for (i = i - 1; input.charAt(i - 1) == char1; i--) ;
                start = i;
            }
        }

        return input.substring(maxStart, maxEnd + 1); // maxEnd + 1 since for substring method, end boundary is exclusive
    }

}
