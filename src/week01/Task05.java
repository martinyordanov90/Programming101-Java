package week01;

import java.util.Arrays;

public class Task05 {
	static int getAverage(int[] array) {
        int sum = Arrays.stream(array).sum();
        return sum / array.length;
    }
}
