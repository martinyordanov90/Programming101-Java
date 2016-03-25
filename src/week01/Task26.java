package week01;

public class Task26 {
	static boolean anagram(String a, String b) {
    	for(char c : a.toCharArray()) {
    		b = b.replaceFirst(c+"", "");
    	}
    	return b.equals("");
    }
}
