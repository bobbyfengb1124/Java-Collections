package leetcode.challenge;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CountAndSay {

	public static void main(String[] args) {

		
//		 System.out.println(countAndSay(13));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(2));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(3));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(4));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(5));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(6));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(7));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(8));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(9));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(10));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(11));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(12));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(13));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(14));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(15));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(16));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(17));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(18));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(19));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(20));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(21));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(22));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(23));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(24));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(25));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(26));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(27));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(28));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(29));
//		 System.out.println("====================");
//		 System.out.println(countAndSay(30));
		 

		 System.out.println(countSubString("3113112221232112111312211312113211"));
//
//		 System.out.println("====================");
//		System.out.println(howManySubString("111221"));
	}

	public static String countAndSay(int n) {

		if (n < 1 || n > 30) {
			return null;
		}

		if (n == 1) {
			return "1";
		}

		String n1 = countAndSay(n - 1);
		System.out.println("====================");
		System.out.println(n1);

		return countSubString(n1);

	}

	private static String countSubString(String n1) {
		String ret = "";
		String temp = "";
		int times = 1;


		char c1[] = n1.toCharArray();
		if (n1.length() == 1) {
			return "" + times + c1[0];
		}

		HashMap<Integer, Integer> startAndEnd = howManySubString(n1);
		
		Set<Integer> keys = startAndEnd.keySet();
		List<Integer> sortedList = new ArrayList<Integer>(keys);
		Collections.sort(sortedList);

		for(Integer start: sortedList) {
			int end = startAndEnd.get(start);
			String sub = n1.substring(start, end);
			char c2[] = sub.toCharArray();
			ret = ret + (end-start)+c2[0];
		}
		

		return ret;

	}

	private static HashMap<Integer, Integer> howManySubString(String n1) {
		HashMap<Integer, Integer> keyStartValueEnd = new HashMap<>();

		int i = 0, j = 1;
		char c1[] = n1.toCharArray();
		for (i = 0, j = 1; j < n1.length(); j++) {
			if (c1[i] != c1[j]) {
				System.out.println("" + i + " , " + (j - 1));
				keyStartValueEnd.put(i, j);
				System.out.println(n1.substring(i,j));
				i = j;
			}
		}

		System.out.println("" + i + " , " + (j - 1));
		keyStartValueEnd.put(i, j);
		System.out.println(n1.substring(i,j));
		return keyStartValueEnd;
	}
}
