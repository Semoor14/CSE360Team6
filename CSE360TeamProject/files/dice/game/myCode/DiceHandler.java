package dice.game.myCode;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * DiceHandler is responcible for dice rolling activities in our game 
 * Two dice boxes are created side by side at the top of our game container
 * @author Scott Moore
 */
public class DiceHandler 
{	
	private CenteredTextButton Die1Button;
	private CenteredTextButton Die2Button;
	
	boolean rolled;
	
	private Random rand = new Random();
	int die1;
	int die2;
	int selected;
	boolean doubles;
	
	public DiceHandler(TrueTypeFont lFont, TrueTypeFont sFont, boolean main)
	{
		selected = 0;
		rolled = false;
		die1 = 0;
		die2 = 0;
		doubles = false;
		// yPosition logic handles main diceHandler and runDiceHandler positions
		int yPosition;
		if(main)
		{
			yPosition = Place.DH_MAINDIEBUTTON_YPOS;
		}
		else // !main or run
		{
			yPosition = Place.DH_RUNDIEBUTTON_YPOS;
		}
		//selectable die boxes that are invertable
		Die1Button = new CenteredTextButton("", Place.DH_DIE1BUTTON_XPOS, yPosition, Place.DH_DIEBUTTON_WIDTH, Place.DH_DIEBUTTON_HEIGHT, lFont);
		Die2Button = new CenteredTextButton("", Place.DH_DIE2BUTTON_XPOS, yPosition, Place.DH_DIEBUTTON_WIDTH, Place.DH_DIEBUTTON_HEIGHT, lFont);			
	}
	
	/** 
	 * rolls two ten sided die and stores them in die boxes
	 * sets text to results
	 */
	public void rollDice()
	{
		die1 = rand.nextInt(9) + 1;
		die2 = rand.nextInt(9) + 1;
		
		rolled = true;
		if(die1 == die2)
		{
			doubles = true;
		}
		Die1Button.SetText("" + die1);
		Die2Button.SetText("" + die2);
		// for statistics
		Game59State.diceRolls++;
		Game59State.diceRolls++;
	}

	/**
	 * Resets die to empty string and inversion (black) back to false 
	 * (white) after die values are selected to return to score and queue
	 */
	public void resetDice()
	{
		die1 = 0;
		die2 = 0;
		doubles = false;
		selected = 0;
		Die1Button.SetText("");
		Die2Button.SetText("");
		Die1Button.SetSelected(false);
		Die2Button.SetSelected(false);
	}

	/**
	 * Renders the container the game within the container 
	 * and the graphics. 
	 * @param gameContainer
	 * @param game
	 * @param g
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		Die1Button.render(gameContainer, game, g);
		Die2Button.render(gameContainer, game, g);
	}
	
	/**
	 * associates a position on the screen with the rendered buttons
	 * and identifies the click position. If the click is within
	 * a die button, the button will invert itself.
	 * @param clickPositionX
	 * @param clickPositionY
	 * @return
	 */	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		//results variables tells the gamestate if its been clicked or not
		boolean result = false;
		if(Die1Button.isWithinBound(clickPositionX, clickPositionY))
		{
			if(selected == 0)
			{
				Die1Button.SetSelected(true);
				selected = 1;
			}
			else if (selected == 1)
			{
				Die1Button.SetSelected(false);
				Die2Button.SetSelected(true);
				selected = 2;
			}
			else // selected == 2
			{
				Die1Button.SetSelected(true);
				Die2Button.SetSelected(false);
				selected = 1;
			}
			result = true;
		}

		else if (Die2Button.isWithinBound(clickPositionX, clickPositionY))
		{
			if(selected == 0)
			{
				Die2Button.SetSelected(true);
				selected = 2;
			}
			else if (selected == 1)
			{
				Die1Button.SetSelected(false);
				Die2Button.SetSelected(true);
				selected = 2;
			}
			else // selected == 2
			{
				Die1Button.SetSelected(true);
				Die2Button.SetSelected(false);
				selected = 1;
			}
			result = true;
		}
		return result;
	}
	
	// for variant rules, if doubles run this instead
	public boolean isWithinBoundDoubles(int clickPositionX, int clickPositionY)
	{
		boolean result = false;
		
		if(Die1Button.isWithinBound(clickPositionX, clickPositionY))
		{
			Die1Button.InvertSelection();
			result = true;
		}
		if(Die2Button.isWithinBound(clickPositionX, clickPositionY))
		{
			Die2Button.InvertSelection();
			result = true;
		}
		
		if(!Die1Button.GetSelected() && !Die2Button.GetSelected())
		{
			selected = 0;
		}
		else if (Die1Button.GetSelected() && !Die2Button.GetSelected())
		{
			selected = 1;
		}
		else if (!Die1Button.GetSelected() && Die2Button.GetSelected())
		{
			selected = 2;
		}
		else // Die1Button.GetSelected() && Die2Button.GetSelected()
		{
			selected = 3;
		}
		
		return result;
	}
	
	public int getSelected()
	{
		return selected;
	}
	
	public boolean getDoubles()
	{
		return doubles;
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