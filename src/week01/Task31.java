package week01;

public class Task31 {
	static long countConsonants(String str) {
		String consonants = "bcdfghjklmnpqrstvwxz";
		long consonantsCount = str.toLowerCase().chars().mapToObj(c -> (char) c)
				              .filter(c -> consonants.contains(c+"")).count();
		return consonantsCount;
	}
}
