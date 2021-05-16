/*
given 2 arrays wrds[] , chars[] as an input to a function such that 
wrds[] = [ "abc" , "baa" , "caan" , "an" , "banc" ] 
chars[] = [ "a" , "a" , "n" , "c" , "b"] 
Function should return the longest word from words[] which can be constructed from the chars in chars[] array. 
for above example - "caan" , "banc" should be returned 

Note: Once a character in chars[] array is used, it cant be used again. 
eg: words[] = [ "aat" ] 
characters[] = [ "a" , "t" ] 
then word "aat" can't be constructed, since we've only 1 "a" in chars[].
*/

// time: O(b), space: O(b)
boolean builtFromChars(String word, char[] chars) {
    if (word.length() > chars.length) return false;

    Map<Character, Integer> charSet = new HashMap();
    
    for (Character c: chars) 
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

// time: O(a.b)
List<String> longestMatches(String[] words, char[] chars) {
    if (words == null || chars == null || words.length == 0 || chars.length == 0) return null;

    int maxLength = 0;

    for (int i = 0; i < words.length; i++) {
        if (words[i].length() < maxLength) continue;

        if (builtFromChars(words[i], chars))
            if (words[i].length() > maxLength) maxLength =  words[i].length();
    }

    List<String> result = new ArrayList();

    for (int i = 0; i < words.length; i++)
        if (words[i].length() == maxLength) result.add(words[i]);

    return result;
}
    

longestMatches(new String[] {"abc" , "baa" , "caan" , "an" , "banc"}, new char[] {'a' , 'a' , 'n' , 'c' , 'b'})