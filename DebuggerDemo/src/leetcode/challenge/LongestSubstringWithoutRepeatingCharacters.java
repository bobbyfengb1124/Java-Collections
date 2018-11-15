package leetcode.challenge;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("dvdf"));

	}

	public static int lengthOfLongestSubstring(String s) {

		char[] str = s.toCharArray();
		int maxLen = 0;
		HashMap<Character, Integer> subStr = new HashMap<>();

		for (int i = 0; i < str.length; i++) {
			int j = -1;
			if(subStr.containsKey(str[i])) {
				j = subStr.get(str[i]);	
			}
			
			if (j >= 0) {
				i = j+1;
				subStr.clear();
				subStr.put(str[i], i);
			} else {
				subStr.put(str[i], i);
				if (subStr.size() > maxLen) {
					maxLen = subStr.size();
				}
			}
		}

		return maxLen;
	}

}
