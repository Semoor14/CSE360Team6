package dice.game.myCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The small queue showing player queue numbers in a row of five boxes.
 * @author Cole Stanton
 */
public class SmallQueue 
{	
	private CenteredTextBox QBox1;
	private CenteredTextBox QBox2;
	private CenteredTextBox QBox3;
	private CenteredTextBox QBox4;
	private CenteredTextBox QBox5;

	/**
	 * Initializes a SmallQueue with its five CenteredTextBoxes
	 * @param YMultiplier The multiplier to space out the five boxes in the y direction.
	 * @param sFont The font to render the text of the boxes in.
	 */
	public SmallQueue(int YMultiplier, TrueTypeFont sFont)
	{
		int YPosition = Place.SQ_BOX1_YPOS + Place.SQ_BOX_YCHANGE * YMultiplier;
		QBox1 = new CenteredTextBox("", Place.SQ_BOX1_XPOS, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox2 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox3 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*2, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);		
		QBox4 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*3, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox5 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*4, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);		
	}
	
	/**
	 * Renders the different buttons of the queue.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		QBox1.render(gameContainer, game, g);
		QBox2.render(gameContainer, game, g);
		QBox3.render(gameContainer, game, g);
		QBox4.render(gameContainer, game, g);
		QBox5.render(gameContainer, game, g);
	}
	
	/**
	 * Changes the values in each box to the string representation of the given ints.
	 * @param values The values to set the text boxes to.
	 */
	public void changeAllBoxesText(int[] values)
	{
			QBox5.SetText(values[0]+"");
			QBox4.SetText(values[1]+"");
			QBox3.SetText(values[2]+"");
			QBox2.SetText(values[3]+"");
			QBox1.SetText(values[4]+"");
	}
	
	/**
	 * Invert all boxes in the queue.
	 */
	public void invertSmallBoxes()
	{
		QBox5.InvertSelection();
		QBox4.InvertSelection();
		QBox3.InvertSelection();
		QBox2.InvertSelection();
		QBox1.InvertSelection();
	}
	
	/**
	 * Returns a boolean array of the selection status of each of the five buttons.
	 * @return A 5 sided boolean array containing the status of each button.
	 */
	public boolean[] getBooleanSelectedIndexes()
	{
		boolean[] selectedQueue = new boolean[5];
		if(QBox1.GetSelected())
		{
			selectedQueue[4] = true;
		}
		if(QBox2.GetSelected())
		{
			selectedQueue[3] = true;
		}
		if(QBox3.GetSelected())
		{
			selectedQueue[2] = true;
		}
		if(QBox4.GetSelected())
		{
			selectedQueue[1] = true;
		}
		if(QBox5.GetSelected())
		{
			selectedQueue[0] = true;
		}
		return selectedQueue;
	}
}