package week03;

public class Triple<T> {
	
	T first;
	T second;
	T third;
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public T getThird() {
		return third;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public void setSecond(T second) {
		this.second = second;
	}
	
	public void setThird(T third) {
		this.third = third;
	}
}