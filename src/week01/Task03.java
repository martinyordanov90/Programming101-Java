package week01;

import java.util.Arrays;

public class Task03 {
	static int min(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
