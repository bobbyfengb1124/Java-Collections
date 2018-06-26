package challenge1and2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {
	
	private Utilities util;
	
	@Before
    public void setup() {
		util = new Utilities();
        System.out.println("Running a test...");
    }

	@Test
	public void testConverter() {
		
		assertEquals(300, util.converter(10, 5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testConverterWithException() {
		util.converter(10, 0);
	}
	 
	@Test
	public void testEveryNthChar() {
		assertArrayEquals("EL".toCharArray(), util.everyNthChar("HELLO".toCharArray(), 2));
		assertArrayEquals("HELLO".toCharArray(), util.everyNthChar("HELLO".toCharArray(), 8));
	}
	
	@Test
	public void testNullIfOddLength() {
		assertNull(util.nullIfOddLength("asd"));
		assertNotNull(util.nullIfOddLength("asdf"));
	}
	
	@Test
	public void testRemovePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertEquals("", util.removePairs(""));
        assertEquals("B", util.removePairs("B"));
        assertEquals(null, util.removePairs(null));
	}

}
