package week01;

public class Task35 {
	static boolean isCreditCardValid(String number) {
		try {
			Long.parseUnsignedLong(number);
		} catch (NumberFormatException nfe) {
			return false;
		}
		
		if (number.length() % 2 == 0) {
			return false;
		}
		
		int[] numbers = number.chars().map(c -> c - '0').toArray();
		
		int sum = 0;
		for (int i = 0; i < numbers.length; i += 2) {
			sum += numbers[i];
		}
		for (int i = 1; i < numbers.length; i += 2) {
			sum += numbers[i] * 2;
		}
		
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}
}