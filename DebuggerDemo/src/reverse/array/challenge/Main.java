package reverse.array.challenge;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] myArray = new int[] { 1, 2, 3, 4, 5 };

		reverse(myArray);
		System.out.println("Array = " + Arrays.toString(myArray));
		
		System.out.println("=================");

		int[] myArray1 = new int[] { 1, 2, 3, 4, 5, 6 };
		reverse(myArray1);
		System.out.println("Array = " + Arrays.toString(myArray1));

	}

	public static void reverse(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}

	}
}
