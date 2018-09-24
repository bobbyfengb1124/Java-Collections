package array.challenge;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] myIntegers = getIntegers(5);
		// myIntegers = sortArrayDescendancely(myIntegers);
		//
		// for (int i = 0; i < myIntegers.length; i++) {
		// System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
		// }

		// reverse(123);
		//
		// reverse(-123);
		//
		// reverse(120);
		// reverse(10);

		// System.out.println(longestCommonPrefix(new String[] { "flower", "flow",
		// "flight" }));
		// System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car"
		// }));
		// System.out.println(longestCommonPrefix(new String[] {}));
		// System.out.println(longestCommonPrefix(new String[] { "a" }));
		// System.out.println(longestCommonPrefix(new String[] { "a", "a" }));
		System.out.println(longestCommonPrefix(new String[] { "aa", "aa" }));

	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;

		// int shortestLength = Integer.MAX_VALUE;
		// String shortestString = "";
		// String prefix = "";
		//
		// if (strs.length == 0) {
		// shortestLength = 0;
		// }
		//
		// for (String str : strs) {
		// if (str.length() < shortestLength) {
		// shortestLength = str.length();
		// shortestString = str;
		// }
		// }
		//
		// if(strs.length==1) {
		// return strs[0];
		// }
		//
		// if (shortestLength > 0) {
		//
		// for (int i = 0; (i < shortestLength)||i==1; i++) {
		// prefix = shortestString.substring(0, i);
		// int same = 0;
		//
		// for (String str : strs) {
		// if (prefix.compareTo(str.substring(0, i)) == 0) {
		// same++;
		// } else {
		// same = 0;
		// break;
		// }
		// }
		//
		// if (same != strs.length && i == 1) {
		// System.out.println("There is no common prefix among the input strings.");
		// prefix = "";
		// break;
		// }
		// if (same != strs.length) {
		// prefix = shortestString.substring(0, i - 1);
		// }
		//
		// }
		// } else {
		// System.out.println("There is no common prefix among the input strings.");
		// }
		//
		// return prefix;

	}

	public static int reverse(int x) {
		String digitString = String.valueOf(Math.abs(x));
		String.valueOf(digitString);
		int ret = 0;

		try {
			ret = Integer.valueOf(stringReverse(digitString));
		} catch (Exception e) {
			ret = 0;
		}

		if (x < 0) {
			ret = -1 * ret;
		}

		System.out.println(ret);

		return ret;

	}

	private static String stringReverse(String digitString) {
		char[] strArray = digitString.toCharArray();

		for (int i = 0; i < strArray.length / 2; i++) {
			char temp = strArray[i];
			strArray[i] = strArray[strArray.length - i - 1];
			strArray[strArray.length - i - 1] = temp;
		}

		return String.valueOf(strArray);

	}

	private static int[] sortArrayDescendancely(int[] myIntegers) {
		for (int i = 0; i < myIntegers.length; i++) {
			for (int j = i + 1; j < myIntegers.length; j++) {
				if (myIntegers[i] < myIntegers[j]) {
					int temp = myIntegers[j];
					myIntegers[j] = myIntegers[i];
					myIntegers[i] = temp;
				}
			}
		}

		return myIntegers;
	}

	private static int[] getIntegers(int number) {
		System.out.println("Enter " + number + " integer values.\r");
		int[] values = new int[number];

		for (int i = 0; i < values.length; i++) {
			values[i] = scanner.nextInt();
		}

		return values;
	}

}
