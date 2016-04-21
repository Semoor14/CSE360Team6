package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class LargeQueue 
{
	// should be final but I'll wait on that
//	private int Button1XPos = 200; // only 1st, calculate the rest
//	private int ButtonYPos = 96; 
//	private int ButtonWidth = 48; 
//	private int ButtonHeight = 48; 

	private CenteredTextButton QButton1;
	private CenteredTextButton QButton2;
	private CenteredTextButton QButton3;
	private CenteredTextButton QButton4;
	private CenteredTextButton QButton5;
	
	public LargeQueue (TrueTypeFont mediumFont)
	{
		QButton1 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton2 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton3 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*2, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton4 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*3, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);		
		QButton5 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*4, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		QButton1.render(gameContainer, game, g);
		QButton2.render(gameContainer, game, g);
		QButton3.render(gameContainer, game, g);
		QButton4.render(gameContainer, game, g);
		QButton5.render(gameContainer, game, g);
	}
	
	public void isWithinBound(int clickPositionX, int clickPositionY)
	{
		if(QButton1.isWithinBound(clickPositionX, clickPositionY))
		{
			QButton1.InvertSelection();
		}
		if(QButton2.isWithinBound(clickPositionX, clickPositionY))
		{
			QButton2.InvertSelection();
		}
		if(QButton3.isWithinBound(clickPositionX, clickPositionY))
		{
			QButton3.InvertSelection();
		}
		if(QButton4.isWithinBound(clickPositionX, clickPositionY))
		{
			QButton4.InvertSelection();
		}
		if(QButton5.isWithinBound(clickPositionX, clickPositionY))
		{
			QButton5.InvertSelection();
		}
	}
}
