/**
 * 
 */
package studio.bo.feng;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

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
		System.out.println(languages.put("Lisp", "Therein lies madness"));
		
		if(languages.containsKey("Java")) {
			System.out.println("Java is already in the map");
		}
		else {
			System.out.println(languages.put("Java", "this course is about Java"));
		}
		
		System.out.println("==================================");
		
//		languages.remove("Lisp");
		if(languages.remove("Algol", "an algorithmic language")) {
			System.out.println("Algol removed.");
		}else {
			System.out.println("Algol not removed, key/value pair not found");
		}
		
//		System.out.println(languages.replace("Lisp", "a funtional language with imperative features"));
		if(languages.replace("Lisp", "Therein lies madness", "a funtional language with imperative features")) {
			System.out.println("Lisp replaced");
		}
		else {
			System.out.println("Lisp was not replaced");
		}
//		System.out.println(languages.replace("Scala", "This will not be replaced"));
		for(String key : languages.keySet()) {
			System.out.println(key + " : " + languages.get(key));
		}
		
	}
}
