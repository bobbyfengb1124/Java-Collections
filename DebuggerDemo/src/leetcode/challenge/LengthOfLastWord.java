package leetcode.challenge;

public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));

	}

	public static int lengthOfLastWord(String s) {
		
		String[] strings = s.split(" ");
		for(int i=(strings.length-1);i>=0;i--) {
			if(strings[i].length()>0) {
				return strings[i].length();
			}
		}
		
		return 0;

	}

}
