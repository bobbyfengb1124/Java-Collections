package leetcode.challenge;

public class Rob {

	public static void main(String[] args) {
		int[] test1 = new int[] { 1, 2, 3, 1 };
		System.out.println(rob(test1));
		System.out.println("==============");
		//
		int[] test2 = new int[] { 2, 7, 9, 3, 1 };
		System.out.println(rob(test2));
		System.out.println("==============");

		int[] test3 = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(rob(test3));
		System.out.println("==============");

		int[] test4 = new int[] { 226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221,
				191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55,
				122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223,
				188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120,
				180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124 };
		System.out.println(rob(test4));
		System.out.println("==============");

		int[] test5 = new int[] {};
		System.out.println(rob(test5));
		System.out.println("==============");

		int[] test6 = new int[] { 2, 1, 1, 2 };
		System.out.println(rob(test6));
		System.out.println("==============");

	}

	int calResult[];

	public static int rob(int[] nums) {
		int calResult[] = new int[nums.length + 1];

		return maxRob(1, nums, calResult);
	}

	private static int maxRob(int i, int[] nums, int[] calResult) {
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);

		}
		calResult[nums.length] = nums[nums.length - 1];
		calResult[nums.length - 1] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);

		if (nums.length == 3) {
			calResult[nums.length - 2] = Math.max(nums[0] + calResult[nums.length], nums[1]);
			return calResult[nums.length - 2];
		}

		calResult[nums.length - 2] = Math.max(nums[nums.length - 3] + calResult[nums.length], nums[nums.length - 2]);

		for (int j = nums.length - 3; j > 0; j--) {
			int firstNum = nums[j] + calResult[j + 2 + 1];
			int secondNum = nums[j - 1] + Math.max(calResult[j - 1 + 2 + 1], calResult[j - 1 + 2 + 1 + 1]);
			calResult[j] = Math.max(firstNum, secondNum);
		}

		return calResult[1];
	}

}
