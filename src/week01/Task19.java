package week01;

public class Task19 {
	static boolean isPalindrome(String arg) {
        return arg.equals(new StringBuffer(arg).reverse().toString());
    }
}
