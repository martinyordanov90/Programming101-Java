package week01;

public class Task34 {
	static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		}
		if (year % 100 != 0) {
			return true;
		}
		if (year % 400 != 0) {
			return false;
		}
		return true;
	}
	
	static int getCenturyCode(int year) {
		int century = year / 100 + 1;
		
		if (century % 4 == 1) {
			return 6;
		}
		if (century % 4 == 2) {
			return 4;
		}
		if (century % 4 == 3) {
			return 2;
		}
		return 0;
	}
	
	

	static int fridayYears(int start, int end) {
		int fridayYears = 0;
		
		for (int year = start; year <= end; year++) {
			int centuryCode = getCenturyCode(year);
			int lastTwoDigits = year % 100;
			int dividedDigits = lastTwoDigits / 4;
			
			int sum = centuryCode + lastTwoDigits + dividedDigits;
			
			if (isLeapYear(year)) {
				sum += 6;
				if ((sum + 1) % 7 == 5 || (sum + 2) % 7 == 5) {
					fridayYears++;
				}
			} else {
				if ((sum + 1) % 7 == 5) {
					fridayYears++;
				}
			}
		}
		return fridayYears;
	}
}
