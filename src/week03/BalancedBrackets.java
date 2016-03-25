package week03;

import java.util.Stack;

public class BalancedBrackets {
	static boolean isBalanced(String expression) {
		Stack<Character> opening = new Stack<>();
		for (char token : expression.toCharArray()) {
			if (token == '(') {
				opening.push(token);
			} else {
				if (opening.empty()) {
					return false;
				}
				opening.pop();
			}
		}
		if (!opening.empty()) {
			return false;
		}
		return true;
	}
}
