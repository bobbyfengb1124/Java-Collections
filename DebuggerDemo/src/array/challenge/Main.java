package array.challenge;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] myIntegers = getIntegers(5);
		myIntegers = sortArrayDescendancely(myIntegers);
		
		for (int i = 0; i < myIntegers.length; i++) {
			System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
		}

	}

	private static int[] sortArrayDescendancely(int[] myIntegers) {
		for(int i=0;i<myIntegers.length;i++) {
			for(int j = i+1; j<myIntegers.length;j++) {
				if(myIntegers[i]<myIntegers[j]) {
					int temp = myIntegers[j];
					myIntegers[j] = myIntegers[i];
					myIntegers[i] = temp;
				}
			}
		}
		
		return myIntegers;
	}

	private static int[] getIntegers(int number) {
		System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
	}

}
