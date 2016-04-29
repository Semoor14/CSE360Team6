package dice.game.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import dice.game.myCode.CenteredTextBox;

public class CenteredTextBoxTest {

	@Test
	public void constructorTest() {	
		CenteredTextBox box = new CenteredTextBox("Text", 24, 24, 40, 40, null);
		assertNotNull(box);
	}
	
	@Test
	public void getSelectedTest() {	
		CenteredTextBox box = new CenteredTextBox("Text", 24, 24, 40, 40, null);
		assertFalse(box.GetSelected());
	}
	
	@Test
	public void setSelectedTest() {	
		CenteredTextBox box = new CenteredTextBox("Text", 24, 24, 40, 40, null);
		box.SetSelected(true);
		assertTrue(box.GetSelected());
	}
	
	@Test
	public void invertSelectionTest() {	
		CenteredTextBox box = new CenteredTextBox("Text", 24, 24, 40, 40, null);
		box.InvertSelection();
		assertTrue(box.GetSelected());
	}

}