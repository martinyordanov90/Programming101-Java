package week01;

public class Task29 {
	static boolean isHack(long n) {
		String binaryN = Long.toBinaryString(n);
		boolean isPalindrome = Task19.isPalindrome(binaryN);
		long numOfOnes = binaryN.chars().mapToObj(c -> (char) c)
				                .filter(c -> c.equals('1')).count();
		boolean oddNumOfOnes = numOfOnes % 2 == 1;
		return isPalindrome && oddNumOfOnes;
	}
	
	static long nextHack(long n) {
		while (!isHack(++n));
		return n;
	}
}
