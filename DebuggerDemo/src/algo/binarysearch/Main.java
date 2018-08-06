package algo.binarysearch;


public class Main {

	public static void main(String[] args) {

		System.out.println(binarySearchRecusively(new int[] {1,2,3,4,7,9,12,18}, 0, 7, 18));
	}
	
	public static int binarySearch(int[] a, int x) {
		int startIndex = 0;
		int endIndex = a.length-1;
		int midPointIndex;

		while (startIndex <= endIndex) {
			
			midPointIndex = (startIndex + endIndex) / 2;
			if (a[midPointIndex] == x) {
				return midPointIndex;
			} else {
				if (a[midPointIndex] > x) {
					endIndex = midPointIndex - 1;
				} else {
					startIndex = midPointIndex + 1;
				}
			}
			System.out.println(midPointIndex);
		}

		return -1;
	}
	
	public static int binarySearchRecusively(int[] a, int startIndex, int endIndex, int x) {
		int midPointIndex;
		
		if (startIndex > endIndex) {
			return -1;
		} else {
			midPointIndex = (startIndex + endIndex) / 2;
			System.out.println("Index at: " + midPointIndex);
			if (a[midPointIndex] == x) {
				return midPointIndex;
			} else {
				if (a[midPointIndex] > x) {
					endIndex = midPointIndex - 1;
					return binarySearchRecusively(a, startIndex, endIndex, x);
				} else {
					startIndex = midPointIndex + 1;
					return binarySearchRecusively(a, startIndex, endIndex, x);
				}
			}
		}
	}

}
