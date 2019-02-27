package leetcode.challenge;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] a1 = new int[] { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(a1));

		int[] a2 = new int[] { 3, 1, 3, 4, 2 };
		System.out.println(findDuplicate(a2));
	}

	
	public static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while (slow != fast);
		
		fast = nums[0];
		while(fast !=slow) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}

}
