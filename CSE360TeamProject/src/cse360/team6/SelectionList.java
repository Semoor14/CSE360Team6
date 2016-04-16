package cse360.team6;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * SelectionList is a class which is a vertical list of buttons with various texts on them,
 * where up to one button can be pressed at any one time
 * @author kyle
 */
public class SelectionList
{
	//the x and y position of the list on the screen
	protected int xPosition;
	protected int yPosition;
	
	//the total width and height of the list on the screen
	protected int width;
	protected int height;
	
	//an array of pointers to the CenteredTextButtons that make up the list
	private CenteredTextButton[] listOfButtons;
	//the height of each button in the list
	private int buttonHeight;
	
	/**
	 * A constructor for the SelectionList class.
	 * @param buttonNames An array of all the names of each button, in order.
	 * @param x The x position of the list on the screen.
	 * @param y The y position of the list on the screen.
	 * @param width The width of the list on the screen.
	 * @param height The height of the list on the screen.
	 */
	public SelectionList(String[] buttonNames, int x, int y, int width, int height)
	{
		listOfButtons = new CenteredTextButton[buttonNames.length];
		
		//calculate the height of each button and populate the list of buttons
		buttonHeight= height/buttonNames.length;
		for (int index = 0; index < buttonNames.length;index++)
		{
			CenteredTextButton newButton = new CenteredTextButton(buttonNames[index],x, y+index*buttonHeight,width, buttonHeight, DiceGame.mediumFont);
			listOfButtons[index] = newButton;
		}
	}
	
	/**
	 * Detect if the given set of mouse positions have clicked one of the buttons in our list.
	 * @param clickPositionX The x position of the mouse click.
	 * @param clickPositionY The y position of the mouse click.
	 * @return If the mouse position is inside one of our buttons.
	 */
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].isWithinBound(clickPositionX, clickPositionY))
				return true;
		}
		return false;
	}
	
	/**
	 * Based on the given click position x and y values, activate the button being clicked,
	 * and deactivate the other buttons.
	 * @param clickPositionX The x position of the mouse click.
	 * @param clickPositionY The y position of the mouse click.
	 */
	public void pressListButton(int clickPositionX, int clickPositionY)
	{
		//find and select the correct button
		int pressedIndex = -1;
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].isWithinBound(clickPositionX, clickPositionY))
			{
				pressedIndex = index;
			}
		}
		//if a button was actually pressed, unselect all other buttons
		if (pressedIndex != -1)
		{
			listOfButtons[pressedIndex].SetSelected(true);
			for (int index = 0; index < listOfButtons.length;index++)
			{
				if (index != pressedIndex)
				{
					listOfButtons[index].SetSelected(false);;
				}
			}
		}
	}
	
	/**
	 * Get the index of the button that is selected, or -1 if no button is selected.
	 * @return The index of the button that is selected, or -1 if no button is selected.
	 */
	public int getSelectedIndex()
	{
		int selectedIndex = -1;
		for (int index = 0; index < listOfButtons.length;index++)
		{
			if (listOfButtons[index].GetSelected())
			{
				selectedIndex = index;
			}
		}
		return selectedIndex;
	}
	
	/**
	 * Get the String name of the button at the given index in the button list.
	 * @param index The index of the button in the list.
	 * @return The name of the button at the given index.
	 */
	public String getButtonNameAtIndex(int index)
	{
		return listOfButtons[index].text;
	}
	
	/**
	 * Render the list of buttons to the screen.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		//go through all buttons and make them render themselves
		for (int index = 0; index < listOfButtons.length;index++)
		{
			listOfButtons[index].render(gameContainer, game, g);
		}
	}
	
	/**
	 * Get the size of the list of buttons.
	 * @return The size of the list of buttons.
	 */
	public int sizeOfList()
	{
		return listOfButtons.length;
	}
}
