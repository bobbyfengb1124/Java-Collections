package algo.insertionsort;

public class Main {

	public static void main(String[] args) {

		int myArray[] = insertionSort(new int[] {9,8,99,110,8,87,637,8,3,13,87,12,99});
		
		for(int i=0; i<myArray.length;i++) {
			System.out.println(myArray[i]);
		}
	}

	private static int[] insertionSort(int[] is) {
		int element;

		for (int i = 1; i < is.length; i++) {
			element = is[i];
			int j = i - 1;
			while (j >= 0 && is[j] > element) {
				is[j + 1] = is[j];
				j--;
			}
			is[j + 1] = element;
		}

		return is;
	}

}
