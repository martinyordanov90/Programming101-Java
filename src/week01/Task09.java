package week01;

public class Task09 {
	static long getLargestPalindrome(long n) {
        while (!Task19.isPalindrome(String.valueOf(--n)));
        return n;
    }
}
