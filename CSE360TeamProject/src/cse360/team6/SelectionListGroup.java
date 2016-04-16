package cse360.team6;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class SelectionListGroup
{
	private SelectionList[] selectionLists;
	
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
	
	public boolean isWithinBound(int clickPositionX, int clickPositionY)
	{
		for (int index = 0; index < selectionLists.length;index++)
		{
			if (selectionLists[index].isWithinBound(clickPositionX, clickPositionY))
				return true;
		}
		return false;
	}
	
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
	
	public SelectionList getSelectionListAtIndex(int index)
	{
		return selectionLists[index];
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		for (int index = 0; index < selectionLists.length;index++)
		{
			selectionLists[index].render(gameContainer, game, g);
		}
	}
}
