package week03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static void main(String[] args) {
		Map<Integer, String> test = new HashMap<>();
		test.put(42, "Test");
		test.put(7, "foo");
		System.out.println(test.toString());
	}
	
	static <T> T firstUnique(List<T> list) {
		List<T> temp = new ArrayList<>(list);
		for (int i = 0; i < temp.size(); i++) {
			T elem = temp.get(i);
			temp.remove(elem);
			if (!temp.contains(elem)) {
				return elem;
			}
		}
		return null;
	}
	
	static Map<String, Integer> countWords(String text) {
		Pattern word = Pattern.compile("\\w+");
		Map<String, Integer> occurences = new HashMap<>();
		
		Matcher m = word.matcher(text);
		while (m.find()) {
			String currWord = m.group();
			if (!occurences.containsKey(m.group())) {
				occurences.put(currWord, 0);
			}
			occurences.put(currWord, occurences.get(currWord) + 1);
		}
		
		return occurences;
	}
	
	static <T> void rotate(Collection<T> collection, int rotateStep) {
		Queue<T> result;
		
		if (rotateStep > 0) {
			ReverseCollection.reverse(collection);
		}
		
		result = new LinkedList<>(collection);
		for (int i = 0; i < Math.abs(rotateStep); i++) {
			T temp = result.remove();
			result.add(temp);
		}
		
		collection.clear();
		collection.addAll(result);
		
		if (rotateStep > 0) {
			ReverseCollection.reverse(collection);
		}
	}
	
	static <T> T[] findDuplicates(Collection<T> a, Collection<T> b, Collection<T> c) {
	}