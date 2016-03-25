package week01;

public class Task22 {
	static int getPalindromeLength(String input) {
    	String[] sides = input.split("\\*");
    	char[] left = Task17.reverseMe(sides[0]).toCharArray();
    	char[] right = sides[1].toCharArray();
    	int i = -1;
    	while (left[++i] == right[i]);
    	return i;
    }
}
