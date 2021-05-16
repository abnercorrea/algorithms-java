// time: O(n^2), space: O(1)
public static boolean uniqueChars(String s) {
    if (s == null || s.isEmpty()) return false;

    for (int i = 0; i < s.length() - 1; i++)
        for (int j = i + 1; j < s.length(); j++)
            if (s.charAt(i) == s.charAt(j)) return false;
    
    return true;
}

// test
uniqueChars("car");
uniqueChars("apple");
uniqueChars("a");
uniqueChars("");
uniqueChars(null);


// debug
s = car
for i = 0 to 1
0:  for j = 1 to 2
    1:  c != a
    2:  c != r
1:  for j = 2 to 2
    2:  a != r
return true 