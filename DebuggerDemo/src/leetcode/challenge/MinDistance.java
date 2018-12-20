package leetcode.challenge;


public class MinDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));
		System.out.println(minDistance("", ""));
		System.out.println(minDistance("a", "b"));
		System.out.println(minDistance("zoologicoarchaeologist", "zoogeologist"));
	}

	public static int minDistance(String word1, String word2) {
		if(word1.length()==0) {
			return word2.length();
		}
		if(word2.length()==0) {
			return word1.length();
		}
		
		int[][] metrix = new int[word1.length() + 1][word2.length() + 1];
		char w1[] = word1.toCharArray();
		char w2[] = word2.toCharArray();

		// init
		for (int i = 1; i <= word2.length(); i++) {
			metrix[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			metrix[i][0] = i;
		}

		printMatrix(word1, word2, metrix);
		System.out.println("=============================");

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int temp = 0;
				if (w1[i - 1] != w2[j - 1]) {
					temp = 1;
				}
				
				metrix[i][j] = calMin(metrix[i][j - 1]+1, metrix[i - 1][j]+1, metrix[i - 1][j - 1]+temp);
			}

		}

		printMatrix(word1, word2, metrix);
		System.out.println("=============================");

		return metrix[w1.length][w2.length];

	}

	private static int calMin(int i, int j, int k) {
		int min = Integer.MIN_VALUE;

		min = Math.min(i, j);
		min = Math.min(min, k);

		return min;
	}

	public static void printMatrix(String word1, String word2, int[][] metrix) {
		for (int i = 0; i <= word1.length(); i++) {
			for (int j = 0; j <= word2.length(); j++) {
				System.out.print(metrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
