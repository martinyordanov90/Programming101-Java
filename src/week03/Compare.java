package week03;

public class Compare {
	
	static <T extends Comparable<T>> T findMinimum(T[] array) {
		T min = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(min) < 0) {
				min = array[i];
			}
		}
		
		return min;
	}
}