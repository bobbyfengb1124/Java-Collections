package test;

public class Constructor {
	
	static String str;
	public void Constructor() {
		System.out.println("Inconstructor");
		str = "Hello";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Constructor c = new Constructor();
		System.out.println(str);
	}

}
