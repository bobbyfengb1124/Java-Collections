package leetcode.challenge;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[] {0,1,0}));
		System.out.println(peakIndexInMountainArray(new int[] {0,2,1,0}));
	}

	public static int peakIndexInMountainArray(int[] A) {

		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<A.length;i++) {
			if(max<A[i]) {
				max = A[i];
				continue;
			}
			else {
				return i-1;
			}
		}
		return A[A.length-1];
	}

}
