package leetcode.challenge;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out
				.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}

	public static int evalRPN(String[] tokens) {
		String opr = "+-*/";
		Stack<Integer> nums = new Stack<>();

		for (String string : tokens) {
			if (opr.contains(string)) {
				Integer num2 = nums.pop();
				Integer num1 = nums.pop();
				switch (string) {
				case "+":
					nums.push(num1 + num2);
					break;
				case "-":
					nums.push(num1 - num2);
					break;
				case "*":
					nums.push(num1 * num2);
					break;
				case "/":
					if (num2 == 0) {
						nums.push(0);
					} else {
						nums.push(num1 / num2);
					}
					break;

				default:
					break;
				}
			} else {
				nums.push(Integer.valueOf(string));
			}
		}

		return nums.pop();

	}

}
