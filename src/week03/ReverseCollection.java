package week03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class ReverseCollection {
	static <T> void reverse(Collection<T> collection) {
		List<T> reverse = new ArrayList<>();
		
		for (int i = 0; i <= collection.size(); i++) {
			int curr = 0;
			for (T element : collection) {
				if (curr == collection.size() - i) {
					reverse.add(element);
					break;
				}
				curr++;
			}
		}
		
		collection.clear();
		for (T element : reverse) {
			collection.add(element);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> someList = new Stack<>();
		someList.push(1);
		someList.push(2);
		someList.push(3);
		someList.push(4);
		System.out.println(someList);
		reverse(someList);
		System.out.println(someList);
	}
}