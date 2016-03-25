package week01;

public class Task21 {
	static String copyEveryChar(String input, int k) {
    	StringBuilder output = new StringBuilder();
    	for (char c : input.toCharArray()) {
    		for (int i = 0; i < k; i++) {
    			output.append(c);
    		}
    	}
    	return output.toString();
    }
}
