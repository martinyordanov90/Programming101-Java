package week01;

public class Task18 {
	static String reverseEveryWord(String arg) {
    	StringBuilder reverse = new StringBuilder();
    	String[] words = arg.split("\\s+");
    	for (String word : words) {
    		reverse.append(new StringBuffer(word).reverse() + " ");
    	}
    	return reverse.toString();
    }
}
