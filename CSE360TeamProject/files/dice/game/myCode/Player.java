package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Player has a a score and small que which show up in each players score
 * box in the game state. The player also tracks if a user has seleted a die value.
 * The players are identified by numbers 1 - 4.
 * @author Scott
 */
public class Player 
{	
	private int playerNumber;
	private ScoreBox scoreBox;
	private SmallQueue smallQueue;
	private int score;
	boolean hasSelectedDieValue;
	private Queue que;
	
	/**
	 * Player constructor initializes player and elements of the players score box displayed 
	 * on the left hand part of the game state screen.
	 * @param name		Players names player[1-4] by default.
	 * @param pNum		Player number 1 - 4
	 * @param sFont		small font is used in player scorebox
	 */
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
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore (int value)
	{
		score = value;
		changeScoreBoxText();
	}
	
	/**
	 * Modifies players score, change score used in poker hand redemtion rules and 
	 * adding to player score after roll is redemed with die not going to queue.
	 * 
	 * @param value
	 * @param addSubtract
	 */
	public void changeScore (int value, boolean addSubtract)
	{
		// change value
		if(addSubtract)
		{
			if((score + value) <= DiceGame.NUM_TO_WIN) // don't allow going over 37
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
		// update ScoreBoxText
		changeScoreBoxText();
	}
	
	//player (win condition)
	/**
	 * Checks where or not a players score is equal to the winning value
	 * @return the ID of the winning player 1-4
	 */
	public int checkForWin()
	{
		int winID = 0;
		
		if(score == DiceGame.NUM_TO_WIN)
		{
			winID = playerNumber;		
		}	
		return winID;
	}
	
	/**
	 * Boxes are inverted when it is a players turn.
	 */
	public void InvertAllBoxes()
	{
		invertScoreBox();
		invertSmallQueue();	
	}
	
	public void invertScoreBox()
	{
		scoreBox.getBox().InvertSelection();
	}
	
	public void invertSmallQueue()
	{
		smallQueue.invertSmallBoxes();	
	}
	
	/**
	 * Adds the unselected die to the que and the seleccted die to the players score.
	 * @param dieSelected  die to be added to score
	 * @param unSelected   die to be added to queue
	 */
	public void addMainDieValue(int dieSelected, int unSelected)
	{
		changeScore(dieSelected, true);
		addToQueue(unSelected);
	}
	
	public void addMainDieValueDoubles(int die1, int die2, int diceSelected)
	{
		if(diceSelected == 0)
		{
			addToQueue(die1);
			addToQueue(die2);
		}
		else if (diceSelected == 1)
		{
			changeScore(die1, true);
			addToQueue(die2);
		}
		else if (diceSelected == 2)
		{
			changeScore(die2, true);
			addToQueue(die1);
		}
		else // diceSelected == 3
		{
			changeScore(die1, true);
			changeScore(die2, true);
		}

	}
	
	public void addRunDie(int dieSelected)
	{
		addToQueue(dieSelected);
	}
	
	//value passed from addDieValue, value added to queues
	public void addToQueue(int toAddToQueue)
	{
		que.addValue(toAddToQueue);
		changeSmallQueueText(que.getArray());
	}
	
	public void changeSmallQueueText(int [] que)
	{
		smallQueue.changeAllBoxesText(que);
	}
	
	//resets updated text to player score box.
	public void changeScoreBoxText()
	{
		scoreBox.getBox().SetText("Player " + playerNumber + ": " + score);
	}
	
	public void deleteRedeemedValuesFromQueue(int [] indexesToClear)
	{
		que.deleteValues(indexesToClear);
		changeSmallQueueText(que.getArray());
	}
}
