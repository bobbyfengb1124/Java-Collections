/**
 * 
 */
package studio.bo.feng;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bobbyfeng
 *
 */
public class MapProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, String> languages = new HashMap<>();
		if(languages.containsKey("Java")) {
			System.out.println("Java already exists");
		}
		else {
			languages.put("Java", "a compiled high level, object-oriented, platform independent language");
			System.out.println("Java added successfully");
		}
		
		languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
		languages.put("Algol", "an algorithmic language");
		System.out.println(languages.put("BASIC", "beginners all purposes symbolic instruction code"));
		System.out.println(languages.put("Lisp", "therein lies madness"));
		
		if(languages.containsKey("Java")) {
			System.out.println("Java is already in the map");
		}
		else {
			System.out.println(languages.put("Java", "this course is about Java"));
		}
		
		System.out.println("==================================");
		
		for(String key : languages.keySet()) {
			System.out.println(key + " : " + languages.get(key));
		}
		
	}
}
