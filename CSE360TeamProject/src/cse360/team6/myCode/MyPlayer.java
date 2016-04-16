package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MyPlayer 
{	
	private int playerNumber;
	private MyScoreBox scoreBox;
	private MySmallQueue smallQueue;
	private int score;
	boolean hasSelectedDieValue;
	
	public MyPlayer(String name, int pNum, TrueTypeFont sFont)
	{
		score  = 0;
		MyQueue que = new MyQueue();
		playerNumber = pNum;
		scoreBox = new MyScoreBox(name + ": " + score, pNum - 1, sFont);
		smallQueue = new MySmallQueue(pNum-1, sFont);
		hasSelectedDieValue = false;
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
		smallQueue.render(gameContainer, game, g);
	}
	
	public void changeScore (int value, boolean addSubtract)
	{
		// change value
		if(addSubtract)
		{
			if((score + value) <= 37) // don't allow going over 37
			{
				score += value;
			}
			else // subtract instead of add
			{
				score -= value;
			}
		}
		else // !addSubtract
		{
			if((score - value) >= 0) // don't allow going below 0
			{
				score -= value;
			}
			else // add instead of subtract
			{
				score += value;
			}
		}
	}
	
	public void changeScoreBoxText(int scoreValue)
	{
		scoreBox.getBox().SetText("Player " + playerNumber + ": " + score);
	}
	
	public void addDieValue(int selectedValue, int otherValue)
	{
		if(!hasSelectedDieValue)
		{
			changeScore(selectedValue, true);
			hasSelectedDieValue = true;
		}
		else // hasSelectedDieValue
		{
			changeScore(otherValue, false);
			changeScore(selectedValue, true);			
		}
		changeScoreBoxText(score);
		System.out.println(score);
	}
}