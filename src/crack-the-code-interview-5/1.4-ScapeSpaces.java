// time O(n), where n = real length of string
// space O(1)
public static void escapeSpaces(char[] s, int len) {
    if (s == null || s.isEmpty()) return;
            
    // Caution!!! the for condition is evaluated on every step, if len is updated, the for goes on.
    for (int i = 0; i < len; i++)
        if (s[i] == ' ') {
            // Shift right
            for (int j = len + 1; j > i + 2; j--) s[j] = s[j - 2];
            
            s[i] = '%';
            s[i + 1] = '2';
            s[i + 2] = '0';
            i+=2;
            len+=2;
        }
}

// Debug
s = carpe diem buddy
len = 16
for i = 0 to 19
5:  s = carpe%20diem buddy
    len = 18
    i = 7
12: for j = 19 to 15
        s = carpe%20diem bubuddy        
    s = carpe%20diem%20buddy
    i = 14
    len = 20

// test

public static char[] init(String s) {
    int spaces = 0;
    Character[] chars = s.toCharArray();
    
    for (char c: chars) if (c == ' ') spaces++;
    
    Character[] result = new Character[s.length() + spaces * 2];
    System.arrayCopy(chars, chars.length, result, 0, chars.length);
    
    return result;
}


