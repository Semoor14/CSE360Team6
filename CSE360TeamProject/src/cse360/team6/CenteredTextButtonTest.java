package cse360.team6;

import static org.junit.Assert.*;
import org.junit.Test;


public class CenteredTextButtonTest {

	@Test
	public void isWithinBoundsFalseTest() {	
		CenteredTextButton button = new CenteredTextButton("Text", 24, 24, 40, 40, null);
		assertFalse(button.isWithinBound(65, 65));
	}
	
	@Test
	public void isWithinBoundsTrueTest() {	
		CenteredTextButton button = new CenteredTextButton("Text", 24, 24, 40, 40, null);
		assertTrue(button.isWithinBound(25, 25));
	}

}
