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

		return 1 - (float) minDistance(str1, str2) / Math.max(str1.length(), str2.length());
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
	
	public static int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2,0,0,cache);
    }
    
    public static int minDistanceHelper(String word1, String word2, int i, int j, int[][] cache){
        if(j > word2.length()-1) return word1.length()-i;
        if(i > word1.length()-1) return word2.length()-j;
        if(cache[i][j] != 0) return cache[i][j];
        int result=0;
        if(word1.charAt(i) == word2.charAt(j)){
            result = minDistanceHelper(word1, word2,i+1,j+1,cache);
        }else{
            int insert = 1 + minDistanceHelper(word1, word2,i,j+1,cache);
            int delete = 1 + minDistanceHelper(word1, word2,i+1,j,cache);
            int replace = 1 + minDistanceHelper(word1, word2,i+1,j+1,cache);
            result = Math.min(insert, Math.min(delete,replace));
        }
        
        cache[i][j] = result;
        return result;
    }

}
