/*
Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

boolean canConstruct(String word, String magazine) {
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