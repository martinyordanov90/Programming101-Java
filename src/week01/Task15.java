package week01;

import java.util.Arrays;

public class Task15 {
	static boolean canBalance(int[] numbers) {
    	int leftSum = 0;
    	int rightSum = 0;
    	for (int i = 0; i < numbers.length - 1; i++) {
    		leftSum = Arrays.stream(Arrays.copyOfRange(numbers, 0, i)).sum();
    		rightSum = Arrays.stream(Arrays.copyOfRange(numbers, i + 1, numbers.length - 1)).sum();
    		if (leftSum == rightSum) {
    			return true;
    		}
    	}
    	return false;
    }
}
