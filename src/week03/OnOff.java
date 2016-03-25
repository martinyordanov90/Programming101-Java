package week03;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class OnOff<E> {
	List<E> elements;
	
	public OnOff() {
		elements = new ArrayList<>();
	}
	
	public OnOff(Collection<E> collection) {
		elements = new ArrayList<>();
		elements.addAll(collection);
	}
	
	public void add(E element) {
		if (elements.contains(element)) {
			elements.remove(element);
		} else {
			elements.add(element);
		}
	}
}
