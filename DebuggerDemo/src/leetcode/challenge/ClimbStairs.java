package leetcode.challenge;

public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(6));
	}

	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int[] ret = new int[n+1];
		ret[1] = 1;
		ret[2] = 2;

		int i = 3;
		while (i < n+1) {
			ret[i] = ret[i - 1] + ret[i - 2];
			i++;
		}

		return ret[n];
	}

}
