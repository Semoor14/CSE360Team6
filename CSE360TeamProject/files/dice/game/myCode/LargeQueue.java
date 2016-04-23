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
	private int [] values;
	
	public LargeQueue (TrueTypeFont mediumFont)
	{
		QButton1 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton2 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton3 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*2, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		QButton4 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*3, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);		
		QButton5 = new CenteredTextButton("", Place.LQ_BUTTON1_XPOS + Place.LQ_BUTTON_WIDTH*4, Place.LQ_BUTTON_YPOS, Place.LQ_BUTTON_WIDTH, Place.LQ_BUTTON_HEIGHT, mediumFont);
		values = new int [5];
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		QButton1.render(gameContainer, game, g);
		QButton2.render(gameContainer, game, g);
		QButton3.render(gameContainer, game, g);
		QButton4.render(gameContainer, game, g);
		QButton5.render(gameContainer, game, g);
	}
	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		boolean result = false;
		if(QButton1.isWithinBound(clickPositionX, clickPositionY) && values[4] != 0)
		{
			QButton1.InvertSelection();
			result = true;
		}
		if(QButton2.isWithinBound(clickPositionX, clickPositionY)  && values[3] != 0)
		{
			QButton2.InvertSelection();
			result = true;
		}
		if(QButton3.isWithinBound(clickPositionX, clickPositionY)  && values[2] != 0)
		{
			QButton3.InvertSelection();
			result = true;
		}
		if(QButton4.isWithinBound(clickPositionX, clickPositionY)  && values[1] != 0)
		{
			QButton4.InvertSelection();
			result = true;
		}
		if(QButton5.isWithinBound(clickPositionX, clickPositionY)  && values[0] != 0)
		{
			QButton5.InvertSelection();
			result = true;
		}
		return result;
	}
	
	public void setValues(int [] newValues)
	{
		values[0] = newValues[0];
		values[1] = newValues[1];
		values[2] = newValues[2];
		values[3] = newValues[3];
		values[4] = newValues[4];
		setBoxesText();
	}
	
	public void setBoxesText()
	{
		QButton1.SetText(values[4] + "");
		QButton2.SetText(values[3] + "");
		QButton3.SetText(values[2] + "");
		QButton4.SetText(values[1] + "");
		QButton5.SetText(values[0] + "");		
	}
	
	public void resetSelections()
	{
		QButton1.SetSelected(false);
		QButton2.SetSelected(false);
		QButton3.SetSelected(false);
		QButton4.SetSelected(false);
		QButton5.SetSelected(false);
	}
	
	public int[] getSelectedValues()
	{
		int numSelected = 0;
		boolean[] selectedQueue = new boolean[5];
		if(QButton1.GetSelected())
		{
			selectedQueue[4] = true;
			numSelected++;
		}
		if(QButton2.GetSelected())
		{
			selectedQueue[3] = true;
			numSelected++;
		}
		if(QButton3.GetSelected())
		{
			selectedQueue[2] = true;
			numSelected++;
		}
		if(QButton4.GetSelected())
		{
			selectedQueue[1] = true;
			numSelected++;
		}
		if(QButton5.GetSelected())
		{
			selectedQueue[0] = true;
			numSelected++;
		}
		int[] result = new int[numSelected];
		int indexToInsert = 0;
		for(int index = 0; index < 5; index++)
		{
			if(selectedQueue[index])
			{
				result[indexToInsert] = values[index];
				indexToInsert++;
			}
		}
			
		return result;
	}
	
}
