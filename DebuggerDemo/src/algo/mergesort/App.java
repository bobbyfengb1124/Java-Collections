package algo.mergesort;

public class App {

	public static void main(String[] args) {

		int[] inputArray = { 9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0 };
		
		MergeSort.sort(inputArray);
		
		for(int i=0;i<inputArray.length;i++) {
			System.out.println(inputArray[i]);
		}
		
		System.out.println("Manual".substring(0,3));
	}
}
