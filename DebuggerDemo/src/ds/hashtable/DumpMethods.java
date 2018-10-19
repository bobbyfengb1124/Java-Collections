package ds.hashtable;

import java.lang.reflect.Method;

public class DumpMethods {
	
	public void AAAA() {
		
	}

	public static void main(String[] args) {
		try {
			Class class1=Class.forName("ds.hashtable.DumpMethods");
			Method m[] = class1.getDeclaredMethods();
			for(int i=0;i<m.length;i++) {
				System.out.println(m[i].toString());
			}
		} catch (Throwable e) {
			System.err.println(e);
		}

	}

}
