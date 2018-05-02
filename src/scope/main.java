package scope;

public class main {

	public static void main(String[] args) {
		String privateVar= "this is private to main()";
		
		ScopeCheck scopeInstance = new ScopeCheck();
		System.out.println("scopeInstance privateVar, publicVar is " + scopeInstance.getPrivateVar());
		System.out.println(privateVar);
		
		scopeInstance.timesTow();
		System.out.println("********************************************");
		ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
		innerClass.timesTow();
	}

}
