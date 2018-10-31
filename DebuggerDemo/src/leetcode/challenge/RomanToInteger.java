package leetcode.challenge;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {

		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));

	}

	public static int romanToInt(String s) {
		HashMap<String, Integer> dict1 = new HashMap<>();

		dict1.put("I", 1);
		dict1.put("V", 5);
		dict1.put("L", 50);
		dict1.put("D", 500);

		dict1.put("X", 10);
		dict1.put("C", 100);
		dict1.put("M", 1000);

		return subRomanToInt(s, dict1);

	}

	private static int subRomanToInt(String s, HashMap<String, Integer> dict1) {
		boolean specialCase=false;
		String keyForThisBit;
		String keyForNextBit="";
		
		if(s.length()<=0) {
			return 0;
		}
		
		keyForThisBit= s.substring(0,1);
		
		if(s.length()>1) {
			keyForNextBit = s.substring(1, 2);
			if(dict1.get(keyForThisBit)<dict1.get(keyForNextBit)) {
				specialCase=true;
			}
		}

		if (!specialCase) {
			int temp = dict1.get(keyForThisBit);
			return temp + subRomanToInt(s.substring(1), dict1);
		}
		else {
			int temp=dict1.get(keyForNextBit)-dict1.get(keyForThisBit);
			return temp + subRomanToInt(s.substring(2), dict1);
		}
	}

}
