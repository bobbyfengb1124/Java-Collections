package ds.hashtable;

public class App {

	public static void main(String[] args) {

		HashTable table = new HashTable(500);
		
		table.insert("Apple");
		table.insert("Hello");
		table.insert("Feeling");
		table.insert("Water");
		table.insert("Africa");
		table.insert("Speed");
		table.insert("Phone");
		table.insert("September");
		table.insert("Michael");
		table.insert("Milk");
		table.insert("Huge");
		table.insert("Dogs");
		
		table.displayTable();
		System.out.println("--------FIND ELEMENTS--------");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Zebra"));
		System.out.println(table.find("Feeling"));
		System.out.println(table.find("Water"));
		System.out.println(table.find("Africa"));
		System.out.println(table.find("Feeling"));
		
		System.out.println("--------PALINDROME--------");
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(1221));
		System.out.println(isPalindrome(12121));
		
		System.out.println("--------------------------");
		int x,y;

		x=5>>2;
		System.out.println(x);

		y=x>>>2;

		System.out.println(y);
		
	}
	
	public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] strCharArr = str.toCharArray();
        
        for(int i=0; i<=strCharArr.length/2;i++) {
        	if(strCharArr[i] != strCharArr[strCharArr.length-1-i]) {
        		return false;
        	}
        }
        
        return true;
        
    }

}
