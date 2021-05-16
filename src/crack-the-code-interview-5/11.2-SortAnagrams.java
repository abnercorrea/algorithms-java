public static String sortChars(String s) {
    if (s == null) return null;
    
    char[] chars = s.toCharArray();
    
    Arrays.sort(chars);
    
    return new String(chars); 
}

public static int compareAnagrams(String s1, String s2) {
    // CAUTION!!! input check null!!!!
    if (s1 == null && s2 == null) return 0;
    if (s1 == null) return -1;
    if (s2 == null) return 1;
    
    return sortChars(s1).compareTo(sortChars(s2)); 
}

// time: O(n * log(n) * s * log(s)) where s is the size of the strings
// space: O(s)
public static void sortAnagrams(String[] words) {
    Arrays.sort(words, (s1, s2) -> compareAnagrams(s1, s2));
}

// Test
String[] words = { "car", "dog", "cat", "listen", "ribbon", "arc", "god", "silent" } 

sortAnagrams(words)

String[] words2 = { "car", "dog", "cat", null, "listen", null, "ribbon", null, "arc", "god", "silent" } 

sortAnagrams(words2)
