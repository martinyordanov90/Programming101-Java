package week01;

import java.util.ArrayList;
import java.util.List;

public class Task33 {
	static char getLetter(int number, int timesPressed) {
		String letters = new String();
		switch (number) {
		case 2:
			letters = "abc";
			break;
		case 3:
			letters = "def";
			break;
		case 4:
			letters = "ghi";
			break;
		case 5:
			letters = "jkl";
			break;
		case 6:
			letters = "mno";
			break;
		case 7:
			letters = "pqrs";
			break;
		case 8:
			letters = "tuv";
			break;
		case 9:
			letters = "wxyz";
			break;
		}

		timesPressed = (timesPressed - 1) % (letters.length());

		return letters.charAt(timesPressed);
	}

	static String numbersToMessage(int[] numbers) {
		boolean toCapitalize = false;
		int currNum;
		int currCount = 0;
		char currLetter;
		StringBuilder msg = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			currNum = numbers[i];
			switch (currNum) {
			case 0:
				msg.append(" ");
				break;
			case 1:
				toCapitalize = true;
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				currCount = 0;
				while (numbers[i] == currNum) {
					currCount++;
					i++;
					if (i == numbers.length) {
						break;
					}
				}
				i--;

				currLetter = getLetter(currNum, currCount);
				if (toCapitalize) {
					currLetter = Character.toUpperCase(currLetter);
					toCapitalize = false;
				}
				msg.append(currLetter);
				break;
			default:
			}
		}
		return msg.toString();
	}

	static List<Integer> messageToNumbers(String msg) {
		String[] buttons = new String[] {" ", "", "abc", "def", "ghi", "jkl", 
				                         "mno", "pqrs", "tuv", "wxyz"};
		int[] indices = new int[] {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,
				                   8,8,8,9,9,9,9};
		
		List<Integer> result = new ArrayList<>();
		
		char[] letters = msg.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			char curr = letters[i];
			
			if (Character.isUpperCase(curr)) {
				result.add(1);
				curr = Character.toLowerCase(curr);
			}
			
			if (Character.isWhitespace(curr)) {
				result.add(0);
				continue;
			} 
				
			int index = indices[curr - 'a'];
			int times = buttons[index].indexOf(curr) + 1;
			for (int j = 0; j < times; j++) {
				result.add(index);
			}
			
			if (i + 1 < letters.length) {
				char next = letters[i + 1];
				int nextIndex = -1;
				if (!Character.isWhitespace(next)) {
					nextIndex = indices[next - 'a'];
				}
				if (nextIndex == index) {
					result.add(-1);
				}
			}
		}
		
		return result;
	}
}
