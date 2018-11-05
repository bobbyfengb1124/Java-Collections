package leetcode.challenge;

public class RemoveElement {

	public static void main(String[] args) {
		int nums[] = new int[] {3,2,2,3};
		int newLength = removeElement(nums,3);
		System.out.println(newLength);
		printArray(nums,newLength);
		
		nums = new int[] {0,1,2,2,3,0,4,2};
		newLength = removeElement(nums,2);
		System.out.println(newLength);
		printArray(nums,newLength);
	}

	private static void printArray(int[] nums, int newLength) {
		for(int i=0;i<newLength;i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
		
	}

	public static int removeElement(int[] nums, int val) {

		int newLength=0;
		int oldLength = nums.length;
		
		for(int i =0;i<oldLength;i++) {
			if(nums[i] == val) {
				removeAndMoveNextElements(nums, i, --oldLength);
				i--;
			}else {
				newLength++;
			}
		}
		
		return newLength;
	}

	private static void removeAndMoveNextElements(int[] nums, int i, int oldLength) {
		for(int j=i;j<oldLength;j++) {
			nums[j] = nums[j+1];
		}
	}

}
