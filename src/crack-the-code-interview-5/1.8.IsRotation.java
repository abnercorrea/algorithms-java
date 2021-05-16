public static boolean isSubstring(String s1, String s2) {
    return s1.indexOf(s2) != -1;
}

// ELEGANT WAY to do it: 
isSubstring(s1 + s1, s2)

// This is a TRICKY question
// time: O(n), space: O(n)
public static boolean isRotation(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    // have to check this since we're using isSubstring
    // "ABCDEFGAG", "DEFGABC"
    if (s1.length() != s2.length()) return false;
    // code below fails for length = 0 and makes no sense for length = 1  
    if (s1.length() < 2) return s1.equals(s2);
        
    char[] lastFirst = { s1.charAt(s1.length() - 1), s1.charAt(0) };
    
    // Carefull!!!! needs to get the right most place where last-first happens
    // Ex: "ABCDEFGAG", "CDEFGAGAB" fails if you don't get the right most "GA"
    int pos = s2.lastIndexOf(new String(lastFirst));
    
    // s2.substring(pos + 1) + s2.substring(0, pos + 1), reverts s2 to look like s1
    // Eg: (s1=abcd, s2=cdab -> ab + cd = abcd = s1)
    // isSubstring is used as string compare
    return isSubstring(s1, s2.substring(pos + 1) + s2.substring(0, pos + 1));
}

// Tests and edge cases
// True
isRotation("waterbottle", "bottlewater");
isRotation("ABCDEFGAG", "CDEFGAGAB");
isRotation("A", "A");
isRotation("", "");

// False
isRotation("ABC", "CBA");
isRotation("ABCDEFGAG", "DEFGABC");
isRotation("A", "B");
isRotation("A", "");
isRotation("A", null);
isRotation(null, null);



