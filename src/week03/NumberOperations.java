package week03;

public class NumberOperations {
	
	static <T extends Number, U extends Number> double sum(T first, U second) {
		return first.doubleValue() + second.doubleValue();
	}
	
	static <T extends Number, U extends Number> double subtract(T first, U second) {
		return first.doubleValue() - second.doubleValue();
	}
	
	static <T extends Number, U extends Number> double multiply(T first, U second) {
		return first.doubleValue() * second.doubleValue();
	}
	
	static <T extends Number, U extends Number> double divide(T first, U second) {
		return first.doubleValue() / second.doubleValue();
	}
	
	static <T extends Number> double power(T base, long exponent) {
		return Math.pow(base.doubleValue(), exponent);
	}
	
	static <T extends Number> double fac(T n) {
    	double fac = 1;
        for (double i = n.doubleValue(); i >= 2; i--) {
            fac *= i;
        }
        return fac;
    }
}