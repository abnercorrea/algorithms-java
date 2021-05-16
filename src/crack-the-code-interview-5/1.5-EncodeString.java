// time: O(n), space: O(n)
public static String encode(String s) {
    // Edge cases
    if (s == null || s.isEmpty()) return s;

    StringBuffer encoded = new StringBuffer();
    // Caution!!! it's charAt(i) not charAt[i]
    char prev = s.charAt(0);
    int count = 1;
    
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == prev) 
            count++;
        else {
            encoded.append(prev);
            encoded.append(count);
            
            prev = s.charAt(i);
            // CAUTION!! reset count to 1
            count = 1;    
        }
    }

    encoded.append(prev);
    encoded.append(count);

    return (s.length() <= encoded.length()) ? s : encoded.toString();        
}

// test
encode("aaaaaaaabbbbbcccccdef");
encode("aaabbcde123fffff");
encode("");
encode(null);

// solution
input = "aaabbcde123fffff"
encoded = "a3b2c1d1e1112131f5"
result = input, since encoded.length > input.length
Use string buffer

null -> null
"" -> ""
Decoder needs same edge cases

// Debug
s = "aaaaaaaabbbbbcccccdef"
encoded = ""
prev = a
count = 1
for i = 1 to 20
s[1] = prev = a, count = 2
s[8] = b != prev => prev = a, count = 8 => encoded = "a8", prev = b, count =1
s[13] = c != prev => prev = b, count = 5 => encoded = "a8b5", prev = c, count =1
s[18] = d != prev => prev = c, count = 5 => encoded = "a8b5c5", prev = d, count =1
s[19] = e != prev => prev = d, count = 1 => encoded = "a8b5c5d1", prev = e, count =1
s[20] = f != prev => prev = e, count = 1 => encoded = "a8b5c5d1e1", prev = f, count =1
for end
encoded = "a8b5c5d1e1f1"
encoded length < s length, return encoded

