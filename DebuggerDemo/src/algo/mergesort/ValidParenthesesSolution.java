package algo.mergesort;

import java.util.Stack;

public class ValidParenthesesSolution {

	public static void main(String[] args) {
		System.out.println(isValid("}"));
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid(""));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		
		char myChar = '\u00A9';
		
		System.out.println(myChar);
		
		myChar = '\u00AE';
		System.out.println(myChar);
	}

	public static boolean isValid(String s) {
		Stack<Character> bracket1 = new Stack<>();
		// bracket1.
		// Stack<Character> bracket2 = new Stack<>();
		// Stack<Character> bracket3 = new Stack<>();

		if (s.equals("")) {
			return true;
		}

		try {

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '(':
					bracket1.push(c);
					break;
				case ')':
					if (bracket1.lastElement().equals('('))
						bracket1.pop();
					else
						return false;
					break;
				case '{':
					bracket1.push(c);
					break;
				case '}':
					if (bracket1.lastElement().equals('{'))
						bracket1.pop();
					else
						return false;
					break;
				case '[':
					bracket1.push(c);
					break;
				case ']':
					if (bracket1.lastElement().equals('['))
						bracket1.pop();
					else
						return false;
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			return false;
		}

		if (bracket1.empty()) {
			return true;
		} else {
			return false;
		}

	}

}
