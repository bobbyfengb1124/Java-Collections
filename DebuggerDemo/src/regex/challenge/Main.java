package regex.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		String challenge1 = "I want a bike.";
		System.out.println(challenge1.matches("I want a bike."));
		
		String challenge2 = "I want a ball.";
		System.out.println(challenge1.matches("I want a [a-z]{4}."));
		System.out.println(challenge2.matches("I want a [a-z]{4}."));
		
		String reg = "I want a \\w+.";
		Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());
        
        matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\p{Blank}", "_"));
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));
        
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^a{3}b{1}c{8}d{3}e{1}f{3}g{1}$"));
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));
        
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[a-z]+.[0-9]+$"));
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));
	}

}
