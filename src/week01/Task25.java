package week01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task25 {
	 static int sumOfNumbers(String input) {
		 int sum = 0;
		 Pattern nums = Pattern.compile("\\d+");
		 Matcher m = nums.matcher(input);
	     while (m.find()) {
	         sum += Integer.parseInt(m.group());
	     }
	     return sum;
	 }
}
