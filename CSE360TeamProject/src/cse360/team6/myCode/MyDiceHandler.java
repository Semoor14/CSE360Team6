package dice.game.myCode;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MyDiceHandler 
{
	private int Die1Button_XPos = 248;
	private int Die2Button_XPos = 328;
	private int DieButton_YPos = 16;
	private int DieButton_Width = 64;
	private int DieButton_Height = 64;
	
	private int RollButton_XPos = 412;
	private int RollButton_YPos = 32;
	private int RollButton_Width = 96;
	private int RollButton_Height = 32;
	
	private MyCenteredTextButton Die1Button;
	private MyCenteredTextButton Die2Button;
	private MyCenteredTextButton RollButton;
	
	boolean rolled;
	
	Random rand = new Random();
	int die1;
	int die2;
	int selected;
	
	public MyDiceHandler(TrueTypeFont lFont, TrueTypeFont sFont)
	{
		selected = 0;
		rolled = false;
		die1 = 0;
		die2 = 0;
		
		Die1Button = new MyCenteredTextButton("", Die1Button_XPos, DieButton_YPos, DieButton_Width, DieButton_Height, lFont);
		Die2Button = new MyCenteredTextButton("", Die2Button_XPos, DieButton_YPos, DieButton_Width, DieButton_Height, lFont);
		RollButton = new MyCenteredTextButton("Roll", RollButton_XPos, RollButton_YPos, RollButton_Width, RollButton_Height, sFont);
	}
	
	public void rollDie()
	{
		die1 = rand.nextInt(9) + 1;
		die2 = rand.nextInt(9) + 1;
		rolled = true;
	}

	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		Die1Button.render(gameContainer, game, g);
		Die2Button.render(gameContainer, game, g);
		if(!rolled)
		{
			RollButton.render(gameContainer, game, g);
		}
	}
	
	public void isWithinBound(int clickPositionX, int clickPositionY)
	{
		if(!rolled)
		{
			if(RollButton.isWithinBound(clickPositionX, clickPositionY))
			{
				rollDie();
				Die1Button.SetText(die1 + "");
				Die2Button.SetText(die2 + "");
				rolled = true;
			}
		}
		else // rolled
		{
			if(Die1Button.isWithinBound(clickPositionX, clickPositionY))
			{
				Die1Button.InvertSelection();
				if(selected > 0)
				{
					Die2Button.InvertSelection();
				}
				selected = 1;
			}
 
			else if (Die2Button.isWithinBound(clickPositionX, clickPositionY))
			{
				Die2Button.InvertSelection();
				if(selected > 0)
				{
					Die1Button.InvertSelection();
				}
				selected = 1;				
			}
		}
	}
}
