package leetcode.challenge;

public class ShortestToChar {

	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';
		int[] a = shortestToChar(S, C);

		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static int[] shortestToChar(String S, char C) {
		char[] str = S.toCharArray();
		int[] ret = new int[str.length];
		int leftDistance = 0;
		int rightDistance = 0;

		for (int i = 0; i < str.length; i++) {
			leftDistance = 0;
			rightDistance = 0;
			leftDistance = calLeftDistance(C, str, i);
			rightDistance = calRightDistance(C, str, i);
			ret[i] = Math.min(leftDistance, rightDistance);
		}

		return ret;

	}

	private static int calRightDistance(char c, char[] str, int i) {
		int count = 0;
		for (int j = i; j <= str.length - 1; j++) {
			if (c == str[j]) {
				return count;
			}
			count++;
		}
		return str.length;
	}

	private static int calLeftDistance(char c, char[] str, int i) {
		int count = 0;
		for (int j = i; j >= 0; j--) {
			if (c == str[j]) {
				return count;
			}
			count++;
		}
		return str.length;
	}

}
