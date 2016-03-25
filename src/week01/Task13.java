package week01;

import java.util.Arrays;

public class Task13 {
	static long maximalScalarSum(int[] a, int[] b) {
    	Arrays.sort(a);
    	Arrays.sort(b);
    	long sum = 0;
    	for (int i : a) {
    		for (int j : b) {
    			sum += i * j;
    		}
    	}
    	return sum;
    }
}
