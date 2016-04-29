package dice.game.myCode;

import org.newdawn.slick.*; import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, CenteredTextButton, DiceGame, ReadRules   
public class RulesState extends ParentGameState 
{
	private CenteredTextButton exitButton;
	private CenteredTextButton nextPageButton;
	private CenteredTextButton prevPageButton;
	private int pageNumber; 
	
	private final String P1_L1 = "Objective:";
	private final String P1_L2 = "Have your score hit 59 exactly";
	private final String P1_L3 = "Setup:";
	private final String P1_L4 = "All players start at 0 score and an empty queue. Random player goes first.";
	private final String P1_L5 = "Basic Turn:";
	private final String P1_L6 = "Roll the 2 10 sided dice. Choose 1 to add to your score, the other will be";
	private final String P1_L7 = "added to your queue.";
	private final String P1_L8 = "Score:";
	private final String P1_L9 = "If adding a value to your score would put it over 37, subtract that value";	
	private final String P1_L10 = "instead. If subtracting a value from your score would put it below 0, add";
	private final String P1_L11 = "add that value instead.";	
	private final String P1_L12 = "Queue:";
	private final String P1_L13 = "The queue is a first in first out queue. This queue holds 5 values, so when";
	private final String P1_L14 = "a value is added to a full queue of 5 the first one added disappears and the";
	private final String P1_L15 = "the new one is inserted at the beginning.";
	private final String P1_L16 = "Redeeming Hands:";
	private final String P1_L17 = "Before rolling the dice or after choosing which go to score and queue, a";
	private final String P1_L18 = "player may choose to redeem a hand. Only 1 hand can be redeemed per turn.";
	private final String P1_L19 = "Hands come from selecting specific combinations of values in the queue. ";
	private final String P1_L20 = "These values can appear in any order and any spots in the queue. Then ";
	private final String P1_L21 = "special action(s) are taken based upon which hand was redeemed. ";
	private final String P1_L22 = "Redeemed values are removed from the queue.";
	
	private final String P2_L1 = "Hands Speical Actions:";
	private final String P2_L2 = "Pair- Skip the next player's turn.";
	private final String P2_L3 = "3 of a Kind- Choose X from 0-3. Add X to your score and subtract 3-X from";
	private final String P2_L4 = "all opponents' scores. Skip the next player's turn.";
	private final String P2_L5 = "4 of a Kind- Choose X from 0-3 and Y from 1-2. Add X*Y to your score and ";
	private final String P2_L6 = "subtract 6-(X*Y) from all opponents' scores. Take another turn.";
	private final String P2_L7 = "5 of a Kind- Win the game.";
	private final String P2_L8 = "Run of 3- Roll the dice. Choose a value to put into your queue. Do this";
	private final String P2_L9 = "3 times.";
	private final String P2_L10 = "Run of 4- Roll the dice. Choose a value to put into your queue and put";
	private final String P2_L11 = "the other value into all opponents' queues. Do This 4 times.";
	private final String P2_L12 = "Run of 5- Rll the dice. Choose a value to put into your queue. Put a 0";
	private final String P2_L13 = "into all opponents' queues. Do this 5 times.";
	private final String P2_L14 = "Variant Rules: ";
	private final String P2_L15 = "Sum Rule- If all player's scores sum to 163 at anytime, the player whose";
	private final String P2_L16 = "turn it is wins the game.";
	private final String P2_L17 = "Doubles Rule- If a player rolls doubles during their regular roll, they";
	private final String P2_L18 = "may also add both values to their score or both to their queue.";
	
	
	
	public RulesState(int sID) 
	{
		super(sID); 
	}   
	
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", Place.RS_EXITBUTTON_XPOS, Place.RS_BUTTON_YPOS, Place.RS_BUTTON_WIDTH, Place.RS_BUTTON_HEIGHT, DiceGame.smallFont);
		nextPageButton = new CenteredTextButton("Next Page", Place.RS_EXITBUTTON_XPOS, Place.RS_BUTTON_YPOS, Place.RS_BUTTON_WIDTH, Place.RS_BUTTON_HEIGHT, DiceGame.smallFont);
		prevPageButton = new CenteredTextButton("Previous Page", Place.RS_PREVPAGEBUTTON_XPOS, Place.RS_BUTTON_YPOS, Place.RS_BUTTON_WIDTH, Place.RS_BUTTON_HEIGHT, DiceGame.smallFont);
		pageNumber = 1;
	}   
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		if(pageNumber == 1)
		{
			renderPage1(gameContainer, stateGame, g);
		}
		else // pageNumber == 2
		{
			renderPage2(gameContainer, stateGame, g);
		}
	}   
	
	public void renderPage1 (GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException
	{
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L1, Place.RS_XPOS, Place.RS_YPOS);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L2, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L3, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*2);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L4, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*3);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L5, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*4);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L6, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*5);
		g.drawString(P1_L7, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*6);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L8, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*7);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L9, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*8);
		g.drawString(P1_L10, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*9);
		g.drawString(P1_L11, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*10);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L12, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*11);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L13, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*12);
		g.drawString(P1_L14, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*13);
		g.drawString(P1_L15, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*14);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P1_L16, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*15);
		g.setFont (DiceGame.smallFont);
		g.drawString(P1_L17, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*16);
		g.drawString(P1_L18, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*17);
		g.drawString(P1_L19, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*18);
		g.drawString(P1_L20, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*19);
		g.drawString(P1_L21, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*20);
		g.drawString(P1_L22, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*21);
		nextPageButton.render(gameContainer, stateGame, g);
	}

	public void renderPage2 (GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException
	{
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P2_L1, Place.RS_XPOS, Place.RS_YPOS);
		g.setFont (DiceGame.smallFont);
		g.drawString(P2_L2, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE);
		g.drawString(P2_L3, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*2);
		g.drawString(P2_L4, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*3);
		g.drawString(P2_L5, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*4);
		g.drawString(P2_L6, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*5);
		g.drawString(P2_L7, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*6);
		g.drawString(P2_L8, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*7);
		g.drawString(P2_L9, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*8);
		g.drawString(P2_L10, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*9);
		g.drawString(P2_L11, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*10);
		g.drawString(P2_L12, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*11);
		g.drawString(P2_L13, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*12);
		g.setFont (DiceGame.smallBoldFont);
		g.drawString(P2_L14, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*13);
		g.setFont (DiceGame.smallFont);
		g.drawString(P2_L15, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*14);
		g.drawString(P2_L16, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*15);
		g.drawString(P2_L17, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*16);
		g.drawString(P2_L18, Place.RS_XPOS, Place.RS_YPOS + Place.RS_YDIFFERENCE*17);
		exitButton.render(gameContainer, stateGame, g); 
		prevPageButton.render(gameContainer, stateGame, g);
	}
	
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException 
	{ 
		Input input = gameContainer.getInput(); if(input.isMousePressed(0)) 
		{ 
			int mouseX = input.getMouseX(); 
			int mouseY = input.getMouseY(); 
			if(pageNumber == 1)
			{
				updatePage1(mouseX, mouseY);
			}
			else // pageNumber == 2
			{
				updatePage2(stateGame, mouseX, mouseY);
			}
 
			} 
		}   
	
	public void updatePage1(int clickPositionX, int clickPositionY) 
	{ 
		if(nextPageButton.isWithinBound(clickPositionX, clickPositionY))
		{
			pageNumber++;
		}
	}   
	public void updatePage2(StateBasedGame stateGame, int clickPositionX, int clickPositionY)
	{
		if(exitButton.isWithinBound(clickPositionX, clickPositionY))
		{
			stateGame.enterState(DiceGame.MAIN);
		}		
		if(prevPageButton.isWithinBound(clickPositionX, clickPositionY))
		{
			pageNumber--;
		}
	}
}

