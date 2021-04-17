package interviews.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StringArrayAnagrams {

	public static void main(String[] args) {
		String[] words = new String[] { "A", "B", "C","1","2" };
		
		List<String> anagramList = generateAnagrams(words);
		
		System.out.println("# of anagrams: " + anagramList.size());
		System.out.println(anagramList);
		
		anagramList = new ArrayList<>();
		
		generateAnagrams(words, new LinkedHashSet<>(), anagramList);
		
		System.out.println("# of anagrams: " + anagramList.size());
		System.out.println(anagramList);

	}

	public static List<String> generateAnagrams(String[] words) {
		List<String> anagramList = new ArrayList<>();
		
		generateAnagrams(words, "", new HashSet<>(), anagramList);
		
		return anagramList;
	}
	
	public static void generateAnagrams(String[] words, String anagram, Set<Integer> usedWords, List<String> anagramList) {
	    if (usedWords.size() == words.length) {
	        anagramList.add(anagram);

	        return;
	    }
	        
	    for (int i = 0; i < words.length; i++) {
	    	if (usedWords.contains(i))
	    		continue;
	    	
	    	usedWords.add(i);
	        
		    generateAnagrams(words, anagram + words[i], usedWords, anagramList);

	    	usedWords.remove(i);
	    }
	}
	
	public static void generateAnagrams(String[] words, LinkedHashSet<String> usedWords, List<String> anagramList) {
	    if (usedWords.size() == words.length) {
	        StringBuffer anagram = new StringBuffer();
	    	
	        for (String word : usedWords) 
	        	anagram.append(word);
	        
	        anagramList.add(anagram.toString());

	        return;
	    }
	        
	    for (int i = 0; i < words.length; i++) {
	    	if (usedWords.contains(words[i]))
	    		continue;
	    	
	    	usedWords.add(words[i]);
	        
		    generateAnagrams(words, usedWords, anagramList);

	    	usedWords.remove(words[i]);
	    }
	}
}
