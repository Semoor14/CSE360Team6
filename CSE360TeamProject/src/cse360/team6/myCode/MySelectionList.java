package dice.game.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class MySelectionList 
{
	
	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	
	private MyCenteredTextButton[] listOfButtons;
	private int buttonHeight;
	
	public MySelectionList(String[] buttonNames, int x, int y, int width, int height)
	{
		listOfButtons = new MyCenteredTextButton[buttonNames.length];
		buttonHeight= height/buttonNames.length;
		for (int index = 0; index < buttonNames.length;index++)
		{
			MyCenteredTextButton newButton = new MyCenteredTextButton(buttonNames[index],x, y+index*buttonHeight,width, buttonHeight, MyDiceGame.mediumFont);
			listOfButtons[index] = newButton;
		}
	}
	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].isWithinBound(clickPositionX, clickPositionY))
				return true;
		}
		return false;
	}
	
	public void pressListButton(int clickPositionX, int clickPositionY)
	{
		int pressedIndex = -1;
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].isWithinBound(clickPositionX, clickPositionY))
			{
				pressedIndex = index;
			}
		}
		if (pressedIndex == -1)
		{
			return;
		}
		
		listOfButtons[pressedIndex].SetSelected(true);
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (index != pressedIndex)
			{
				listOfButtons[index].SetSelected(false);;
			}
		}
	}
	
	public int getSelectedIndex()
	{
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].GetSelected())
			{
				return index;
			}
		}
		return -1;
	}
	
	public String getButtonNameAtIndex(int index)
	{
		return listOfButtons[index].text;
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		for (int index = 0; index < listOfButtons.length;index++)
		{
			listOfButtons[index].render(gameContainer, game, g);
		}
	}
}