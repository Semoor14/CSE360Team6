package cse360.team6.myCode;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class DiceHandler 
{
	private int Die1Button_XPos = 248;
	private int Die2Button_XPos = 328;
	private int DieButton_YPos = 16;
	private int DieButton_Width = 64;
	private int DieButton_Height = 64;
	
	private CenteredTextButton Die1Button;
	private CenteredTextButton Die2Button;
	
	boolean rolled;
	
	Random rand = new Random();
	int die1;
	int die2;
	int selected;
	
	public DiceHandler(TrueTypeFont lFont, TrueTypeFont sFont)
	{
		selected = 0;
		rolled = false;
		die1 = 0;
		die2 = 0;
		
		Die1Button = new CenteredTextButton("", Die1Button_XPos, DieButton_YPos, DieButton_Width, DieButton_Height, lFont);
		Die2Button = new CenteredTextButton("", Die2Button_XPos, DieButton_YPos, DieButton_Width, DieButton_Height, lFont);
	}
	
	public void rollDice()
	{
		die1 = rand.nextInt(9) + 1;
		die2 = rand.nextInt(9) + 1;
		rolled = true;
		Die1Button.SetText("" + die1);
		Die2Button.SetText("" + die2);
	}
	
	public void resetDice()
	{
		die1 = 0;
		die2 = 0;
		Die1Button.SetText("");
		Die2Button.SetText("");
		if(selected == 1)
		{
			Die1Button.InvertSelection();
		}
		if(selected == 2)
		{
			Die2Button.InvertSelection();
		}
		selected = 0;
	}

	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		Die1Button.render(gameContainer, game, g);
		Die2Button.render(gameContainer, game, g);
	}
	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		boolean result = false;
		if(Die1Button.isWithinBound(clickPositionX, clickPositionY))
		{
			Die1Button.InvertSelection();
			if(selected > 0)
			{
				Die2Button.InvertSelection();
			}
			selected = 1;
			result = true;
		}

		else if (Die2Button.isWithinBound(clickPositionX, clickPositionY))
		{
			Die2Button.InvertSelection();
			if(selected > 0)
			{
				Die1Button.InvertSelection();
			}
			selected = 2;	
			result = true;
		}
		return result;
	}
	
	public int getSelected()
	{
		return selected;
	}
	
	public int getDie1()
	{
		return die1;
	}
	
	public int getDie2()
	{
		return die2;
	}
}