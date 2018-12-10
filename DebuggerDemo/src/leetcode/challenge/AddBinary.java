package leetcode.challenge;

public class AddBinary {

	public static void main(String[] args) {
//		System.out.println(addBinary("11", "1"));
//		System.out.println(addBinary("1010", "1011"));
//		System.out.println(addBinary("1111", "1111"));
		System.out.println(addBinary("100", "110010"));
	}

	public static String addBinary(String a, String b) {
		char[] str1 = a.toCharArray();
		char[] str2 = b.toCharArray();
		int jinwei = 0;
		StringBuilder ret = new StringBuilder();

		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 || j >= 0) {
			if (j >= 0 && i >= 0) {
				int a1 = Character.getNumericValue(str1[i]);
				int b1 = Character.getNumericValue(str2[j]);

				if ((a1 + b1 + jinwei) >= 2) {
					ret.append((a1 + b1 + jinwei)%2);
					jinwei = 1;
				} else {
					ret.append(a1 + b1 + jinwei);
					jinwei = 0;
				}
			} else {
				char cur;
				int curNum;
				if (i >= 0) {
					cur = str1[i];
				} else {
					cur = str2[j];
				}

				curNum = Character.getNumericValue(cur);
				
				if(jinwei==1) {
					curNum=curNum+1;
					if(curNum>=2) {
						ret.append(0);
						jinwei=1;
					}
					else {
						ret.append(curNum);
						jinwei=0;
					}
				}
				else {
					ret.append(curNum);
				}
			}

			i--;
			j--;
		}
		if(jinwei==1) {
			ret.append(1);
		}
		return ret.reverse().toString();

	}

}
