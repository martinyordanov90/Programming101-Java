package week01;

import java.util.HashMap;
import java.util.Map;

public class Task27 {
	static boolean hasAnagramOf(String a, String b) {
    	char[] pattern = a.toCharArray();
    	char[] text = b.toCharArray();
    	int patLength = pattern.length;
    	int txtLength = text.length;
    	
    	if (patLength > txtLength) {
    		return false;
    	}
    	
    	Map<Character, Integer> countPat = new HashMap<>();
    	Map<Character, Integer> countTxt = new HashMap<>();
    	for (int i = 0; i < patLength; i++) {
    		int currPat;
    		if (!countPat.containsKey(pattern[i])) {
    			currPat = 0;
    		} else {
    			currPat = countPat.get(pattern[i]);
    		}
    		int currTxt;
    		if (!countTxt.containsKey(text[i])) {
    			currTxt = 0;
    		} else {
    			currTxt = countTxt.get(text[i]);
    		}
    		
    		countPat.put(pattern[i], currPat + 1);
    		countTxt.put(text[i], currTxt + 1);
    	}
    	for (int i = patLength; i < txtLength; i++) {
    		if (countPat.equals(countTxt)) {
    			return true;
    		}
    		int currTxt;
    		if (!countTxt.containsKey(text[i])) {
    			currTxt = 0;
    		} else {
    			currTxt = countTxt.get(text[i]);
    		}
    		countTxt.put(text[i], currTxt + 1);
    		countTxt.put(text[i - patLength], countTxt.get(text[i - patLength]) - 1);
    	}
    	if (countPat.equals(countTxt)) {
    		return true;
    	}
    	return false;
    }
}
