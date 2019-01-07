package leetcode.challenge;


public class NumArray {
	
	int[] nums;
	int[] mySumresult;

	public static void main(String[] args) {
		int [] myNums = new int [] {-2, 0, 3, -5, 2, -1};
		NumArray obj = new NumArray(myNums);
		int param_1 = obj.sumRange(0,2);
		System.out.println(param_1);
		
		System.out.println(obj.sumRange(2,5));
		System.out.println(obj.sumRange(0,5));

	}
	
	public NumArray(int[] nums) {
		this.mySumresult = new int[nums.length+1];
		for(int cur=1; cur<=nums.length;cur++) {
			mySumresult[cur] = mySumresult[cur-1] + nums[cur-1];
		}
    }
    
    public int sumRange(int i, int j) {
    	return mySumresult[j+1]- mySumresult[i];
    }

}
