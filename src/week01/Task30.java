package week01;

public class Task30 {
	static long countVowels(String str) {
		String vowels = "aeiouy";
		long vowelsCount = str.toLowerCase().chars().mapToObj(c -> (char) c)
				              .filter(c -> vowels.contains(c+"")).count();
		return vowelsCount;
	}
}
