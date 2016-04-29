package dice.game.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import dice.game.myCode.SelectionList;
import dice.game.myCode.SelectionListGroup;

public class SelectionListGroupTest {

	@Test
	public void constructorTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		assertNotNull(group);
	}
	
	@Test
	public void isWithinBoundFalseTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		assertFalse(group.isWithinBound(42, 78));
	}
	
	@Test
	public void isWithinBoundTrueTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		assertTrue(group.isWithinBound(42, 60));
	}
	
	@Test
	public void getSelectionListAtIndex() {
		String[] testNames = {"Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 60, 48);
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		assertEquals(list.getButtonNameAtIndex(0), group.getSelectionListAtIndex(1).getButtonNameAtIndex(0));
	}
	
	@Test
	public void pressListButtonNonePressedFirstListTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		group.pressListButton(12, 12);
		assertEquals(-1, group.getSelectionListAtIndex(0).getSelectedIndex());
	}
	
	@Test
	public void pressListButtonNonePressedSecondListTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		group.pressListButton(12, 12);
		assertEquals(-1, group.getSelectionListAtIndex(1).getSelectedIndex());
	}
	
	@Test
	public void pressListButtonTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		group.pressListButton(42, 36);
		assertEquals(0, group.getSelectionListAtIndex(0).getSelectedIndex());
		
	}

}