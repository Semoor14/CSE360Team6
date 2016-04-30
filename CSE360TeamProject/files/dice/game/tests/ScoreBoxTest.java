package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.ScoreBox;

public class ScoreBoxTest {

	@Test
	public void scoreBoxTest() {
		ScoreBox scoreBox = new ScoreBox("Score", 1, null);
		assertNotNull(scoreBox);
	}
	
	@Test
	public void getBoxTest()
	{
		ScoreBox scoreBox = new ScoreBox("Score", 1, null);
		assertNotNull(scoreBox.getBox());
	}
}
