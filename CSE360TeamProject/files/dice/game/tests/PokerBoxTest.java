package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.PokerBox;

public class PokerBoxTest {
	
	@Test
	public void pokerBoxInitializationTest()
	{
		PokerBox box = new PokerBox(null);
		assertNotNull(box);
	}
}
