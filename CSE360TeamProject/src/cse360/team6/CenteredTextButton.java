package cse360.team6;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class CenteredTextButton extends CenteredTextBox
{
	public CenteredTextButton(String text, int xPos, int yPos, int width, int height, TrueTypeFont font) {
		super(text, xPos, yPos, width, height, font);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		boolean xWithinBounds = clickPositionX >= xPosition && clickPositionX <= xPosition + width;
		boolean yWithinBounds = clickPositionY >= yPosition && clickPositionY <= yPosition + height;
		return (xWithinBounds && yWithinBounds);
	}
	
	@Override
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
