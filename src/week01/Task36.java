package week01;

public class Task36 {
	static boolean isAnBn(String word) {
		if (word.length() % 2 == 1) {
			return false;
		}
		int n = word.length() / 2;
		
		StringBuilder valid = new StringBuilder();
		for (int i = 0; i < n; i++) {
			valid.append('a');
		}
		for (int i = 0; i < n; i++) {
			valid.append('b');
		}
		
		return word.equals(valid.toString());
	}
}