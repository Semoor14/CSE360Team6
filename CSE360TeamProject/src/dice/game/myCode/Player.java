package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class Player 
{	
	private int playerNumber;
	private ScoreBox scoreBox;
	private SmallQueue smallQueue;
	private int score;
	boolean hasSelectedDieValue;
	private Queue que;
	
	public Player(String name, int pNum, TrueTypeFont sFont)
	{
		score  = 0;
		que = new Queue();
		playerNumber = pNum;
		scoreBox = new ScoreBox(name + ": " + score, pNum - 1, sFont);
		smallQueue = new SmallQueue(pNum-1, sFont);
		smallQueue.changeAllBoxesText(que.getArray());
		hasSelectedDieValue = false;
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
		smallQueue.render(gameContainer, game, g);
	}
	
	public int [] getQueueValues()
	{
		return que.getArray();
	}
	
	public void changeScore (int value, boolean addSubtract)
	{
		// change value
		if(addSubtract)
		{
			if((score + value) <= 59) // don't allow going over 37
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
	
	//player (win condition)
	public int checkForWin()
	{
		int winID = 0;
		
		if(score == 59)
		{
			winID = playerNumber;		
		}	
		return winID;
	}
	
	public void InvertAllBoxes()
	{
		invertScoreBox();
		invertSmallQueue();	
	}
	
	//player
	public void invertScoreBox()
	{
		scoreBox.getBox().InvertSelection();
	}
	
	public void invertSmallQueue()
	{
		smallQueue.invertSmallBoxes();	
	}
	
	//In Player
	public void addDieValue(int dieSelected, int unSelected)
	{
		changeScore(dieSelected, true);
		addToQueue(unSelected);
		
		changeScoreBoxText(score);
		changeSmallQueueText(que.getArray());
		
	}
	
	public void addToQueue(int toAddToQueue)
	{
		que.addValue(toAddToQueue);
	}
	
	public void changeSmallQueueText(int [] que)
	{
		smallQueue.changeAllBoxesText(que);
	}
	
	
	
	public void changeScoreBoxText(int scoreValue)
	{
		scoreBox.getBox().SetText("Player " + playerNumber + ": " + score);
	}
	
}
