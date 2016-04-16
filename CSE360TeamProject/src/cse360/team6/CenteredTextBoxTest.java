package cse360.team6;

import static org.junit.Assert.*;
import java.awt.Font;
import org.junit.Test;
import org.newdawn.slick.TrueTypeFont;

public class CenteredTextBoxTest {

	@Test
	public void constructorTest() {	
		CenteredTextBox box = new CenteredTextBox("Text", 24, 24, 40, 40, null);
		assertNotNull(box);
	}

}
