package week01;

public class Task11 {
	static long pow(int a, int b) {
    	if (b < 0) {
    		//TODO throw exception - exponent < 0 is the same as bth root
    	}
    	if (b == 0) {
    		if (a != 0) {
    			return 1;
    		} else {
    			//TODO throw exception - 0^0 is undefined
    		}
    	}
    	if (b % 2 == 0) {
    		return pow(a*a, b/2);
    	}
    	if (b % 2 == 1) {
    		return a * pow(a*a, b/2);
    	}
    	return 0;
    }
}
