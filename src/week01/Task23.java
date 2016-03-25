package week01;

public class Task23 {
	static int countOccurrences(String needle, String haystack) {
    	int occurences = 0;
    	while (haystack.contains(needle)) {
    		haystack = haystack.replaceFirst(needle, "");
    		occurences++;
    	}
    	return occurences;
    }
}
