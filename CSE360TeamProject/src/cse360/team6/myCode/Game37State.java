package cse360.team6.myCode;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game37State implements GameState
{
	// first turn
	private boolean firstTurn;
	private LargeQueue largeQueue;
	private Player player1;
	private Player player2; 
	private Player player3;
	private Player player4;
	private DiceHandler diceHandler;
	
	private CenteredTextButton endTurnButton;
	private CenteredTextButton rollButton;
	private int endTurnRoll_XPos = 412; 
	private int endTurnRoll_YPos = 32;
	private int endTurnRoll_Width = 96;
	private int endTurnRoll_Height = 32;
	
	private CenteredTextBox QPromptBox;
	private int QPromptBox_XPos = 232;
	private int QPromptBox_YPos = 160;
	private int QPromptBox_Width = 176;
	private int QPromptBox_Height = 32;
	
	private CenteredTextButton redeemQueueButton;
	// private groupOfSelectionLists handGroup;
	private SelectionList confirmCancelList;
	
	
	
	private CenteredTextButton dieSelectedConfirmButton;
	private int dieSelectedConfirmButton_XPos = 232;
	private int dieSelectedConfirmButton_YPos = 224;
	private int dieSelectedConfirmButton_Width = 176;
	private int dieSelectedConfirmButton_Height = 32;	
	
	private CenteredTextButton redeemButton;
	private int redeemButton_XPos = 232;
	private int redeemButton_YPos = 192;
	private int redeemButton_Width = 176;
	private int redeemButton_Height = 32;

	
	
	// private MyPokerBox pokerBox;
	private int rulesButton_XPos = 464;
	private int rulesButton_YPos = 392;
	private int rulesButton_Width = 160;
	private int rulesButton_Height = 32;
	
	private int exitButton_XPos = 464;
	private int exitButton_YPos = 432;
	private int exitButton_Width = 160;
	private int exitButton_Height = 32;

	private CenteredTextButton rulesButton;
	private CenteredTextButton exitButton;
	
	private CenteredTextBox finishedRedeemBox;
	private int finishedRedeemBox_XPos = 248;
	private int finishedRedeemBox_YPos = 96;
	private int finishedRedeemBox_Width = 144;
	private int finishedRedeemBox_Height = 32;
	
	private int playerNumberTurn;
	
	private boolean hasRolled;
	private boolean hasRedeemed;
	private boolean hasConfirmedRoll;
	private boolean hasConfirmedRedeem;
	
	private boolean endCurrentTurn;
	private int whoWonTheGame;
	
	public Game37State(int main)
	{}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{}
	
	public void confirmDieSelected(int dieSelected, int unSelected)
	{
		getCurrentPlayerObject().addDieValue(dieSelected, unSelected);
	}
	
	public void newTurn()
	{
		System.out.println("newTurn");
		if(firstTurn)
		{
			
		}
		else
		{
			getCurrentPlayerObject().InvertAllBoxes();
		}
		
		if((playerNumberTurn) < 4)
		{
			playerNumberTurn++;
		}
		else
		{
			playerNumberTurn = 1;
		}
		getCurrentPlayerObject().InvertAllBoxes();
		
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		endCurrentTurn = false;
		
		diceHandler.resetDice();
		firstTurn = false;
	}
	
	public Player getCurrentPlayerObject()
	{
		Player result;
		
		if(playerNumberTurn == 1)
		{
			result = player1;
		}
		else if(playerNumberTurn == 2)
		{
			result = player2;
		}
		else if (playerNumberTurn == 3)
		{
			result = player3;
		}
		else // playerNumberTurn == 4
		{
			result = player4;
		}
		return result;
	}
	
	// methods for different turn "states"
	
	// always Update

	public void updateAlways()
	{
		int winnerIs = 0;
		
		if(player1.checkForWin() != 0)
		{
			winnerIs = player1.checkForWin();	
		}
		if(player2.checkForWin() != 0)
		{
			winnerIs = player2.checkForWin();
		}
		if(player3.checkForWin() != 0)
		{
			winnerIs = player3.checkForWin();
		}
		if(player4.checkForWin() != 0)
		{
			winnerIs = player4.checkForWin();
		}
		whoWonTheGame = winnerIs;
	}
	
	// write game over method
	
	// Update
	public void updateNoRollNoRedeem(int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			diceHandler.rollDice();
			hasRolled = true;
		}
		largeQueue.isWithinBound(clickPositionX, clickPositionY);
		// if(selectedLargeQueuvalues form a hand)
		// { 
		// 		isWithinBound redeemButton
		// }
		
		// transitions
		// if(isWithinBoundRollButton)
		// 		hasRolled = true;
		// if(isWithinBoundRedeemButton)
		// 		hasRedeemed = true;
	}
	
	public void updateNoConfirmRollNoRedeem(int clickPositionX, int clickPositionY)
	{
		diceHandler.isWithinBound(clickPositionX, clickPositionY);
		
		if(diceHandler.getSelected() != 0)
		{
			if(dieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				if(diceHandler.getSelected() == 1)
				{
					confirmDieSelected(diceHandler.getDie1(), diceHandler.getDie2());
					hasConfirmedRoll = true;
				}
				else // diceHandler.getSelected() == 2
				{
					confirmDieSelected(diceHandler.getDie2(), diceHandler.getDie1());
					hasConfirmedRoll = true;
				}
			}
		}
		// if(dieselected != 0)
		// {
		// 		isWithinBound confirmDieSelectedButton
		// 		selected == 1
		// 		selected == 2
		// }
		largeQueue.isWithinBound(clickPositionX, clickPositionY);
		
		// transitions
		// if(isWithinBound confirmDieSelectedButton)
		// {
		// 		hasConfirmedRoll = true;	
		// }
	}
	
	public void updateNoRedeem(int clickPositionX, int clickPositionY)
	{
		largeQueue.isWithinBound(clickPositionX, clickPositionY);
		// if(selectedLargeQueue values form a hand)
		// {
		// 		isWithinBound redeemButton
		// }
		if(endTurnButton.isWithinBound(clickPositionX, clickPositionY))
		{
			endCurrentTurn = true;
		}
		// transitions
		// if(isWithinBound redeemButton)
		// 		hasRedeemed = true;
		// if(isWithinBound endTurnButton)
		// 		endTurn;
	}
	
	public void updateNoConfirmRedeem (int clickPositionX, int clickPositionY)
	{
		/*
		 Skipping for now
		 */
	}
	
	public void updateAllConfirmed(int clickPositionX, int clickPositionY)
	{
		if(endTurnButton.isWithinBound(clickPositionX, clickPositionY))
		{
			endCurrentTurn = true;
		}
		
		// transitions
		// if(isWithinBound endTurn)
		// 		EndTurn;
	}
	
	public void updateNoRollNoConfirmRedeem(int clickPositionX, int clickPositionY)
	{
		/*
		 Skip
		 */
	}
	
	public void updateNoRoll(int clickPositionX, int clickPositionY)
	{
		/*
		 Skip
		 */
	}
	
	public void updateNoConfirmRoll (int clickPositionX, int clickPositionY)
	{
		/*
		  Skip
		 */
	}
	
	// Rendering
	public void renderNoRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		diceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		// if selectedLArgeQueueValues form a hand
		// {
		// 		render redeemButton
		// }
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoConfirmRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		if(diceHandler.getSelected() != 0)
		{
			dieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		largeQueue.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		// if(selectedLargeQueue values form a hand)
		// {
		// 		render RedeemButton	
		// }
		endTurnButton.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
		
		
	}
	
	public void renderNoConfirmRedeem (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		/*
		 Skip
		 */
	}
	
	public void renderAllConfirmed(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		endTurnButton.render(gameContainer, stateGame, g);
		// render finished RedeemBox
	}
	
	public void renderNoRollNoConfirmRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		/*
		 Skip
		 */
	}
	
	public void renderNoRoll(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		/*
		 Skip
		 */
	}
	
	public void renderNoConfirmRoll (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		/*
		 Skip
		 */
	}

	
	// always render method
	public void alwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		// diceHandler.render(gameContainer, stateGame, g);
		player1.render(gameContainer, stateGame, g);
		player2.render(gameContainer, stateGame, g);
		player3.render(gameContainer, stateGame, g);
		player4.render(gameContainer, stateGame, g);
		// pokerBox.render(gameContainer, stateGame, g);
		rulesButton.render(gameContainer, stateGame, g);
		exitButton.render(gameContainer, stateGame, g);
	}
	
	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int delta) throws SlickException 
	{
		updateAlways();
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			if(!hasRolled && !hasRedeemed)
			{
				updateNoRollNoRedeem(mouseX, mouseY);
			}
			else if (hasRolled && !hasConfirmedRoll && !hasRedeemed)
			{
				updateNoConfirmRollNoRedeem(mouseX, mouseY);
			}
			else if (hasConfirmedRoll && !hasRedeemed)
			{
				updateNoRedeem(mouseX, mouseY);
			}
			else if (hasConfirmedRoll && hasRedeemed && !hasConfirmedRedeem)
			{
				updateNoConfirmRedeem(mouseX, mouseY);
			}
			else if (hasConfirmedRoll && hasConfirmedRedeem)
			{
				updateAllConfirmed(mouseX, mouseY);
			}
			else if (!hasRolled && hasRedeemed && !hasConfirmedRedeem)
			{
				updateNoRollNoConfirmRedeem(mouseX, mouseY);
			}
			else if(!hasRolled && hasConfirmedRedeem)
			{
				updateNoRoll(mouseX, mouseY);
			}
			else if (hasRolled && !hasConfirmedRoll && !hasConfirmedRedeem)
			{
				updateNoConfirmRoll(mouseX, mouseY);
			}			
			if(endCurrentTurn == true)
			{
				newTurn();
			}
		}
	}
	
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.white); // move to enter??
		alwaysRender(gameContainer, stateGame, g);

		if(!hasRolled && !hasRedeemed)
		{
			renderNoRollNoRedeem(gameContainer, stateGame, g);
		}
		else if (hasRolled && !hasConfirmedRoll && !hasRedeemed)
		{
			renderNoConfirmRollNoRedeem(gameContainer, stateGame, g);
		}
		else if (hasConfirmedRoll && !hasRedeemed)
		{
			renderNoRedeem(gameContainer, stateGame, g);
		}
		else if (hasConfirmedRoll && hasRedeemed && !hasConfirmedRedeem)
		{
			renderNoConfirmRedeem(gameContainer, stateGame, g);
		}
		else if (hasConfirmedRoll && hasConfirmedRedeem)
		{
			renderAllConfirmed(gameContainer, stateGame, g);
		}
		else if (!hasRolled && hasRedeemed && !hasConfirmedRedeem)
		{
			renderNoRollNoConfirmRedeem(gameContainer, stateGame, g);
		}
		else if(!hasRolled && hasConfirmedRedeem)
		{
			renderNoRoll(gameContainer, stateGame, g);
		}
		else if (hasRolled && !hasConfirmedRoll && !hasConfirmedRedeem)
		{
			renderNoConfirmRoll(gameContainer, stateGame, g);
		}
				
		/*
		if (largeQueue != null)
			largeQueue.render(gameContainer, stateGame, g);
		if(player1 != null)
			player1.render(gameContainer, stateGame, g);
		if(diceHandler != null)
			diceHandler.render(gameContainer, stateGame, g);
		*/
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		//initialize fonts
		DiceGame.initializeFonts();
		largeQueue = new LargeQueue(DiceGame.mediumFont);
		player1 = new Player("Player 1", 1, DiceGame.smallFont);
		player2 = new Player("Player 2", 2, DiceGame.smallFont);
		player3 = new Player("Player 3", 3, DiceGame.smallFont);
		player4 = new Player("Player 4", 4, DiceGame.smallFont);
		diceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont);
		endTurnButton = new CenteredTextButton("End Turn", endTurnRoll_XPos, endTurnRoll_YPos, endTurnRoll_Width, endTurnRoll_Height, DiceGame.smallFont);
		rollButton = new CenteredTextButton("Roll", endTurnRoll_XPos, endTurnRoll_YPos, endTurnRoll_Width, endTurnRoll_Height, DiceGame.smallFont);
		QPromptBox = new CenteredTextBox("None", QPromptBox_XPos, QPromptBox_YPos, QPromptBox_Width, QPromptBox_Height, DiceGame.smallFont);
		rulesButton = new CenteredTextButton("View Rules", rulesButton_XPos, rulesButton_YPos, rulesButton_Width, rulesButton_Height, DiceGame.smallFont);
		exitButton = new CenteredTextButton("Return to Main", exitButton_XPos, exitButton_YPos, exitButton_Width, exitButton_Height, DiceGame.smallFont);
		finishedRedeemBox = new CenteredTextBox("Redeemed", finishedRedeemBox_XPos, finishedRedeemBox_YPos, finishedRedeemBox_Width, finishedRedeemBox_Height, DiceGame.smallFont); 
		
		dieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", dieSelectedConfirmButton_XPos, dieSelectedConfirmButton_YPos, dieSelectedConfirmButton_Width, dieSelectedConfirmButton_Height, DiceGame.smallFont);		
		redeemButton = new CenteredTextButton("Redeem Hand", redeemButton_XPos, redeemButton_YPos, redeemButton_Width, redeemButton_Height, DiceGame.smallFont);
		
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		playerNumberTurn = 0;
		endCurrentTurn = false;
		firstTurn = true;
		
		newTurn();
	}

	@Override
	public void leave(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getID() 
	{
		// TODO Auto-generated method stub
		return DiceGame.GAME_37;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int numClicked) 
	{}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) 
	{}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) 
	{}

	@Override
	public void mousePressed(int button, int arg1, int arg2) 
	{}

	@Override
	public void mouseReleased(int button, int arg1, int arg2) 
	{}

	@Override
	public void mouseWheelMoved(int arg0) 
	{}

	@Override
	public void inputEnded() 
	{}

	@Override
	public void inputStarted() 
	{}

	@Override
	public boolean isAcceptingInput() 
	{
		return false;
	}

	@Override
	public void setInput(Input arg0) 
	{}

	@Override
	public void keyPressed(int arg0, char arg1) 
	{}

	@Override
	public void keyReleased(int arg0, char arg1) 
	{}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) 
	{}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) 
	{}

	@Override
	public void controllerDownPressed(int arg0) 
	{}

	@Override
	public void controllerDownReleased(int arg0) 
	{}

	@Override
	public void controllerLeftPressed(int arg0) 
	{}

	@Override
	public void controllerLeftReleased(int arg0) 
	{}

	@Override
	public void controllerRightPressed(int arg0) 
	{}

	@Override
	public void controllerRightReleased(int arg0) 
	{}

	@Override
	public void controllerUpPressed(int arg0) 
	{}

	@Override
	public void controllerUpReleased(int arg0) 
	{}
}
