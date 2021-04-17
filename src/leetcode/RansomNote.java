package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String word, String magazine) {
        if (word.length() > magazine.length()) return false;

        Map<Character, Integer> charSet = new HashMap();

        for (Character c: magazine.toCharArray())
            if (charSet.containsKey(c))
                charSet.put(c, charSet.get(c) + 1);
            else
                charSet.put(c, 1);

        int found = 0;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);

            if (charSet.containsKey(c)) {
                found++;

                int count = charSet.get(c);

                if (count == 1)
                    charSet.remove(c);
                else
                    charSet.put(c, count - 1);
            }
        }

        return found == word.length();

    }
}