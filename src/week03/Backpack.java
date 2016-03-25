package week03;

public class Backpack<T> {
	
	T contents;
	
	public Backpack(T contents) {
		this.contents = contents;
	}
	
	public T getContents() {
		return contents;
	}
	
	public void setContents(T newContents) {
		contents = newContents;
	}
}