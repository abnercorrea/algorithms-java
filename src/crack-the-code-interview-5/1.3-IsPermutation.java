// time: O(n), n is the length of string a
// space: O(n) 
public static boolean isPermutation(String a, String b) {
    // Caution!! empty is a permutation of empty
    if (a == null && b == null) return true;
    // Caution!!! it's length() and not length
    if (a == null || b == null || a.length() != b.length()) return false;
    
    // Caution!!! it's Character and not Char
    Map<Character, Integer> chars = new HashMap();
    
    // loads map with each character count of a
    for (char c: a.toCharArray()) {
        Integer count = chars.get(c);
        
        chars.put(c, (count == null) ? 1 : count +1);
    }
                
    for (char c: b.toCharArray()) {
        Integer count = chars.get(c);
        
        if (count == null) return false;
        
        if (count == 1)
            chars.remove(c);
        else    
            chars.put(c, count - 1);
    }
    
    return chars.isEmpty();
}

// Another way to implement is to sort and compare
// time: O(n.log(n)), space: O(n)
public static boolean isPermutation(String a, String b) {
    // Caution!! empty is a permutation of empty
    if (a == null && b == null) return true;
    // Caution!!! it's length() and not length
    if (a == null || b == null || a.length() != b.length()) return false;
    
    char[] ca = a.toCharArray(), cb = b.toCharArray();
    Arrays.sort(ca)
    Arrays.sort(cb)
    
    return Arrays.equals(ca, cb);`
}

isPermutation("god", "dog");
isPermutation("ABCDEFGHIJ", "JIHGFEDCBA");
isPermutation("", "");

isPermutation("apple", "aplet");
isPermutation("apple", "ape");
isPermutation("god", null);
isPermutation(null, null);

// Debug
a = "god"
b = "dog"
// after first for
chars = { g:1, o:1, d:1 }
// after second for
chars = { }
chars is empty, returns true;


a = "apple"
b = "aplet"
chars = { a:1, p:2, l:1, e:1 }
chars = { p:1 }
returns false, "t" not found in chars


a = "apple"
b = ape
returns false, different lengths