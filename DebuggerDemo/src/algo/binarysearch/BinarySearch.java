package algo.binarysearch;

public class BinarySearch {

	public int binarySearch(int[] a, int x) {
		int ret = -1;
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
		}

		return -1;
	}
}
