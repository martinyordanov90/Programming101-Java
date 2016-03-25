package week01;

import java.util.Arrays;

public class Task14 {
	static int maxSpan(int[] numbers) {
    	int[] unique = Arrays.stream(numbers).distinct().toArray();
    	int span = Integer.MIN_VALUE;
    	for (int val : unique) {
    		int i = -1;
    		while (numbers[++i] != val);
    		
    		int j = numbers.length;
    		while (numbers[--j] != val);
    		
    		int currSpan = 1 + (j - i);
    		if (currSpan > span) {
    			span = currSpan;
    		}
    	}
    	return span;
    }
}
