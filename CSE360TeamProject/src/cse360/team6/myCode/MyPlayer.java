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
	
	
	public MyPlayer(String name, int pNum, TrueTypeFont sFont)
	{
		int score  = 0;
		MyQueue que = new MyQueue();
		playerNumber = pNum;
		
		scoreBox = new MyScoreBox(name + ": ", pNum - 1, sFont);
		
		smallQueue = new MySmallQueue(pNum-1, sFont);	
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
		smallQueue.render(gameContainer, game, g);
	}
}