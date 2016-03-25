package week01;

import java.util.ArrayList;
import java.util.List;

public class Task38 {
	static int zeroInsert(int n) {
		List<Integer> digits = new ArrayList<>();
		String.valueOf(n).chars().map(c -> c - '0').forEach(dig -> digits.add(dig));
		
		for (int i = 0; i < digits.size() - 1; i++) {
			int left = digits.get(i);
			int right = digits.get(i + 1);
			if (left == right || (left + right) % 10 == 0) {
				digits.add(++i, 0);
			}
		}
		
		int result = 0;
		for (int dig : digits) {
			result *= 10;
			result += dig;
		}
		
		return result;
	}
}