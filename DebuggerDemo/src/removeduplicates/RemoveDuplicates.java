package removeduplicates;

import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicates {
	static int [] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
	
	public static void main(String[] args) {
		
		int newLen = removeDuplicates(nums);
		System.out.println(newLen);
		for(int i =0; i<newLen;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	public static int removeDuplicates(int[] nums) {
		HashSet<Integer> newNums = new HashSet<>();
		
		
		for(int i=0;i<nums.length;i++) {
			if(newNums.contains(nums[i])) {
				
			}
			else {
				newNums.add(nums[i]);
			}
		}
		
		Iterator<Integer> iterator = newNums.stream().sorted().iterator();
		int i =0;
		while(iterator.hasNext()) {
			nums[i] = iterator.next();
			i++;
		}
		
		return newNums.size();
	}
}
