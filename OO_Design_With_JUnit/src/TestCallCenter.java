import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;
import org.junit.Before;



public class TestCallCenter {
	
	TheCallCenter theCall;
	int respondentArrayLength;
	
	@Before
	public void init() {
		theCall = new TheCallCenter();
		theCall.createCallCenter();
		for(int i = 0; i < 20; i++) {
			theCall.dispatchCall(i);
		}
	}
	@Test
	public void testRespondentArrayNotNull() {
		assertNotNull(theCall.respondent);
	}
	
	@Test
	public void testRespondentArrayLength() {
		respondentArrayLength = theCall.respondent.length;
		assertEquals(10, respondentArrayLength);
	}
	
	@Test
	public void testRespondentCall() {
		assertFalse(theCall.respondent[4].isAvailable);
	}
	
	@Test
	public void testNotAvailable() {
		String notAvailable = "All lines are busy 19";
		assertEquals(notAvailable,theCall.allCallsAreBusy(19));
	}
	
	@After
    public void finalize() {
		respondentArrayLength = 0;
		theCall = null;
    }
}
