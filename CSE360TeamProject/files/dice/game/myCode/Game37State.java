package dice.game.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import dice.game.myCode.QueueAnalyzer.Hands;

public class Game37State extends ParentGameState
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
	
	private CenteredTextBox QPromptBox;
	
	private CenteredTextButton redeemQueueButton;
	// private groupOfSelectionLists handGroup;
	private SelectionList confirmCancelList;
		
	private CenteredTextButton dieSelectedConfirmButton;
	
	private CenteredTextButton redeemButton;
	
	// private MyPokerBox pokerBox;
	
	private CenteredTextButton rulesButton;
	private CenteredTextButton exitButton;
	
	private CenteredTextBox finishedRedeemBox;
	
	// temporary to see if there can be a winner
	private CenteredTextBox whoWonTheGameBox;
	
	private int playerNumberTurn;
	
	private boolean hasRolled;
	private boolean hasRedeemed;
	private boolean hasConfirmedRoll;
	private boolean hasConfirmedRedeem;
	
	private boolean endCurrentTurn;
	private int whoWonTheGame;
	
	private QueueAnalyzer queueAnalyzer;
	
	private Hands currentHand;
	
	public Game37State(int sID)
	{
		super(sID);
	}
	
	public void confirmDieSelected(int dieSelected, int unSelected)
	{
		getCurrentPlayerObject().addDieValue(dieSelected, unSelected);
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
	}
	
	// when I click on the largeQueue I need to setCurrentHand, and update QPromptBox 
	public void setCurrentHand()
	{
		queueAnalyzer = new QueueAnalyzer (largeQueue.getSelectedValues());
		currentHand = queueAnalyzer.handFinder();
		QPromptBox.SetText(currentHand.toString());
	}
	
	public void newTurn()
	{
		// firstTurn logic
		if(firstTurn)
		{
			
		}
		else
		{
			getCurrentPlayerObject().InvertAllBoxes();
		}
		// update playerNumberTurn
		if((playerNumberTurn) < 4)
		{
			playerNumberTurn++;
		}
		else
		{
			playerNumberTurn = 1;
		}
		// show selected player
		getCurrentPlayerObject().InvertAllBoxes();
		
		
		// Reset Booleans
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		endCurrentTurn = false;
		// reset enums
		currentHand = Hands.NONE;
		
		// reset objects
		diceHandler.resetDice();
		largeQueue.resetSelections();
		// set largeQueue values
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
		
		// first turn logic
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

	public int checkForWin()
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
		return winnerIs;
	}
	
	public void updateAlwaysNoClicking()
	{
		whoWonTheGame = checkForWin();
	}
	
	public void updateAlwaysClicking(StateBasedGame stateGame, int clickPositionX, int clickPositionY)
	{
		if(exitButton.isWithinBound(clickPositionX, clickPositionY))
		{
			stateGame.enterState(DiceGame.MAIN);			
		}
		
		
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
		
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
		// if(selectedLargeQueuvalues form a hand)
		// { 
		// 		isWithinBound redeemButton
		// }
		
		if(currentHand != Hands.NONE)
		{
			if(redeemButton.isWithinBound(clickPositionX, clickPositionY))
			{
				hasRedeemed = true;
			}
		}
		
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
				}
				else // diceHandler.getSelected() == 2
				{
					confirmDieSelected(diceHandler.getDie2(), diceHandler.getDie1());
				}
				hasConfirmedRoll = true;
			}
		}
		// if(dieselected != 0)
		// {
		// 		isWithinBound confirmDieSelectedButton
		// 		selected == 1
		// 		selected == 2
		// }
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
		
		// transitions
		// if(isWithinBound confirmDieSelectedButton)
		// {
		// 		hasConfirmedRoll = true;	
		// }
	}
	
	public void updateNoRedeem(int clickPositionX, int clickPositionY)
	{
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
		// if(selectedLargeQueue values form a hand)
		// {
		// 		isWithinBound redeemButton
		// }
		
		if(currentHand != Hands.NONE)
		{
			if(redeemButton.isWithinBound(clickPositionX, clickPositionY))
			{
				hasRedeemed = true;
			}
		}
		
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
		// isWithinBound handGroup
		// if (all selectionLists of HandGroup have a selection)
		// {
		// 		isWithinBound confirmCancelHandList	
		// }
		
		// transitions
		// if(isWithinBound confirmCancelHandList Selected is Confirm)
		// 		hasConfirmedRedeem = true;
		// if(isWithinBound confirmCancelHandList Selected is Cancel)
		// 		hasRedeemed = false; 		
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
		// isWithinBound handGroup
		// if(all handGroup lists have a selection)
		// {
		// 		isWithinBound confirmCancelHandList 		
		// }
		// if(isWithinBound confirmCancelHandList selects confirm
		// 		hasConfirmedRedeem = true;
		// if(isWithinBound confirmCancelHandList selects cancel
		// 		hasRedeemed = false;
	}
	
	public void updateNoRoll(int clickPositionX, int clickPositionY)
	{
		rollButton.isWithinBound(clickPositionX, clickPositionY);
		// transitions
		// if(isWithinBound rollButton)
		// 		hasRolled = true;
	}
	
	public void updateNoConfirmRoll (int clickPositionX, int clickPositionY)
	{
		diceHandler.isWithinBound(clickPositionX, clickPositionY);
		if(diceHandler.getSelected() != 0)
		{
			if(dieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				if(diceHandler.getSelected() == 1)
				{
					confirmDieSelected(diceHandler.getDie1(), diceHandler.getDie2());
				}
				else // diceHandler.getSelected() == 2
				{
					confirmDieSelected(diceHandler.getDie2(), diceHandler.getDie1());
				}
				hasConfirmedRoll = true;
			}
		}
		// if(dieSelected != 0)
		// {
		// 		confirmDieSelectedButton.isWithinBound(clickpositionX, clickPositionY);
		// }
		// transitions
		// if(isWithinBound confirmDieSelectedButton)
		// 		hasConfirmedRoll = true;
	}
	
	// Rendering
	public void renderNoRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		diceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		if(currentHand != Hands.NONE)
		{
			redeemButton.render(gameContainer, stateGame, g);
		}
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
		if(currentHand != Hands.NONE)
		{
			redeemButton.render(gameContainer, stateGame, g);
		}
		endTurnButton.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);	
	}
	
	public void renderNoConfirmRedeem (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		// render handGroup
		// if (all selectionLists of handGroup have a selection)
		// {
		// 		render confirmCancelHandList
		// }
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderAllConfirmed(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		endTurnButton.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRollNoConfirmRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		// render handGroup
		// if(all HandGroup lists have a selection)
		// {
		// 		render confirmCancelHandList
		// }
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRoll(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		diceHandler.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoConfirmRoll (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		diceHandler.render(gameContainer, stateGame, g);
		if(diceHandler.getSelected() != 0)
		{
			dieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		finishedRedeemBox.render(gameContainer, stateGame, g);
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
		updateAlwaysNoClicking();
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			updateAlwaysClicking(stateGame, mouseX, mouseY);
			
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
		// works but looks bad and probably want other behavior
		if(whoWonTheGame != 0)
		{
			whoWonTheGameBox.SetText("Player " + whoWonTheGame + "Won!");
			whoWonTheGameBox.render(gameContainer, stateGame, g);
			
		}				
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		super.enter(gameContainer, stateGame);
		
		largeQueue = new LargeQueue(DiceGame.mediumFont);
		player1 = new Player("Player 1", 1, DiceGame.smallFont);
		player2 = new Player("Player 2", 2, DiceGame.smallFont);
		player3 = new Player("Player 3", 3, DiceGame.smallFont);
		player4 = new Player("Player 4", 4, DiceGame.smallFont);
		diceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont);
		endTurnButton = new CenteredTextButton("End Turn", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		rollButton = new CenteredTextButton("Roll", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		QPromptBox = new CenteredTextBox("None", Place.GS_QPROMPTBOX_XPOS, Place.GS_QPROMPTBOX_YPOS, Place.GS_QPROMPTBOX_WIDTH, Place.GS_QPROMPTBOX_HEIGHT, DiceGame.smallFont);
		rulesButton = new CenteredTextButton("View Rules", Place.GS_RULESBUTTON_XPOS, Place.GS_RULESBUTTON_YPOS, Place.GS_RULESBUTTON_WIDTH, Place.GS_RULESBUTTON_HEIGHT, DiceGame.smallFont);
		exitButton = new CenteredTextButton("Return to Main", Place.GS_EXITBUTTON_XPOS, Place.GS_EXITBUTTON_YPOS, Place.GS_EXITBUTTON_WIDTH, Place.GS_EXITBUTTON_HEIGHT, DiceGame.smallFont);
		finishedRedeemBox = new CenteredTextBox("Redeemed", Place.GS_FINISHEDREDEEMBOX_XPOS, Place.GS_FINISHEDREDEEMBOX_YPOS, Place.GS_FINISHEDREDEEMBOX_WIDTH, Place.GS_FINISHEDREDEEMBOX_HEIGHT, DiceGame.smallFont); 
		
		dieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);		
		redeemButton = new CenteredTextButton("Redeem Hand", Place.GS_REDEEMBUTTON_XPOS, Place.GS_REDEEMBUTTON_YPOS, Place.GS_REDEEMBUTTON_WIDTH, Place.GS_REDEEMBUTTON_HEIGHT, DiceGame.smallFont);
		
		// whoWonTheGameBox
		whoWonTheGameBox = new CenteredTextBox("", Place.GS_WHOWONTHEGAMEBOX_XPOS, Place.GS_WHOWONTHEGAMEBOX_YPOS, Place.GS_WHOWONTHEGAMEBOX_WIDTH, Place.GS_WHOWONTHEGAMEBOX_HEIGHT, DiceGame.mediumFont);
		
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		playerNumberTurn = 0;
		endCurrentTurn = false;
		firstTurn = true;
		whoWonTheGame = 0;
		
		currentHand = Hands.NONE;
		
		newTurn();
	}
}
