package week01;

public class Task08 {
	static long getSmallestMultiple(int upperBound) {
        long multiple = 1;
        boolean divisible = false;
        while (!divisible) {
            divisible = true;
            for (int i = 1; i <= upperBound; i++) {
                if (multiple % i != 0) {
                    divisible = false;
                    multiple++;
                    break;
                }
            }
        }
        return multiple;
    }
}
