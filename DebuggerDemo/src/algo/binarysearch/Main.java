package algo.binarysearch;

public class Main {

	public static void main(String[] args) {

		System.out.println(binarySearch(new int[] {1,2,3,4,7,9,12,18}, 12));
	}
	
	public static int binarySearch(int[] a, int x) {
		int ret = -1;
		int startIndex = 0;
		int endIndex = a.length-1;
		int midPointIndex;
		int i=0;

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

}
