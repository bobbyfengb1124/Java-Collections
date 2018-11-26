package leetcode.challenge;

public class MaximumSubarray {

	public static void main(String[] args) {

		System.out.println(maxSubArray1(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { -2, -1 }));
	}
	
	public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int maxStart=0, maxEnd=0;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j <nums.length; j++) {
				sum = sum+nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
    }
    

	public static int maxSubArray1(int[] nums) {
		int max=Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++){
	        nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
	    }
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
	    return max;
	}

}
