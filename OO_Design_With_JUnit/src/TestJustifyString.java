import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;



public class TestJustifyString {
	
	JustifyThisString justify;
	ArrayList<String> returnedString;
	int limit = 24;
	String testThisString = "A common type of text alignment in print media is justification, where the spaces between words and between glyphs or letters are stretched or compressed in order to align both the left and right ends of consecutive lines of text. When using justification, it is customary to treat the last line of a paragraph separately by simply left or right aligning it, depending on the language direction. Lines in which the spaces have been stretched beyond their normal width are called loose lines, while those whose spaces have been compressed are called tight lines.";
	String thisString = "align both the left and right ends";
	String testThisSmallString = "Hey there";
	String testOneWord = "Rainbows";
	
	@Before
	public void init() {
		justify = new JustifyThisString();
		
		ArrayList<String> returnedString = justify.justifyString(thisString, limit);
		
		for(int i = 0; i < returnedString.size(); i++) {
			System.out.println(returnedString.get(i));
		}
	}
	
	@Test
	public void testRespondentArrayListNotNull() {
		assertNotNull(justify.addAllWords(thisString, 5, limit));
	}
	
	@Test
	public void testStringLengthOfSmallString() {
		String testThisLength = justify.addAllWords(testThisSmallString,1,limit);
		assertEquals(limit, testThisLength.length());
	}
	
	@Test
	public void testStringLengthOfOneWord() {
		String testThisOneWordLength = justify.addOneWord(testOneWord,limit);
		assertEquals(limit, testThisOneWordLength.length());
	}
	
	@Test
	public void testLongString() {
		ArrayList<String> testThisEmptyString = justify.justifyString(testThisString,limit);
		for(int i = 0; i < testThisEmptyString.size(); i++) {
			if(i < testThisEmptyString.size()-1) {
				assertEquals(limit, testThisEmptyString.get(i).length());
			}
		}
	}
	
	@After
    public void finalize() {
		returnedString = null;
		justify = null;
    }
}
