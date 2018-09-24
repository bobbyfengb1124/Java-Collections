package algo.mergesort;

public class MergeSort {

	public static void sort(int[] inputArray) {
		sort(inputArray, 0, inputArray.length - 1);
	}

	private static void sort(int[] inputArray, int start, int end) {

		if (end <= start) {
			return; // we are done traversing the array
		}

		int mid = (start + end) / 2;
		sort(inputArray, start, mid);
		sort(inputArray, mid + 1, end);

		merge(inputArray, start, mid, end);
	}

	private static void merge(int[] inputArray, int start, int mid, int end) {
		int tempArray[] = new int[end - start + 1];

		// index counter for the left side of the array
		int leftSlot = start;
		// index counter for the right side of the array
		int rightSlot = mid + 1;
		int k = 0;

		while (leftSlot <= mid && rightSlot <= end) {
			if (inputArray[leftSlot] < inputArray[rightSlot]) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
			} else {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
			}
			k++;
		}

		/*
		 * when it gets to here, that means the above loop has completed. so both the
		 * right and left side of the sub-array can be considered sorted
		 */

		if (leftSlot <= mid) { // consider the right side done being sorted. Left must be sorted already
			while (leftSlot <= mid) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
				k++;
			}
		} else if (rightSlot <= end) {
			while (rightSlot <= end) {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
				k++;
			}
		}
		
		// copy over the temp array into the appropriate slots of the inpurArray
		for(int i=0; i<tempArray.length;i++) {
			inputArray[start+i] = tempArray[i];
		}

	}

	// private static void merge(int[] inputArray, int start, int mid, int end) {
	//
	// int[] leftArray = new int[mid - start + 2];
	// int[] rightArray = new int[end - mid + 1];
	//
	// int j = 0;
	// for (int i = start; i <= mid; i++) {
	//
	// leftArray[j] = inputArray[i];
	// }
	// leftArray[mid - start + 1] = Integer.MAX_VALUE;
	//
	// j = 0;
	// for (int i = mid; i <= end; i++) {
	// rightArray[j] = inputArray[i];
	// }
	// rightArray[end - mid] = Integer.MAX_VALUE;
	//
	// int k = start;
	// for (int i = 0; i < leftArray.length; i++) {
	// while (j < rightArray.length) {
	// if (k <= end) {
	// if (rightArray[j] < leftArray[i]) {
	// inputArray[k] = rightArray[j];
	// j++;
	// } else {
	// inputArray[k] = leftArray[i];
	// break;
	// }
	// k++;
	// } else {
	// break;
	// }
	// }
	// }
	// }

}
