package algo.selectionsort;

public class Main {

	public static void main(String[] args) {

		int[] myArray = selectionSort(new int[] { 9, 8, 3, 13, 87, 12, 99 });
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}

	private static int[] selectionSort(int[] is) {
		int minimum = 0;

		for (int i = 0; i < is.length; i++) {
			minimum = i;
			for (int j = i + 1; j < is.length; j++) {
				if (is[j] < is[minimum]) {
					minimum = j;
					int temp = is[i];
					is[i] = is[minimum];
					is[minimum] = temp;
				}
			}
		}
		return is;
	}

}
