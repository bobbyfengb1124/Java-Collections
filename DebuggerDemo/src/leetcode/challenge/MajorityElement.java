package leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
	
	static HashMap<Integer, Integer> elementsAndTimes = new HashMap<>();

	public static void main(String[] args) {

		int[] test1 = new int[] { 3, 2, 3 };
		System.out.println(majorityElement(test1));
		
		int[] test2 = new int[] { 2,2,1,1,1,2,2 };
		System.out.println(majorityElement(test2));
		
		int[] test3 = new int[] { 1 };
		System.out.println(majorityElement(test3));
	}

	public static int majorityElement(int[] nums) {
//		int maxTimes = Integer.MIN_VALUE;
//		int ret = -1;
//
//		for (int i = 0; i < nums.length; i++) {
//			Integer temp = 0;
//			if(elementsAndTimes.containsKey(nums[i])) {
//				temp = elementsAndTimes.get(nums[i]);
//				temp++;
//				elementsAndTimes.put(nums[i], temp);
//				
//			}
//			else {
//				elementsAndTimes.put(nums[i], 1);
//				temp=1;
//			}
//			if(temp>maxTimes) {
//				maxTimes = temp;
//				if(temp>nums.length/2) {
//					ret = nums[i];
//				}
//			}
//		}
//
//		return ret;
		Arrays.sort(nums);
        return nums[nums.length/2];

	}

}
