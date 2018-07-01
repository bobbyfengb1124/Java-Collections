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
        
        String challenge8 = "abcd.135uvqz.7tzik.999";
		String regExp = "\\d+";
		Pattern regPattern = Pattern.compile(regExp);
		Matcher vMatcher = regPattern.matcher(challenge8);

		int count = 0;
		while (vMatcher.find()) {
			count++;
			System.out.println("Occurrence " + count + " : " + vMatcher.group(0));
		}
		
		String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
		regExp = "[\\d]+[\\t\\n]";
		regPattern = Pattern.compile(regExp);
		vMatcher = regPattern.matcher(challenge9);
		
		count = 0;
		while (vMatcher.find()) {
			count++;
			System.out.println("Occurrence " + count + " : " + vMatcher.group(0));
		}
		
		String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
		regExp = "([\\d]+)([\\s])";
		regPattern = Pattern.compile(regExp);
		vMatcher = regPattern.matcher(challenge10);
		
		count = 0;
		while (vMatcher.find()) {
			count++;
			System.out.println("Occurrence " + count + " : " + vMatcher.group(0) + " " + vMatcher.start(1)+ " " + (vMatcher.end(1)-1));
		}
		
		String challenge11 = "{0,2},{0,5},{1,3},{2,4}";
		regExp = "\\{([0-9],[0-9])\\}";
		regPattern = Pattern.compile(regExp);
		vMatcher = regPattern.matcher(challenge11);
		
		count = 0;
		while (vMatcher.find()) {
			count++;
			System.out.println("Occurrence " + count + " : " + vMatcher.group(1));
		}
	}

}
