package week01;

public class Task20 {
	static boolean isPalindrome(int arg) {
    	int argCopy = arg;
    	int reverse = 0;
    	while (argCopy > 0) {
    		int digit = argCopy % 10;
    		reverse = reverse*10 + digit;
    		argCopy /= 10;
    	}
    	return arg == reverse;
    }
}
