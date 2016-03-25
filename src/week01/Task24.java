package week01;

public class Task24 {
	static String decodeUrl(String input) {
    	input = input.replace("%20", " ")
    	             .replace("%3A", ":")
    	             .replace("%3D", "?")
    	             .replace("%2F", "/");
    	return input;
    }
}
