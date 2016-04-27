package dice.game.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import dice.game.myCode.QueueAnalyzer.Hands;

public class Game59State extends ParentGameState
{
	// first turn
	private boolean firstTurn;
	private LargeQueue largeQueue;
	private Player player1;
	private Player player2; 
	private Player player3;
	private Player player4;
	private DiceHandler mainDiceHandler;
	
	private CenteredTextButton endTurnButton;
	private CenteredTextButton rollButton;
	
	private CenteredTextBox QPromptBox;
		
	private CenteredTextButton mainDieSelectedConfirmButton;
	
	private CenteredTextButton redeemButton;
	
	private PokerBox pokerBox;
	
	private CenteredTextButton rulesButton;
	private CenteredTextButton exitButton;
	
	private CenteredTextBox finishedRedeemBox;
	
	// says who won the game
	private CenteredTextBox whoWonTheGameBox;
	
	// variant rules objects
	private CenteredTextBox sumDifferenceBox; 
	
	private int playerNumberTurn;
	
	private boolean hasRolled;
	private boolean hasRedeemed;
	private boolean hasConfirmedRoll;
	private boolean hasConfirmedRedeem;
	
	private boolean endCurrentTurn;
	private int whoWonTheGame;
	
	private QueueAnalyzer queueAnalyzer;
	
	private Hands currentHand;
	
	private DiceHandler runDiceHandler;
	private CenteredTextButton runDieSelectedConfirmButton;
	private SelectionList threeOfAKindList;
	private SelectionListGroup fourOfAKindGroup;
	private SelectionList confirmCancelList;
	
	private boolean isConfirmingRun;
	private int runNum;
	private int numRunRollsLeft;
	
	private int playerSumDifference;
	
	public Game59State(int sID)
	{
		super(sID);
	}
	
	public void confirmMainDieSelected(int dieSelected, int unSelected)
	{
		getCurrentPlayerObject().addMainDieValue(dieSelected, unSelected);
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
		isConfirmingRun = false;
		endCurrentTurn = false;
		// reset enums

		currentHand = Hands.NONE;
	
		// reset objects
		mainDiceHandler.resetDice();
		runDiceHandler.resetDice();
		largeQueue.resetSelections();
		// set largeQueue values
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
		confirmCancelList.resetSelection();
		threeOfAKindList.resetSelection();
		QPromptBox.SetText("None");
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
		
		if(winnerIs == 0)
		{
			if(DiceGame.sumRule)
			{
				winnerIs = variantCheckForWin();
			}
		}
		if(winnerIs != 0)
		{
			exitButton.SetSelected(true); // for end screen graphics
		}
		return winnerIs;
	}
	
	public int variantCheckForWin()
	{
		int result = 0;
		int sum = player1.getScore() + player2.getScore() + player3.getScore() + player4.getScore();
		if(sum == DiceGame.SUM_NUM_TO_WIN)
		{
			result = playerNumberTurn;
		}
		playerSumDifference = sum - DiceGame.SUM_NUM_TO_WIN; // calculate so textbox render correctly
		return result;
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
	
	public void resetRedemption()
	{
		// if cancel is hit, deselect things
		confirmCancelList.resetSelection();
		threeOfAKindList.resetSelection();
		fourOfAKindGroup.resetSelection();
	}
	
	// Update
	public void updateNoRollNoRedeem(int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			mainDiceHandler.rollDice();
			hasRolled = true;
		}
		
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}

		if(currentHand != Hands.NONE)
		{
			if(redeemButton.isWithinBound(clickPositionX, clickPositionY))
			{
				hasRedeemed = true;
			}
		}
	}
	
	public void updateNoConfirmRollNoRedeem(int clickPositionX, int clickPositionY)
	{
		mainDiceHandler.isWithinBound(clickPositionX, clickPositionY);
		
		if(mainDiceHandler.getSelected() != 0)
		{
			if(mainDieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				if(mainDiceHandler.getSelected() == 1)
				{
					confirmMainDieSelected(mainDiceHandler.getDie1(), mainDiceHandler.getDie2());
				}
				else // diceHandler.getSelected() == 2
				{
					confirmMainDieSelected(mainDiceHandler.getDie2(), mainDiceHandler.getDie1());
				}
				hasConfirmedRoll = true;
				setCurrentHand(); // with new value things in queue move so need to reset current hand
			}
		}

		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
	}
	
	public void updateNoRedeem(int clickPositionX, int clickPositionY)
	{
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
		
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
	}
	
	public void updateNoConfirmRedeem (int clickPositionX, int clickPositionY)
	{

		int confirmCancelDecision = -1; // 1 means confirm was hit, 2 means cancel was hit

		if(currentHand == Hands.THREE_OF_KIND)
		{
			confirmCancelDecision = updateConfirmThreeOfAKind (clickPositionX, clickPositionY);	
		}
		else if (currentHand == Hands.FOUR_OF_KIND)
		{
			confirmCancelDecision = updateConfirmFourOfAKind (clickPositionX, clickPositionY);
		}
		else // all other hand types
		{
			confirmCancelDecision = updateConfirmSimpleHands (clickPositionX, clickPositionY);
		}
		
		if(confirmCancelDecision == 0)
		{ 
			hasConfirmedRedeem = true;
			getCurrentPlayerObject().deleteRedeemedValuesFromQueue(largeQueue.getSelectedIndexes());
			finishedRedeemBox.SetText("Redeemed " + currentHand.toString());
			if(currentHand == Hands.RUN_OF_THREE)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 3;
				numRunRollsLeft = 3;
			}
			else if (currentHand == Hands.RUN_OF_FOUR)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 4;
				numRunRollsLeft = 4;			
			}
			else if (currentHand == Hands.RUN_OF_FIVE)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 5;
				numRunRollsLeft = 5;
			}
			else if (currentHand == Hands.FIVE_OF_KIND)
			{
				getCurrentPlayerObject().setScore(59);
			}
		}
		else if (confirmCancelDecision == 1)
		{
			hasRedeemed = false;
			resetRedemption();
		}
				
	}
	
	public void updateAllConfirmed(int clickPositionX, int clickPositionY)
	{
		if(endTurnButton.isWithinBound(clickPositionX, clickPositionY))
		{
			endCurrentTurn = true;
		}		
	}
	
	public void updateNoRollNoConfirmRedeem(int clickPositionX, int clickPositionY)
	{
		
		int confirmCancelDecision = -1; // 0 means confirm was hit, 1 means cancel was hit
		
		if(currentHand == Hands.THREE_OF_KIND)
		{
			confirmCancelDecision = updateConfirmThreeOfAKind (clickPositionX, clickPositionY);	
		}
		else if (currentHand == Hands.FOUR_OF_KIND)
		{
			confirmCancelDecision = updateConfirmFourOfAKind (clickPositionX, clickPositionY);
		}
		else // all other hand types
		{
			confirmCancelDecision = updateConfirmSimpleHands (clickPositionX, clickPositionY);
		}
		
		if(confirmCancelDecision == 0)
		{ 
			hasConfirmedRedeem = true;
			getCurrentPlayerObject().deleteRedeemedValuesFromQueue(largeQueue.getSelectedIndexes());
			finishedRedeemBox.SetText("Redeemed " + currentHand.toString());
			// runs actions for 3OfAKind and 4OfAKind confirming in their update methods 
			if(currentHand == Hands.RUN_OF_THREE)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 3;
				numRunRollsLeft = 3;
			}
			else if (currentHand == Hands.RUN_OF_FOUR)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 4;
				numRunRollsLeft = 4;			
			}
			else if (currentHand == Hands.RUN_OF_FIVE)
			{
				isConfirmingRun = true;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runNum = 5;
				numRunRollsLeft = 5;
			}
			else if (currentHand == Hands.FIVE_OF_KIND)
			{
				getCurrentPlayerObject().setScore(59);
			}
		}
		else if (confirmCancelDecision == 1)
		{
			hasRedeemed = false;
			resetRedemption();
		}
	}
	
	public void updateNoRoll(int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			mainDiceHandler.rollDice();
			hasRolled = true;
		}		
	}
	
	public void updateNoConfirmRoll (int clickPositionX, int clickPositionY)
	{
		mainDiceHandler.isWithinBound(clickPositionX, clickPositionY);
		if(mainDiceHandler.getSelected() != 0)
		{
			if(mainDieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				if(mainDiceHandler.getSelected() == 1)
				{
					confirmMainDieSelected(mainDiceHandler.getDie1(), mainDiceHandler.getDie2());
				}
				else // diceHandler.getSelected() == 2
				{
					confirmMainDieSelected(mainDiceHandler.getDie2(), mainDiceHandler.getDie1());
				}
				hasConfirmedRoll = true;
				setCurrentHand();
			}
		}
	}
	
	// SpecialHandsUpdateMethods
	
	public int updateConfirmSimpleHands (int clickPositionX, int clickPositionY)
	{
		int result = -1;
		
		if(confirmCancelList.isWithinBound(clickPositionX, clickPositionY))
		{
			confirmCancelList.pressListButton(clickPositionX, clickPositionY);
			result = confirmCancelList.getSelectedIndex();
		}
		
		return result;
	}
	
	public int updateConfirmThreeOfAKind (int clickPositionX, int clickPositionY)
	{
		int result = -1;
		
		if(threeOfAKindList.isWithinBound(clickPositionX, clickPositionY))
		{
			threeOfAKindList.pressListButton(clickPositionX, clickPositionY);
		}
		if(threeOfAKindList.getSelectedIndex() != -1)
		{
			if(confirmCancelList.isWithinBound(clickPositionX, clickPositionY))
			{
				confirmCancelList.pressListButton(clickPositionX, clickPositionY);
				result = confirmCancelList.getSelectedIndex();
			}			
		}
		
		if(result == 0) //confirm was pressed
		{
			threeOfAKindAction(threeOfAKindList.getSelectedIndex());
		}
		
		return result;
	}
	
	
	public int updateConfirmFourOfAKind (int clickPositionX, int clickPositionY)
	{	
		int result = -1;
		
		if(fourOfAKindGroup.isWithinBound(clickPositionX, clickPositionY))
		{
			fourOfAKindGroup.pressListButton(clickPositionX, clickPositionY);
		}
		// if both selection lists of group have a selection
		if(fourOfAKindGroup.getSelectionListAtIndex(0).getSelectedIndex() != -1 && fourOfAKindGroup.getSelectionListAtIndex(1).getSelectedIndex() != -1)
		{
			if(confirmCancelList.isWithinBound(clickPositionX, clickPositionY))
			{
				confirmCancelList.pressListButton(clickPositionX, clickPositionY);
				result = confirmCancelList.getSelectedIndex();
			}
		}
		
		if(result == 0)
		{
			fourOfAKindAction(fourOfAKindGroup.getSelectionListAtIndex(0).getSelectedIndex(), fourOfAKindGroup.getSelectionListAtIndex(1).getSelectedIndex());
		}
		
		return result;
	}
	

	
	public void threeOfAKindAction(int selectedIndex)
	{
		// selectedIndex is also the number printed on that item of selection list, just lined up properly
		getCurrentPlayerObject().changeScore(selectedIndex, true);
		if(playerNumberTurn != 1)
		{
			player1.changeScore(3-selectedIndex, false);
		}
		if(playerNumberTurn != 2)
		{
			player2.changeScore(3-selectedIndex, false);
		}
		if(playerNumberTurn != 3)
		{
			player3.changeScore(3-selectedIndex, false);
		}
		if(playerNumberTurn != 4)
		{
			player4.changeScore(3-selectedIndex, false);
		}
	}
	
	public void fourOfAKindAction(int firstIndex, int secondIndex)
	{
		// firstIndex is for X, secondIndex is for Y, selectedIndex+1 so it lines up properly
		getCurrentPlayerObject().changeScore(firstIndex*(secondIndex+1), true);
		if(playerNumberTurn != 1)
		{
			player1.changeScore(6-firstIndex*(secondIndex+1), false);
		}
		if(playerNumberTurn != 2)
		{
			player2.changeScore(6-firstIndex*(secondIndex+1), false);
		}
		if(playerNumberTurn != 3)
		{
			player3.changeScore(6-firstIndex*(secondIndex+1), false);
		}
		if(playerNumberTurn != 4)
		{
			player4.changeScore(6-firstIndex*(secondIndex+1), false);
		}
	}	
	
	public void updateIsConfirmingRun (int clickPositionX, int clickPositionY)
	{
		runDiceHandler.isWithinBound(clickPositionX, clickPositionY);
		if(runDiceHandler.getSelected() != 0)
		{
			if(runDieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				if(runDiceHandler.getSelected() == 1)
				{
					confirmRunDieSelected(runDiceHandler.getDie1(), runDiceHandler.getDie2());
				}
				else // runDiceHandler.getSelected() == 2
				{
					confirmRunDieSelected(runDiceHandler.getDie2(), runDiceHandler.getDie1());
				}
				numRunRollsLeft--;
				runDiceHandler.resetDice();
				runDiceHandler.rollDice();
				runDieSelectedConfirmButton.SetSelected(false);
				if(numRunRollsLeft == 0)
				{
					isConfirmingRun = false; // transition out, hasConfirmedRedeem was set true transitioning to this
				}
			}
		}	
	}
	
	
	// maybe other methods to help updateIsConfirmingRun
	public void confirmRunDieSelected(int dieSelected, int unSelected)
	{
		getCurrentPlayerObject().addRunDie(dieSelected);
		
		if(runNum == 4)
		{
			if(playerNumberTurn != 1)
			{
				player1.addRunDie(unSelected);
			}
			if(playerNumberTurn != 2)
			{
				player2.addRunDie(unSelected);
			}
			if(playerNumberTurn != 3)
			{
				player3.addRunDie(unSelected);
			}
			if(playerNumberTurn != 4)
			{
				player4.addRunDie(unSelected);
			}
		}
		else if (runNum == 5)
		{
			if(playerNumberTurn != 1)
			{
				player1.addRunDie(0);
			}
			if(playerNumberTurn != 2)
			{
				player2.addRunDie(0);
			}
			if(playerNumberTurn != 3)
			{
				player3.addRunDie(0);
			}
			if(playerNumberTurn != 4)
			{
				player4.addRunDie(0);
			}
		}
	}
	
	
	// Rendering
	public void renderNoRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		mainDiceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		if(currentHand != Hands.NONE)
		{
			redeemButton.render(gameContainer, stateGame, g);
		}
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoConfirmRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		if(mainDiceHandler.getSelected() != 0)
		{
			mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		largeQueue.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
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
		mainDiceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		
		if(currentHand == Hands.THREE_OF_KIND)
		{
			renderConfirmThreeOfAKind (gameContainer, stateGame, g);	
		}
		else if (currentHand == Hands.FOUR_OF_KIND)
		{
			renderConfirmFourOfAKind (gameContainer, stateGame, g);
		}
		else // all other hand types
		{
			renderConfirmSimpleHands (gameContainer, stateGame, g);
		}
		
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderAllConfirmed(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		endTurnButton.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRollNoConfirmRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		largeQueue.render(gameContainer, stateGame, g);
		
		if(currentHand == Hands.THREE_OF_KIND)
		{
			renderConfirmThreeOfAKind (gameContainer, stateGame, g);	
		}
		else if (currentHand == Hands.FOUR_OF_KIND)
		{
			renderConfirmFourOfAKind (gameContainer, stateGame, g);
		}
		else // all other hand types
		{
			renderConfirmSimpleHands (gameContainer, stateGame, g);
		}
			
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoRoll(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		mainDiceHandler.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	public void renderNoConfirmRoll (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		if(mainDiceHandler.getSelected() != 0)
		{
			mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}

	// SpecialHandsRenderMethods
	
	public void renderConfirmSimpleHands (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		confirmCancelList.render(gameContainer, stateGame, g);
	}

	public void renderConfirmThreeOfAKind (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		threeOfAKindList.render(gameContainer, stateGame, g);
		if(threeOfAKindList.getSelectedIndex() != -1)
		{
			confirmCancelList.render(gameContainer, stateGame, g);
		}
	}
	
	public void renderConfirmFourOfAKind (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		fourOfAKindGroup.render(gameContainer, stateGame, g);
		if(fourOfAKindGroup.getSelectionListAtIndex(0).getSelectedIndex() != -1 && fourOfAKindGroup.getSelectionListAtIndex(1).getSelectedIndex() != -1)		
		{
			confirmCancelList.render(gameContainer, stateGame, g);
		}
	}
	
	public void renderIsConfirmingRun (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		runDiceHandler.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
		if(runDiceHandler.getSelected() != 0)
		{
			runDieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		
	}
		
	// always render method
	public void alwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		// diceHandler.render(gameContainer, stateGame, g);
		player1.render(gameContainer, stateGame, g);
		player2.render(gameContainer, stateGame, g);
		player3.render(gameContainer, stateGame, g);
		player4.render(gameContainer, stateGame, g);
		pokerBox.render(gameContainer, stateGame, g);
		rulesButton.render(gameContainer, stateGame, g);
		exitButton.render(gameContainer, stateGame, g);
		variantAlwaysRender(gameContainer, stateGame, g);
	}
	
	public void variantAlwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		if(DiceGame.sumRule)
		{	
			sumDifferenceBox.SetText("" + playerSumDifference);
			sumDifferenceBox.render(gameContainer, stateGame, g);
		}

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
			if(whoWonTheGame != 0)
			{
				// don't allow anything except hitting exit or rules
			}
			else if(isConfirmingRun)
			{
				updateIsConfirmingRun(mouseX, mouseY);
			}
			else if(!hasRolled && !hasRedeemed)
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
			else if (hasRolled && !hasConfirmedRoll && hasConfirmedRedeem)
			{
				updateNoConfirmRoll(mouseX, mouseY);
			}
			if(endCurrentTurn == true)
			{
				// logic for pair
				if(currentHand == Hands.PAIR && hasConfirmedRedeem == true)
				{
					newTurn();
				}
				newTurn();
			}
		}
	}
	
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.white); // move to enter??
		alwaysRender(gameContainer, stateGame, g);

		if(whoWonTheGame != 0)
		{
			whoWonTheGameBox.SetText("Player " + whoWonTheGame + " Wins!");
			whoWonTheGameBox.render(gameContainer, stateGame, g);
			exitButton.render(gameContainer, stateGame, g);
		}	
		else if(isConfirmingRun)
		{
			renderIsConfirmingRun(gameContainer, stateGame, g);
		}
		else if(!hasRolled && !hasRedeemed)
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
		else if (hasRolled && !hasConfirmedRoll && hasConfirmedRedeem)
		{
			renderNoConfirmRoll(gameContainer, stateGame, g);
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
		mainDiceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont, true);
		endTurnButton = new CenteredTextButton("End Turn", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		rollButton = new CenteredTextButton("Roll", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		QPromptBox = new CenteredTextBox("None", Place.GS_QPROMPTBOX_XPOS, Place.GS_QPROMPTBOX_YPOS, Place.GS_QPROMPTBOX_WIDTH, Place.GS_QPROMPTBOX_HEIGHT, DiceGame.smallFont);
		rulesButton = new CenteredTextButton("View Rules", Place.GS_RULESBUTTON_XPOS, Place.GS_RULESBUTTON_YPOS, Place.GS_RULESBUTTON_WIDTH, Place.GS_RULESBUTTON_HEIGHT, DiceGame.smallFont);
		exitButton = new CenteredTextButton("Return to Main", Place.GS_EXITBUTTON_XPOS, Place.GS_EXITBUTTON_YPOS, Place.GS_EXITBUTTON_WIDTH, Place.GS_EXITBUTTON_HEIGHT, DiceGame.smallFont);
		finishedRedeemBox = new CenteredTextBox("Redeemed", Place.GS_FINISHEDREDEEMBOX_XPOS, Place.GS_FINISHEDREDEEMBOX_YPOS, Place.GS_FINISHEDREDEEMBOX_WIDTH, Place.GS_FINISHEDREDEEMBOX_HEIGHT, DiceGame.smallFont); 
		pokerBox = new PokerBox(DiceGame.smallFont);
		
		mainDieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);		
		redeemButton = new CenteredTextButton("Redeem Hand", Place.GS_REDEEMBUTTON_XPOS, Place.GS_REDEEMBUTTON_YPOS, Place.GS_REDEEMBUTTON_WIDTH, Place.GS_REDEEMBUTTON_HEIGHT, DiceGame.smallFont);
		
		// whoWonTheGameBox
		whoWonTheGameBox = new CenteredTextBox("", Place.GS_WHOWONTHEGAMEBOX_XPOS, Place.GS_WHOWONTHEGAMEBOX_YPOS, Place.GS_WHOWONTHEGAMEBOX_WIDTH, Place.GS_WHOWONTHEGAMEBOX_HEIGHT, DiceGame.largeFont);
		// set Selected to true so it shows up black and goes over rest
		whoWonTheGameBox.SetSelected(true);
		
		// new objects
		runDiceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont, false);
		runDieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", Place.GS_RUNDIECONFIRMBUTTON_XPOS, Place.GS_RUNDIECONFIRMBUTTON_YPOS, Place.GS_RUNDIECONFIRMBUTTON_WIDTH, Place.GS_RUNDIECONFIRMBUTTON_HEIGHT, DiceGame.smallFont);
		threeOfAKindList = new SelectionList(new String[]{"0", "1", "2", "3"}, Place.GS_THREEOFKINDLIST_XPOS, Place.GS_THREEOFKINDLIST_YPOS, Place.GS_THREEOFKINDLIST_WIDTH, Place.GS_THREEOFKINDLIST_HEIGHT);
		fourOfAKindGroup = new SelectionListGroup(new String [][] {new String[]{"0", "1", "2", "3"},new String[]{"1", "2"}}, Place.GS_FOUROFKINDGROUP_XPOS, Place.GS_FOUROFKINDGROUP_YPOS, Place.GS_FOUROFKINDGROUP_WIDTH, Place.GS_FOUROFKINDGROUP_ELEMENTHEIGHT, Place.GS_FOUROFKINDGROUP_ELEMENTSPACING);
		confirmCancelList = new SelectionList(new String[]{"Confirm", "Cancel"}, Place.GS_CONFIRMCANCELLIST_XPOS, Place.GS_CONFIRMCANCELLIST_YPOS, Place.GS_CONFIRMCANCELLIST_WIDTH, Place.GS_CONFIRMCANCELLIST_HEIGHT);				

		// variant rules
		sumDifferenceBox = new CenteredTextBox("-" + DiceGame.SUM_NUM_TO_WIN, Place.GS_SUMDIFFERENCE_XPOS, Place.GS_SUMDIFFERENCE_YPOS, Place.GS_SUMDIFFERENCE_WIDTH, Place.GS_SUMDIFFERENCE_HEIGHT, DiceGame.smallFont);
		
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		isConfirmingRun = false;
		
		runNum = 0;
		numRunRollsLeft = 0;
		playerSumDifference = 0;
		
		playerNumberTurn = 0;
		endCurrentTurn = false;
		firstTurn = true;
		whoWonTheGame = 0;
		
		currentHand = Hands.NONE;
		
		newTurn();
	}
}

