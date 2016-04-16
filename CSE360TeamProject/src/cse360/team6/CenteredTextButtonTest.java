package cse360.team6;

import static org.junit.Assert.*;
import org.junit.Test;


public class CenteredTextButtonTest {

	@Test
	public void constructorTest() {		
		CenteredTextButton button = new CenteredTextButton("Text", 24, 24, 40, 40, null);
		assertNotNull(button);
	}

}
