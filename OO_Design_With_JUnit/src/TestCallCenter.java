import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCallCenter {
	
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);
	Respondent respondent = new Respondent(1, 4, true);
	int arrayLength;
	
	@Test
	public void testArrayLength() {
		assertEquals(true, respondent.isAvailable);
	}
	
	@Test
	public void testPrintMessage() {
		assertEquals(message, messageUtil.printMessage());
	}
}
