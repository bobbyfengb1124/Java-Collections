package leetcode.challenge;

public class MaxProfit121 {

	public static void main(String[] args) {
		int[] test1 = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(test1));
		System.out.println("===================");

		int[] test2 = new int[] { 7, 6, 5, 4, 3, 1 };
		System.out.println(maxProfit(test2));
		System.out.println("===================");

		int[] test3 = new int[] { 2, 4, 1 };
		System.out.println(maxProfit2(test3));
		System.out.println("===================");

	}

	public static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		int minIndex = 0;
		int maxPrice = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
				minIndex = i;
			}
		}

		for (int i = minIndex; i < prices.length; i++) {
			if (prices[i] > maxPrice) {
				maxPrice = prices[i];
				maxProfit = maxPrice - minPrice;
			}
		}

		return maxProfit;

	}

	public static int maxProfit2(int[] prices) {
		int minPrice, maxProfit;
		minPrice = Integer.MAX_VALUE;
		maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice)
				minPrice = prices[i];
			if (maxProfit < prices[i] - minPrice)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}

	public static int maxProfit1(int[] prices) {
		int maxProfit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i; j < prices.length; j++) {
				if (prices[j] > prices[i]) {
					maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
				} else {
					continue;
				}
			}
		}

		return maxProfit;

	}

}
