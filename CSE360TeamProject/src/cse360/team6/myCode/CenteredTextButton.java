package cse360.team6.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * CenteredTextButton is a child of the CenteredTextBox class.
 * Which can be pressed and changes color when activated.
 * @author Kyle Chapman and Cole Stanton
 */
public class CenteredTextButton extends CenteredTextBox
{
	/**
	 * Constructor for the CenteredTextButton.
	 * @param text The text to display on the button.
	 * @param xPos The x position of the button on the screen.
	 * @param yPos The y position of the button on the screen.
	 * @param width The width of the button on the screen.
	 * @param height The height of the button on the screen.
	 * @param font The font to display the font in.
	 */
	public CenteredTextButton(String text, int xPos, int yPos, int width, int height, TrueTypeFont font) 
	{
		super(text, xPos, yPos, width, height, font);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Set whether the button is selected or not.
	 * @param selected Whether the button is selected or not.
	 */
	public void SetSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	/**
	 * Invert whether the button is selected or not.
	 * The status of the will be made opposite of what it is.
	 */
	public void InvertSelection()
	{
		selected = !selected;
	}
	
	/**
	 * Get whether or not the button is selected.
	 * @return Whether or not the button is selected.
	 */
	public boolean GetSelected()
	{
		return selected;
	}
	
	/**
	 * Get whether the given set of x and y screen positions is inside this button.
	 * @param clickPositionX The x position on the screen.
	 * @param clickPositionY The y position on the screen.
	 * @return Whether or not the given screen position is inside this button.
	 */
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		boolean xWithinBounds = clickPositionX >= xPosition && clickPositionX <= xPosition + width;
		boolean yWithinBounds = clickPositionY >= yPosition && clickPositionY <= yPosition + height;
		return xWithinBounds && yWithinBounds;
	}
}
