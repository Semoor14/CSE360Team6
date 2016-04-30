package dice.game.myCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceHandlerTest {

	@Test
	public void constructorTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertNotNull(test);
	}
	
	@Test
	public void getDie1Test() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertEquals(0, test.getDie1());
	}
	
	@Test
	public void getDie2Test() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertEquals(0, test.getDie2());
	}
	
	@Test
	public void getDoubles() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertFalse(test.getDoubles());
	}
	
	@Test
	public void getSelectedTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertEquals(0, test.getSelected());
	}
	
	@Test
	public void getDie1ButtonTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertEquals("", test.getDie1Button().text);
	}
	
	@Test
	public void rollDiceDieValueTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		assertNotEquals(0, test.getDie1());
	}
	
	@Test
	public void rollDiceRolledTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		assertTrue(test.rolled);
	}
	
	@Test
	public void rollDiceSetTextTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		assertNotEquals("", test.getDie2Button().text);
	}
	
	@Test
	public void isWithinBoundFalseTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertFalse(test.isWithinBound(0, 0));
	}
	
	@Test
	public void isWithinBoundTrueTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertTrue(test.isWithinBound(280, 48));
	}
	
	@Test
	public void isWithinBoundDoublesFalseTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertFalse(test.isWithinBoundDoubles(0, 0));
	}
	
	@Test
	public void isWithinBoundDoublesTrueTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		assertTrue(test.isWithinBoundDoubles(280, 48));
	}
	
	@Test
	public void isWithinBoundDoublesSelectedTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.isWithinBoundDoubles(280, 48);
		assertEquals(1, test.getSelected());
	}
	
	@Test
	public void isWithinBoundDoublesBothSelectedTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.isWithinBoundDoubles(280, 48);
		test.isWithinBoundDoubles(344, 48);
		assertEquals(3, test.getSelected());
	}
	
	@Test
	public void resetDiceDieTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		test.resetDice();
		assertEquals(0, test.getDie1());
	}
	
	@Test
	public void resetDiceDoublesTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		test.resetDice();
		assertEquals(false, test.getDoubles());
	}
	
	@Test
	public void resetDiceSelectedTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		test.resetDice();
		assertEquals(0, test.getSelected());
	}
	
	@Test
	public void resetDiceTextTest() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.rollDice();
		test.resetDice();
		assertEquals("", test.getDie1Button().text);
	}
	
	@Test
	public void resetDiceSelected() {
		DiceHandler test = new DiceHandler(null, null, true);
		test.isWithinBound(280, 48);
		test.resetDice();
		assertFalse(test.getDie1Button().GetSelected());
	}
	
}
