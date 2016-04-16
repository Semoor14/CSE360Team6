package cse360.team6.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A textbox that centers the text inside of it. Basic UI component.
 * @author Kyle Chapman and Cole Stanton
 */
public class CenteredTextBox
{
	//The string text and other fields that inform how to render the box on screen.
	protected String text;
	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	//the font of the text in the box
	protected TrueTypeFont textFont;
	
	//Whether or not the box is selected or not. If true, the color is inverted.
	protected boolean selected;
	
	/**
	 * Constructor for the CenteredTextBox.
	 * @param text The text to be displayed in the both.
	 * @param xPos The x positon of the box on the screen.
	 * @param yPos The y positon of the box on the screen.
	 * @param width The width of the box on the screen.
	 * @param height The height of the box on the screen.
	 * @param font The font to display the text in.
	 */
	public CenteredTextBox(String text, int xPos, int yPos, int width, int height, TrueTypeFont font)
	{
		this.text = text;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.width = width;
		this.height = height;
		this.textFont = font;
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
	
	public void SetText(String newText)
	{
		text = newText;
	}
	
	/**
	 * Renders this text box to the screen, with different colors if it is selected.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		g.setColor(Color.black);
		if (selected)
		{
			g.fillRect(xPosition, yPosition, width, height);
			g.setColor(Color.white);
		}
		else
		{
			g.drawRect(xPosition, yPosition, width, height);
			g.setColor(Color.black);
		}
		
		g.setFont(textFont);
		int lineHeight = textFont.getLineHeight();
		int lineWidth = textFont.getWidth(text);
		
		int middleX = xPosition + (width - lineWidth)/2;
		int middleY = yPosition + (height - lineHeight)/2;
		
		g.drawString(text, middleX, middleY);
	}
}
