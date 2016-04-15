package dice.game.myCode;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class My37TestState implements GameState
{
	private MyLargeQueue largeQueue;
	private MyPlayer player1;
	private MyPlayer player2; 
	private MyPlayer player3;
	private MyPlayer player4;
	private MyDiceHandler diceHandler;
	
	private MyCenteredTextButton endTurnButton;
	private MyCenteredTextButton rollButton;
	private int endTurnRoll_XPos = 412; 
	private int endTurnRoll_YPos = 32;
	private int endTurnRoll_Width = 96;
	private int endTurnRoll_Height = 32;
	
	private MyCenteredTextBox QPromptBox;
	private int QPromptBox_XPos = 232;
	private int QPromptBox_YPos = 160;
	private int QPromptBox_Width = 176;
	private int QPromptBox_Height = 32;
	
	private MyCenteredTextButton redeemQueueButton;
	// private groupOfSelectionLists handGroup;
	private MySelectionList confirmCancelList;
	
	
	// private MyPokerBox pokerBox;
	private int rulesButton_XPos = 464;
	private int rulesButton_YPos = 392;
	private int rulesButton_Width = 160;
	private int rulesButton_Height = 32;
	
	private int exitButton_XPos = 464;
	private int exitButton_YPos = 432;
	private int exitButton_Width = 160;
	private int exitButton_Height = 32;

	private MyCenteredTextButton rulesButton;
	private MyCenteredTextButton exitButton;
	
	private MyCenteredTextBox finishedRedeemBox;
	private int finishedRedeemBox_XPos = 248;
	private int finishedRedeemBox_YPos = 96;
	private int finishedRedeemBox_Width = 144;
	private int finishedRedeemBox_Height = 32;
	
	
	private boolean hasRolled;
	private boolean hasRedeemed;
	private boolean hasFinishedRedeeming;
	
	public My37TestState(int main)
	{}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{}
		
	// methods for different turn "states"
	// Update
 	public void redeemingUpdate (int clickPositionX, int clickPositionY) 
	{
 		// hasRedeemed && !hasFinishedRedeeming, roll state doesn't matter
 		// handGroup.isWithinBound();
 		// if(all grounds have something selected)
 		// {
 		//		confirmCancel.isWithinBound(clickPositionX, clickPositionY);	
 		// }
 		// actions
 		// on confirm special actions based on choices
 		// transitions
 		// if (confirm)
 		// 		hasFinishedRedeeming = true;
 		// if (cancel)
 		// 		hasRedeemed = false;
	}
 	
	public void noRedeemUpdate(int clickPositionX, int clickPositionY)
	{
		diceHandler.isWithinBound(clickPositionX, clickPositionY);
		// if(diceHandler selected != 0)
		// {
		// 		endTurnButton.isWithinBound(clickPositionX, clickPositionY);
		// 		if(queueAnalyzerBox isn't none)
		// 		{
		// 			redeemButton.isWithinBound(clickPositionX, clickPositionY);
		// 		}
		// }
		largeQueue.isWithinBound(clickPositionX, clickPositionY);
		
		// actions
		// select LargeQueueValues to be redeemed
		// select DieValue to add to score and to add to queue
		
		// transitions
		// if(endTurnButtonSelected)
		// 		endTurn
		// if(redeem)
		// 		hasRedeemed = true;
	}

	public void noRollUpdate (int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			diceHandler.rolled = true;
			hasRolled = true;
		}
		// no actions except transition 
		
		// transitions
		// if(roll)
		// 		hasRolled = true;
	}
	
	public void neitherUpdate(int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			diceHandler.rollDice();
			hasRolled = true;
		}
		largeQueue.isWithinBound(clickPositionX, clickPositionY);
		//redeemButton.isWithinBound(clickPositionX, clickPositionY);
		
		// actions
		// select largeQueue values to redeem
		
		// transitions
		// if(roll)
		// 		hasRolled = true;
		// if(redeem)
		// 		hasRedeemed = true;
	}
	
	public void bothUpdate (int clickPositionX, int clickPositionY) 
	{
		// diceHandler.isWithinBound(clickPositionX, clickPositionY);
		// if(diceHandler selected != 0)
		// {
		//  	endTurnButton.isWithinBound(clickPositionX, clickPositionY); 		
		// }
		
		// actions
		// select die values, end turn
		
		// transitions
		// if(endTurn)
		// 		endTurn;
	}
	
	// Rendering
 	public void redeemingRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g) 
	{
 		largeQueue.render(gameContainer, stateGame, g);
 		QPromptBox.render(gameContainer, stateGame, g);
 		// handGroup.render();
 		// if(all groups have something selected)
 		// {
 		// 		confirmCancel.render();
 		// }
	}
 	
	public void noRedeemRender(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		// if DiceHandler selected != 0
		// {
		// 		endTurn.render();
		//      if(queueAnalyzerBox isn't none)
		// 		{
		// 			redeemButton.render();
		// 		}
		// }
		largeQueue.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
	}

	public void noRollRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}	
	
	public void neitherRender(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
		// if(queueAnalyzerBox isn't none)
		// {
		// 		redeemButton.render(gameContainer, stateGame, g);
		// }
	}
	
	public void bothRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g) 
	{
		// if(diceHandlerSelected != 0)
		// {
		// 		endTurn.render(gameContainer, stateGame, g);
		// }
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	// always render method
	public void alwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
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
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			if(hasRedeemed && !hasFinishedRedeeming)
			{
				redeemingUpdate(mouseX, mouseY);
			}
			else if (hasRolled && !hasRedeemed)
			{
				noRedeemUpdate(mouseX, mouseY);
			}
			else if (!hasRolled && hasRedeemed)
			{
				noRollUpdate(mouseX, mouseY);
			}
			else if (!hasRolled && !hasRedeemed)
			{
				neitherUpdate(mouseX, mouseY);
			}
			else // hasRolled && hasRedeemed
			{
				bothUpdate(mouseX, mouseY);
			}
			
			/*
			largeQueue.isWithinBound(mouseX, mouseY);
			diceHandler.isWithinBound(mouseX, mouseY);
			*/
			// don't render endTurn button yet
			
			// ask the game name box if its been clicked
			// This re-enters the state we are already in, edit out later
			/*if(gameStartButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(MyDiceGame.GAME_37);
			}*/
		}
	}
	
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.white); // move to enter??
		alwaysRender(gameContainer, stateGame, g);
		if(hasRedeemed && !hasFinishedRedeeming)
		{
			redeemingRender(gameContainer, stateGame, g);
		}
		else if (hasRolled && !hasRedeemed)
		{
			noRedeemRender(gameContainer, stateGame, g);
		}
		else if (!hasRolled && hasRedeemed)
		{
			noRollRender(gameContainer, stateGame, g);
		}
		else if (!hasRolled && !hasRedeemed)
		{
			neitherRender(gameContainer, stateGame, g);
		}
		else // hasRolled && hasRedeemed
		{
			bothRender(gameContainer, stateGame, g);
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
		MyDiceGame.initializeFonts();
		largeQueue = new MyLargeQueue(MyDiceGame.mediumFont);
		player1 = new MyPlayer("Player 1", 1, MyDiceGame.smallFont);
		player2 = new MyPlayer("Player 2", 2, MyDiceGame.smallFont);
		player3 = new MyPlayer("Player 3", 3, MyDiceGame.smallFont);
		player4 = new MyPlayer("Player 4", 4, MyDiceGame.smallFont);
		diceHandler = new MyDiceHandler(MyDiceGame.largeFont, MyDiceGame.smallFont);
		endTurnButton = new MyCenteredTextButton("End Turn", endTurnRoll_XPos, endTurnRoll_YPos, endTurnRoll_Width, endTurnRoll_Height, MyDiceGame.smallFont);
		rollButton = new MyCenteredTextButton("Roll", endTurnRoll_XPos, endTurnRoll_YPos, endTurnRoll_Width, endTurnRoll_Height, MyDiceGame.smallFont);
		QPromptBox = new MyCenteredTextBox("None", QPromptBox_XPos, QPromptBox_YPos, QPromptBox_Width, QPromptBox_Height, MyDiceGame.smallFont);
		rulesButton = new MyCenteredTextButton("View Rules", rulesButton_XPos, rulesButton_YPos, rulesButton_Width, rulesButton_Height, MyDiceGame.smallFont);
		exitButton = new MyCenteredTextButton("Return to Main", exitButton_XPos, exitButton_YPos, exitButton_Width, exitButton_Height, MyDiceGame.smallFont);
		finishedRedeemBox = new MyCenteredTextBox("Redeemed", finishedRedeemBox_XPos, finishedRedeemBox_YPos, finishedRedeemBox_Width, finishedRedeemBox_Height, MyDiceGame.smallFont); 
		
		hasRolled = false;
		hasRedeemed = false;
		hasFinishedRedeeming = false;
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
		return MyDiceGame.GAME_37;
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
