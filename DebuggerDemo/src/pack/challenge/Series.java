package pack.challenge;

public class Series {

	public static long nSum(int n) {
		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}

	public static int factorial(int n) {
		int factorial = 0;

		if (n == 0)
			factorial = 1;
		else
			factorial = (n * factorial(n - 1));

		return factorial;
	}

	public static int fibonacci(int n) {
		int ret = 0;

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		ret = fibonacci(n - 1) + fibonacci(n - 2);

		return ret;
	}
}
