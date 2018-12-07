package leetcode.challenge;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ret = plusOne(new int[] { 1, 2, 3, 4 });
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();

		ret = plusOne(new int[] { 9 });
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();

	}

	public static int[] plusOne(int[] digits) {
		int jinwei = 0;
		int[] newDigit = new int[digits.length + 1];

		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				digits[i] += 1;
				
			} else {
				if (jinwei == 1) {
					digits[i] += 1;
				}
			}

			if (digits[i] > 9) {
				jinwei = 1;
				digits[i] = digits[i]%10;
			} else {
				jinwei = 0;
			}
		}

		if (jinwei == 1) {
			newDigit[0] = 1;
		}
		
		System.arraycopy(digits, 0, newDigit, 1, digits.length);
		
		for (int i = 0; i < newDigit.length; i++) {
			System.out.print(newDigit[i] + " ");
		}
		System.out.println();

		if (newDigit[0] == 0) {
			int[] retDigit = new int[newDigit.length - 1];
			System.arraycopy(newDigit, 1, retDigit, 0, newDigit.length - 1);
			return retDigit;
		}

		return newDigit;

	}

}
