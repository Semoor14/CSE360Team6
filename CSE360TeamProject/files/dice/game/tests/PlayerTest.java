package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.Player;

public class PlayerTest {
	
	@Test
	public void playerConstructorTest()
	{
		Player player = new Player("Player 1", 1, null);
		assertNotNull(player);
	}
	
	@Test
	public void queueValuesTest()
	{
		Player player = new Player("Player 1", 1, null);
		int[] queue  = player.getQueueValues();
		assertEquals(queue.length, 5);
		
		for (int i = 0;i<5;i++)
		{
			assertEquals(queue[i], 0);
		}
		
		player.addMainDieValue(2, 4);
		queue  = player.getQueueValues();
		assertEquals(queue.length, 5);
		assertEquals(queue[4], 4);
		for (int i = 0;i<4;i++)
		{
			assertEquals(queue[i], 0);
		}
	}
	
	@Test
	public void scoreTest()
	{
		Player player = new Player("Player 1", 1, null);
		int score = player.getScore();
		assertEquals(score, 0);
		
		player.addMainDieValue(2, 4);
		score = player.getScore();
		assertEquals(score, 2);
		
		player.setScore(20);
		score = player.getScore();
		assertEquals(score, 20);
		
		player.changeScore(5, true);
		score = player.getScore();
		assertEquals(score, 25);
		
		player.changeScore(2, false);
		score = player.getScore();
		assertEquals(score, 23);
	}
	
	@Test 
	public void winTest()
	{
		Player player = new Player("Player 1", 1, null);
		
		int winResult = player.checkForWin();
		assertEquals(winResult, 0);
		
		player.setScore(59);
		winResult = player.checkForWin();
		assertEquals(winResult, 1);
	}
	
	@Test
	public void deleteValuesTest()
	{
		Player player = new Player("Player 1", 1, null);
		player.addMainDieValue(0, 4);
		player.addMainDieValue(0, 10);
		player.addMainDieValue(0, 1);
		player.addMainDieValue(0, 3);
		player.addMainDieValue(0, 9);
		
		player.deleteRedeemedValuesFromQueue(new int[]{3, 2, 0});
		int[] values = player.getQueueValues();
		assertEquals(values.length, 5);
		assertEquals(values[4], 9);
		assertEquals(values[3], 1);
	}
}
