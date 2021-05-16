// time: O(log(w) + e)
public static int interspersedBinSearch(String[] words, String key) {
    if (words == null || key == null) return -1;
    
    int low = 0, high = words.length - 1;
    
    while (high >= low) {
        int mid = (high + low) >>> 1;
        
        if ("".equals(words[mid])) {
            for (int left = mid - 1, right = mid + 1; true; left--, right++) {
                if (left < low && right > high) return -1;            
      
                if (left >= low && !words[left].isEmpty()) {
                    mid = left;
                    break;
                }
                
                if (right <= high && !words[right].isEmpty()) {
                    mid = right;
                    break;
                }
            }
        }

        if (words[mid].equals(key)) return mid;
       
        if (key.compareTo(words[mid]) > 0) 
            low = mid + 1;
        else
            high = mid - 1;      
    }
    
    return -1;
}

// test
String[] words = { "", "", "apple", "","", "banana", "pear", "", "", "", "tangerine", "" }
String key = "tangerine"

interspersedBinSearch(words, key)

// debug
words = { "", "", "apple", "","", "banana", "pear", "", "", "", "tangerine", "" }
key = "tangerine"
low = 0, 6
high = 11
mid = 5, 8,9,10
return 10

// algorithm
modified binary search
get mid element 
    if != "" then normal Bin search
    else
        go right until find s != "" or reach high
        if reach high then go left until find s != "" or reach low 
            