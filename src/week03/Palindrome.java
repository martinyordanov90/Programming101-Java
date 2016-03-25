package week03;

public class Palindrome {
	static <T> boolean isPalindrome(T obj) {
		String objStr = obj.toString();
		return objStr == new StringBuffer(objStr).reverse().toString();
	}
}
