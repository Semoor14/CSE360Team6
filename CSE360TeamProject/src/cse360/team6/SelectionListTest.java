package cse360.team6;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionListTest {

	@Test
	public void constructorTest() {
		String[] testNames = {"Test"};
		SelectionList list = new SelectionList(testNames, 32, 32, 40, 40);
		assertNotNull(list);
	}
	
	@Test
	public void isWithinBoundFalseTest() {
		String[] testNames = {"Test_1","Test_2","Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		assertFalse(list.isWithinBound(65, 32));
	}
	
	@Test
	public void isWithinBoundTrueTest() {
		String[] testNames = {"Test_1","Test_2","Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		assertTrue(list.isWithinBound(32, 32));
	}
	
	@Test
	public void getSelectedIndexNonePressedTest() {
		String[] testNames = {"Test_1"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		assertEquals(-1, list.getSelectedIndex());
	}
	
	@Test
	public void pressListButtonNonePressedTest() {
		String[] testNames = {"Test_1"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		list.pressListButton(65, 65);
		assertEquals(-1, list.getSelectedIndex());
	}
	
	@Test
	public void pressListButtonAndGetSelectedIndexTest() {
		String[] testNames = {"Test_1","Test_2","Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		list.pressListButton(48, 48);
		assertEquals(2, list.getSelectedIndex());
	}
	
	@Test
	public void getButtonNameAtIndexTest() {
		String[] testNames = {"Test_1","Test_2","Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		assertEquals("Test_2", list.getButtonNameAtIndex(1));
	}

	@Test
	public void sizeOfListTest() {
		String[] testNames = {"Test_1","Test_2","Test_3","Test_4"};
		SelectionList list = new SelectionList(testNames, 24, 24, 40, 40);
		assertEquals(4, list.sizeOfList());
	}
	
}
