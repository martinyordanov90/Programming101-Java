package week01;

import java.util.Arrays;

public class Task04 {
	static int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k];
    }
}