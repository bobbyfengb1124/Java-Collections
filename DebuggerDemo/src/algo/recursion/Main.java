package algo.recursion;

public class Main {

	public static void main(String[] args) {

		int ret = -1;
		ret = recursiveLinearSearch(new int[] { 1, 2, 3, 4, 7, 9, 12, 18 }, 0, 7);
		System.out.println("=============");
		System.out.println(ret);
	}

	public static void reduceByOne(int n) {
		if (n < 0) {
			return;
		}
		reduceByOne(n - 1);

		System.out.println("Completed Call: " + n);
	}

	public static int recursiveLinearSearch(int[] a, int i, int x) {
		int ret = -1;
		
		if (i < a.length) {
			if (a[i] == x) {
				return i;
			} else {
				System.out.println("Index at: " + i );
				i++;
				ret = recursiveLinearSearch(a, i, x);
				return ret;
			}
		} else {
			return -1;
		}
	}

}
