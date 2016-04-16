package cse360.team6;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A group of selection lists seperated by space.
 * @author kyle
 */
public class SelectionListGroup
{
	//an array of all the selection lists in the group
	private SelectionList[] selectionLists;
	
	/**
	 * Constructor for a group of selection lists.
	 * @param listOfLists An array of arrays of strings. Each array in the array is the string name of buttons in a single list.
	 * @param x The x position of the group on the screen.
	 * @param y The y position of the group on the screen.
	 * @param width The width of the group on the screen.
	 * @param listElementheight The height of each button in a list.
	 * @param spacingBetweenLists The height space between lists.
	 */
	public SelectionListGroup (String[][] listOfLists, int x, int y, int width, int listElementheight, int spacingBetweenLists)
	{
		selectionLists = new SelectionList[listOfLists.length];
		
		int currentY = y;
		for (int index = 0; index < listOfLists.length;index++)
		{
			String[] stringsForList = listOfLists[index];
			int listHeight = stringsForList.length * listElementheight;
			
			SelectionList list = new SelectionList(stringsForList, x, currentY, width, listHeight);
			
			currentY += listHeight + spacingBetweenLists;
			
			selectionLists[index] = list;
		}
	}
	
	/**
	 * Determines if the given click position x and y combo is inside any of the lists in our group.
	 * @param clickPositionX The x position of the click.
	 * @param clickPositionY The y position of the click.
	 * @return Whether or not the given click is inside any lists in our group.
	 */
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		boolean isWithinBound = false;
		for (int index = 0; index < selectionLists.length;index++)
		{
			if (selectionLists[index].isWithinBound(clickPositionX, clickPositionY))
				isWithinBound = true;
		}
		return isWithinBound;
	}
	
	/**
	 * Activates the list button that is being clicked by the given x and y click position.
	 * @param clickPositionX The x position of the activating click.
	 * @param clickPositionY The y position of the activating click.
	 */
	public void pressListButton(int clickPositionX, int clickPositionY)
	{
		for (int index = 0; index < selectionLists.length;index++)
		{
			if (selectionLists[index].isWithinBound(clickPositionX, clickPositionY))
			{
				selectionLists[index].pressListButton(clickPositionX, clickPositionY);
			}
		}
	}
	
	/**
	 * Gets the selection list that is at the given index in the array of selection lists.
	 * @param index
	 * @return The SelectionList at the given index in the SelectionList array.
	 */
	public SelectionList getSelectionListAtIndex(int index)
	{
		return selectionLists[index];
	}
	
	/**
	 * Render the list of SelectionLists to the screen.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		for (int index = 0; index < selectionLists.length;index++)
		{
			selectionLists[index].render(gameContainer, game, g);
		}
	}
}
