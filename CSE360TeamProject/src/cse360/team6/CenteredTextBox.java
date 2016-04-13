package cse360.team6;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class CenteredTextBox
{
	protected String text;
	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	protected TrueTypeFont textFont;
	
	public CenteredTextBox(String text, int xPos, int yPos, int width, int height, TrueTypeFont font)
	{
		this.text = text;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.width = width;
		this.height = height;
		this.textFont = font;
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(xPosition, yPosition, width, height);
		
		g.setFont(textFont);
		int lineHeight = textFont.getLineHeight();
		int lineWidth = textFont.getWidth(text);
		
		int middleX = xPosition + (width - lineWidth)/2;
		int middleY = yPosition + (height - lineHeight)/2;
		
		g.drawString(text, middleX, middleY);
	}
}
