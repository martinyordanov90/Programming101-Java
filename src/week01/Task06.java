package week01;

public class Task06 {
	static long fac(long n) {
    	int fac = 1;
        for (long i = n; i >= 2; i--) {
            fac *= i;
        }
        return fac;
    }
    
    static long doubleFac(int n) {
        return fac(fac((int)n));
    }
}