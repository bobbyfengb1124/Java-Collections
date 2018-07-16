package ds.stack;


public class App {

	public static void main(String[] args) {

		System.out.println(reverseString("Hello"));
		
	}
	
	public static String reverseString(String str) {
		char [] charArr = str.toCharArray();
		
		int len = charArr.length;
		int i=0;
		Stack theStack = new Stack(len);
		StringBuilder ret = new StringBuilder();
		while (!theStack.isFull()) {
			theStack.push(charArr[i++]);
		}
		
		while (!theStack.isEmpty()) {
			ret.append(theStack.pop());
		}
		return ret.toString();
	}

}
