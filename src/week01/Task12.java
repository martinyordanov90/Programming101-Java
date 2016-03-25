package week01;

import java.util.HashMap;
import java.util.Map;

public class Task12 {
	static int getOddOccurrence(int[] array) {
    	Map<Integer, Integer> occurences = new HashMap<>();
    	for (int num : array) {
    		if (!occurences.containsKey(num)) {
    			occurences.put(num, 0);
    		}
    		occurences.put(num, occurences.get(num) + 1);
    	}
    	for (Integer num : occurences.keySet()) {
    		if (occurences.get(num) % 2 == 1) {
    			return num;
    		}
    	}
    	return -1;
    }
}
