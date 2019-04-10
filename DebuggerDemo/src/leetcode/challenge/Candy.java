package leetcode.challenge;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		System.out.println(candy(new int[] { 1, 0, 2 }));
		System.out.println(candy(new int[] { 1, 2, 2 }));
		System.out.println(candy(new int[] { 1, 3, 2, 2, 1 }));
		System.out.println(candy(new int[] { 1, 2, 87, 87, 87, 2, 1 }));
	}

	public static int candy(int[] ratings) {
		int total = 0;
		int[] tmp = new int[ratings.length];
		Arrays.fill(tmp, 1);

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				tmp[i] = tmp[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && tmp[i] < tmp[i + 1] + 1) {
				tmp[i] = tmp[i + 1] + 1;
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			total = total + tmp[i];
		}

		return total;
	}

}
