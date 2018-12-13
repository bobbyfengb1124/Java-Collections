package leetcode.challenge;

public class MySqrt {

	public static void main(String[] args) {

		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(81));
		
		System.out.println(mySqrt(2147483647));
		System.out.println(mySqrt(0));

	}

	public static int mySqrt(int x) {
		int left=0, right=x;
		int mid= (left+right)/2;
		int ans=mid;
		
		while(left<=right) {
			if(mid*mid>x) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
			mid = (left+right)/2;
		}
		
		return mid;
		
	}

}
