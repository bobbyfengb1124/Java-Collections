package leetcode.challenge;

public class LevenshteinDistance {

	public static void main(String[] args) {
//		System.out.println(similarity("test", "test"));
//		System.out.println(similarity("test", "tes"));
//		System.out.println(similarity("test", "te"));
//		System.out.println(similarity("test", "teev"));
//		System.out.println(similarity("test", "teevasdasdasd"));
//		
//		System.out.println(similarity("SLD2639T", "SLD2639T"));
//		System.out.println(similarity("SLD2639T", "SLD2639"));
//		System.out.println(similarity("SLD2639T", "S2DL639T"));
//		System.out.println(similarity("SLD2639T", "SLD6239T"));
		
		System.out.println(similarity("SNOWY", "SUNNY"));
//		System.out.println(similarity("SNOWY", ""));
		
	}

	public static float similarity(String str1, String str2) {

		// 计算两个字符串的长度。
		int len1 = str1.length();
		int len2 = str2.length();
		// 建立数组，比字符长度大一个空间
		int[][] dif = new int[len1 + 1][len2 + 1];
		// 赋初值，步骤B。
		for (int a = 0; a <= len1; a++) {
			dif[a][0] = a;
		}
		for (int a = 0; a <= len2; a++) {
			dif[0][a] = a;
		}
		// 计算两个字符是否一样，计算左上的值
		int temp;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				System.out.println(str1.charAt(i - 1));
				System.out.println(str2.charAt(j - 1));
				System.out.println("i: " + i+" j: " + j);
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					temp = 0;
				} else {
					temp = 1;
				}
				// 取三个值中最小的
				dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
				printMetrix(len1, len2, dif);
			}
		}
		
		
		
		return 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
	}

	public static void printMetrix(int len1, int len2, int[][] dif) {
		System.out.println("============");
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				System.out.print(dif[i-1][j-1] + " ");
			}
			System.out.println("");
		}
	}

	// 得到最小值
	public static int min(int... is) {
		int min = Integer.MAX_VALUE;
		for (int i : is) {
			if (min > i) {
				min = i;
			}
		}
		return min;
	}

}
