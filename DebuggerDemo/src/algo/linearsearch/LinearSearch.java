package algo.linearsearch;

public class LinearSearch {

	public int linearSearch(int a[], int value) {
		int answer = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == value) {
				return i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
