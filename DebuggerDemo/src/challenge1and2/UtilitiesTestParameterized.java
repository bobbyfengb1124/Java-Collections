package challenge1and2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {
	
	private String input;
	private String expected;
	
	private Utilities util;
	
	public UtilitiesTestParameterized(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Before
    public void setup() {
		util = new Utilities();
        System.out.println("Running a test...");
    }
	
	@Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }

    @Test
	public void testRemovePairs() {
    	assertEquals(expected, util.removePairs(input));
    }

}
