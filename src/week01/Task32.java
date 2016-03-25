package week01;

public class Task32 {
	static int reverse(int n) {
		int rev = 0;
		int rem;
		while (n > 0) {
			rem = n % 10;
		    n = n / 10;
		    rev = rev * 10 + rem;
		}
		return rev;
	}
	
	static int pScore(int n) {
		if (Task20.isPalindrome(n)) {
			return 1;
		}
		return 1 + pScore(n + reverse(n));
	}
}