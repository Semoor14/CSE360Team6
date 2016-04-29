package dice.game.myCode;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;

import dice.game.myCode.QueueAnalyzer.Hands;

/**
 * This class is the state that has the actual gameplay. Handles UI logic and Game Logic through the render 
 * and update methods. UI logic is deciding what to draw to the screen and what can be clicked. Game Logic is deciding
 * what to do after a click has occurred. 
 * @author Nicholas Stanton
 */
public class Game59State extends ParentGameState
{
	// Variables
	/**
	 * The number of the player's who turn it is. 
	 */
	private int playerNumberTurn;
	/**
	 * A random number generator for determining whose turn it is. 
	 */
	private Random rand = new Random();
	/**
	 * The number of the player who won the game. 
	 */
	private int whoWonTheGame;
	/**
	 * The number of the difference between the sum of all player's scores and the value for to win the variant sum rule. 
	 */
	private int playerSumDifference;
	/**
	 * A boolean if the player has rolled during their turn. 
	 */
	private boolean hasRolled;
	/**
	 * A boolean if the player has redeemed their queue during their turn. 
	 */
	private boolean hasRedeemed;
	/**
	 * A boolean if the player has confirmed the dice of their roll during their turn. 
	 */
	private boolean hasConfirmedRoll;
	/**
	 * A boolean if the player has confirmed redeeming a special hand during their turn. 
	 */
	private boolean hasConfirmedRedeem;
	/**
	 * A boolean if the player has clicked the end turn button during their turn. 
	 */
	private boolean endCurrentTurn;
	/**
	 * A boolean if the player is in the process of confirming redeeming a run during their turn. 
	 */
	private boolean isConfirmingRun;
	/**
	 * The hand which the player redeemed for their turn.
	 */
	private Hands confirmedHandForThisTurn;
	/**
	 * The hand which is currently represented by the selected large queue values. 
	 */
	private Hands currentHand;
	/**
	 * A integer for the number of elements in the run being redeemed this turn. 
	 */
	private int runNum;
	/**
	 * The number of rolls left for redeeming a run this turn. 
	 */
	private int numRunRollsLeft;
	/** 
	 * The number of dice rolls that have occured this game. 
	 */
	public static int diceRolls;

	// Objects
	/**
	 * The object for player 1 in this game. 
	 */
	private Player player1;
	/** 
	 * The object for player 2 in this game. 
	 */
	private Player player2;
	/** 
	 * The object for player 3 in this game. 
	 */
	private Player player3;
	/**
	 * The object for player 4 in this game. 
	 */
	private Player player4;	
	/** 
	 * The object for the dice rolled during regular gameplay. 
	 */
	private DiceHandler mainDiceHandler;
	/** 
	 * The button for ending the current player's turn. 
	 */
	private CenteredTextButton endTurnButton;
	/** 
	 * The button for rolling the dice. 
	 */
	private CenteredTextButton rollButton;
	/** 
	 * The button for confirming which die goes to score and which die goes to queue.
	 */
	private CenteredTextButton mainDieSelectedConfirmButton;
	/** 
	 * The object representing the player's queue whose turn it is, allows player to select queue values to be 
	 * redeemed as a hand.
	 */
	private LargeQueue largeQueue;
	/** 
	 * The box showing what hand the selections of the large queue form.
	 */
	private CenteredTextBox QPromptBox;
	/** 
	 * The box showing what hand the player redeemed during their turn.
	 */
	private CenteredTextBox finishedRedeemBox;
	/** 
	 * The button for a player to begin redeeming a hand selected from the large queue. 
	 */
	private CenteredTextButton redeemButton;
	/** 
	 * The object that takes the large queue's selections and determines what hand it forms. 
	 */
	private QueueAnalyzer queueAnalyzer;
	/** 
	 * The object for the dice used while redeeming a run. 
	 */
	private DiceHandler runDiceHandler;
	/** 
	 * The button to confirm which die goes to the player's queue while redeeming a run.
	 */
	private CenteredTextButton runDieSelectedConfirmButton;
	/** 
	 * The object for letting players choose X for redeeming a three of a kind. 
	 */
	private SelectionList threeOfAKindList;
	/**
	 * The object for letting player choose X and Y for redeeming a four of a kind. 
	 */
	private SelectionListGroup fourOfAKindGroup;
	/**
	 * The object for letting players confirm or cancel the choices of redeeming a hand.
	 */
	private SelectionList confirmCancelList;
	/** 
	 * The object for displaying what happens when a player redeems a paticular hand. 
	 */
	private PokerBox pokerBox;
	/**
	 * The button for exiting the current game and returning to the main menu.
	 */
	private CenteredTextButton exitButton;
	/**
	 * The box that covers the screen and displays who won the game when the game finishes.
	 */
	private CenteredTextBox whoWonTheGameBox;
	/**
	 * The box that displays the playerSumDifference. 
	 */
	private CenteredTextBox sumDifferenceBox; 
	
	/**
	 * The constructor, only initializes the stateID. The rest is initialized in the enter method. 
	 * @param sID The id of this state, used in transitioning between states. 
	 */
	public Game59State(int sID)
	{
		super(sID);
	}

	/**
	 * The method run when transitioning to this state. Initializes all buttons, boxes, objects, and variables to their default values.
	 * Chooses a random player to go first.
	 * @param gameContainer the appGameContainer that holds the game.
	 * @param stateGame the actual game. 
	 */
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		super.enter(gameContainer, stateGame);

		player1 = new Player("Player 1", 1, DiceGame.smallFont);
		player2 = new Player("Player 2", 2, DiceGame.smallFont);
		player3 = new Player("Player 3", 3, DiceGame.smallFont);
		player4 = new Player("Player 4", 4, DiceGame.smallFont);
		mainDiceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont, true);
		rollButton = new CenteredTextButton("Roll", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		mainDieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		endTurnButton = new CenteredTextButton("End Turn", Place.GS_ENDTURNROLLDIECONFIRM_XPOS, Place.GS_ENDTURNROLLDIECONFIRM_YPOS, Place.GS_ENDTURNROLLDIECONFIRM_WIDTH, Place.GS_ENDTURNROLLDIECONFIRM_HEIGHT, DiceGame.smallFont);
		largeQueue = new LargeQueue(DiceGame.mediumFont);
		QPromptBox = new CenteredTextBox("None", Place.GS_QPROMPTBOX_XPOS, Place.GS_QPROMPTBOX_YPOS, Place.GS_QPROMPTBOX_WIDTH, Place.GS_QPROMPTBOX_HEIGHT, DiceGame.smallFont);
		redeemButton = new CenteredTextButton("Redeem Hand", Place.GS_REDEEMBUTTON_XPOS, Place.GS_REDEEMBUTTON_YPOS, Place.GS_REDEEMBUTTON_WIDTH, Place.GS_REDEEMBUTTON_HEIGHT, DiceGame.smallFont);
		runDiceHandler = new DiceHandler(DiceGame.largeFont, DiceGame.smallFont, false);
		runDieSelectedConfirmButton = new CenteredTextButton("Confirm Dice", Place.GS_RUNDIECONFIRMBUTTON_XPOS, Place.GS_RUNDIECONFIRMBUTTON_YPOS, Place.GS_RUNDIECONFIRMBUTTON_WIDTH, Place.GS_RUNDIECONFIRMBUTTON_HEIGHT, DiceGame.smallFont);
		threeOfAKindList = new SelectionList(new String[]{"0", "1", "2", "3"}, Place.GS_THREEOFKINDLIST_XPOS, Place.GS_THREEOFKINDLIST_YPOS, Place.GS_THREEOFKINDLIST_WIDTH, Place.GS_THREEOFKINDLIST_HEIGHT);
		fourOfAKindGroup = new SelectionListGroup(new String [][] {new String[]{"0", "1", "2", "3"},new String[]{"1", "2"}}, Place.GS_FOUROFKINDGROUP_XPOS, Place.GS_FOUROFKINDGROUP_YPOS, Place.GS_FOUROFKINDGROUP_WIDTH, Place.GS_FOUROFKINDGROUP_ELEMENTHEIGHT, Place.GS_FOUROFKINDGROUP_ELEMENTSPACING);
		confirmCancelList = new SelectionList(new String[]{"Confirm", "Cancel"}, Place.GS_CONFIRMCANCELLIST_XPOS, Place.GS_CONFIRMCANCELLIST_YPOS, Place.GS_CONFIRMCANCELLIST_WIDTH, Place.GS_CONFIRMCANCELLIST_HEIGHT);				
		finishedRedeemBox = new CenteredTextBox("Redeemed", Place.GS_FINISHEDREDEEMBOX_XPOS, Place.GS_FINISHEDREDEEMBOX_YPOS, Place.GS_FINISHEDREDEEMBOX_WIDTH, Place.GS_FINISHEDREDEEMBOX_HEIGHT, DiceGame.smallFont);
		exitButton = new CenteredTextButton("Return to Main", Place.GS_EXITBUTTON_XPOS, Place.GS_EXITBUTTON_YPOS, Place.GS_EXITBUTTON_WIDTH, Place.GS_EXITBUTTON_HEIGHT, DiceGame.smallFont); 
		pokerBox = new PokerBox(DiceGame.smallFont);
		whoWonTheGameBox = new CenteredTextBox("", Place.GS_WHOWONTHEGAMEBOX_XPOS, Place.GS_WHOWONTHEGAMEBOX_YPOS, Place.GS_WHOWONTHEGAMEBOX_WIDTH, Place.GS_WHOWONTHEGAMEBOX_HEIGHT, DiceGame.largeFont);
		whoWonTheGameBox.SetSelected(true);
		// variant rules object(s)
		sumDifferenceBox = new CenteredTextBox("-" + DiceGame.SUM_NUM_TO_WIN, Place.GS_SUMDIFFERENCE_XPOS, Place.GS_SUMDIFFERENCE_YPOS, Place.GS_SUMDIFFERENCE_WIDTH, Place.GS_SUMDIFFERENCE_HEIGHT, DiceGame.smallFont);
		
		hasRolled = false;
		hasRedeemed = false;
		hasConfirmedRoll = false;
		hasConfirmedRedeem = false;
		isConfirmingRun = false;
		
		runNum = 0;
		numRunRollsLeft = 0;
		playerSumDifference = 0;
	
		// random player goes first
		playerNumberTurn = rand.nextInt(3) + 1;
		getCurrentPlayerObject().InvertAllBoxes();
		endCurrentTurn = false;
		whoWonTheGame = 0;
		
		currentHand = Hands.NONE;
		confirmedHandForThisTurn = Hands.NONE;
		
		diceRolls = 0;
		
		newTurn();
	}
	
	/**
	 * The method that handles player input, or clicks, and game logic. Basically, what can currently be clicked based 
	 * on what actions the player has taken so far and what happens when that button is clicked. It uses the booleans
	 * isConfirmingRun, hasRolled, hasRedeemed, hasConfirmedRoll, and hasConfirmedRedeem to determine what 
	 * "sub update method" to run if a click occurred.
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game.
	 * @param int delta used for how much time has passed.    
	 */
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
				// logic for pair, 3 of a kind, 4 of a kind
				if(confirmedHandForThisTurn == Hands.PAIR || confirmedHandForThisTurn == Hands.THREE_OF_KIND)
				{
					newTurn();
				}
				else if (confirmedHandForThisTurn == Hands.FOUR_OF_KIND)
				{
					newTurn();
					newTurn();
					newTurn();
				}
				
				newTurn();
			}
		}
	}
	
	/**
	 * The method that handles output, or what is drawn to the screen. It uses the booleans isConfirmingRun, hasRolled, 
	 * hasRedeemed, hasConfirmedRoll, and hasConfirmedRedeem to determine "sub render method" to run.
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game
	 * @param g Graphics object to used for drawing boxes and text to the screen.
	 */
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

	// Begin update logic
	/**
	 * The method called by update to run game logic that must be checked every frame whether a click occured or not.
	 */
	public void updateAlwaysNoClicking()
	{
		whoWonTheGame = checkForWin();
	}
	
	/**
	 * The method called by update to run game logic that must be checked every frame that a click occurs.
	 * @param stateGame the game itself
	 * @param clickPositionX the X coordinate of the mouse click. 
	 * @param clickPositionY the Y coordinate of the mouse click. 
	 */
	public void updateAlwaysClicking(StateBasedGame stateGame, int clickPositionX, int clickPositionY)
	{
		if(exitButton.isWithinBound(clickPositionX, clickPositionY))
		{
			stateGame.enterState(DiceGame.MAIN);			
		}
	}
		
	// Update "sub methods"
	/**
	 * The method called by update when player has not rolled the dice and has not began redeeming a hand. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
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
	
	/**
	 * The method called by update when the player has rolled but hasn't confirmed it and hasn't started
	 * to redeem a hand. 
	 * @param clickPositionX X coordinate of the mouse click.
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
	public void updateNoConfirmRollNoRedeem(int clickPositionX, int clickPositionY)
	{	
		if(!DiceGame.doublesRule || !mainDiceHandler.getDoubles()) // no doubles rule
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
				}
			}
		}
		else // DiceGame.doublesRule && mainDiceHandler.getDoubles()
		{
			mainDiceHandler.isWithinBoundDoubles(clickPositionX, clickPositionY);
			if(mainDieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				confirmMainDieSelectedDoubles(mainDiceHandler.getDie1(), mainDiceHandler.getDie2(), mainDiceHandler.getSelected());
				hasConfirmedRoll = true;
			}			
		}
		if(largeQueue.isWithinBound(clickPositionX, clickPositionY))
		{
			setCurrentHand();
		}
	}
	
	/**
	 * The method called by update when the player has rolled and confirmed it but has not began to redeem a hand. 
	 * @param clickPositionX X coordinate of the mouse click
	 * @param clickPositionY Y coordinate of the mouse click
	 */
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
	
	/**
	 * The method called by update when the player has rolled and confirmed it and has begun redeeming a hand but has 
	 * not confirmed redeeming their hand. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
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
			confirmedHandForThisTurn = currentHand;
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
	
	/**
	 * The method called by update when the player has rolled, redeemed, and confirmed both of these actions. 
	 * @param clickPositionX X coordinate of the mouse click. 
-	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
	public void updateAllConfirmed(int clickPositionX, int clickPositionY)
	{
		if(endTurnButton.isWithinBound(clickPositionX, clickPositionY))
		{
			endCurrentTurn = true;
		}		
	}
	
	/**
	 * The method called by update when the player hasn't rolled, but has redeemed and hasn't confirmed that redeem.  
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
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
			confirmedHandForThisTurn = currentHand;
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
	
	/**
	 * The method called by update when the player has not rolled but has redeemed a hand and confirmed it. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
	public void updateNoRoll(int clickPositionX, int clickPositionY)
	{
		if(rollButton.isWithinBound(clickPositionX, clickPositionY))
		{
			mainDiceHandler.rollDice();
			hasRolled = true;
		}		
	}
	
	/**
	 * The method called by update when the player has rolled but has not confirmed it and has redeemed a hand and 
	 * confirmed it. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
	public void updateNoConfirmRoll (int clickPositionX, int clickPositionY)
	{
		if(!DiceGame.doublesRule || !mainDiceHandler.getDoubles()) // no doubles rule
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
				}
			}
		}
		else // DiceGame.doublesRule && mainDiceHandler.getDoubles()
		{
			mainDiceHandler.isWithinBoundDoubles(clickPositionX, clickPositionY);
			if(mainDieSelectedConfirmButton.isWithinBound(clickPositionX, clickPositionY))
			{
				confirmMainDieSelectedDoubles(mainDiceHandler.getDie1(), mainDiceHandler.getDie2(), mainDiceHandler.getSelected());
				hasConfirmedRoll = true;
			}			
		}
	}
	
	// SpecialHandsUpdateMethods
	/**
	 * The method called by updateNoConfirmRedeem or updateNoRollNoConfirmRedeem when the player tries to redeem a pair, 
	 * a five of a kind, or any type of run and needs to confirm it.   
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 * @return integer of whether the confirm button or cancel button was hit or neither.  
	 */
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
	
	/**
	 * The method called by updateNoConfirmRedeem or updateNoRollNoConfirmRedeem when the player tries to redeem a 
	 * three of a kind and needs to confirm it.   
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 * @return integer of whether the confirm button or cancel button was hit or neither. 
	 */
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
	
	/**
	 * The method called by updateNoConfirmRedeem or updateNoRollNoConfirmRedeem when a player tries to redeem a 
	 * four of a kind and needs to confirm it. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 * @return integer of whether the confirm button or cancel button was hit or neither.
	 */
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
		
	/**
	 * The method called by update when the player has confirmed the redemption of a run and needs to roll dice for it. 
	 * @param clickPositionX X coordinate of the mouse click. 
	 * @param clickPositionY Y coordinate of the mouse click. 
	 */
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
	
	// Rendering
	/**
	 * The method called by render every frame for objects that must always be rendered. 
	 * @param gameContainer
	 * @param stateGame
	 * @param g Graphics object to used for drawing boxes and text to the screen.
	 */
	public void alwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		// diceHandler.render(gameContainer, stateGame, g);
		player1.render(gameContainer, stateGame, g);
		player2.render(gameContainer, stateGame, g);
		player3.render(gameContainer, stateGame, g);
		player4.render(gameContainer, stateGame, g);
		pokerBox.render(gameContainer, stateGame, g);
		exitButton.render(gameContainer, stateGame, g);
		variantAlwaysRender(gameContainer, stateGame, g);
	}
	
	/**
	 * The method called by alwaysRender to render objects related to variant rules that are rendered every frame if
	 * those variant rules are chosen. 
	 * @param gameContainer
	 * @param stateGame
	 * @param g Graphics object to used for drawing boxes and text to the screen.
	 */
	public void variantAlwaysRender (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		if(DiceGame.sumRule)
		{	
			sumDifferenceBox.SetText("" + playerSumDifference);
			sumDifferenceBox.render(gameContainer, stateGame, g);
		}

	}	
	
	/**
	 * The method called by render when the player has not rolled the dice and has not begun redeeming a hand. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game.
	 * @param g Graphics object to used for drawing boxes and text to the screen.
	 */
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
	
	/**
	 * The method called by render when the player has rolled but has not confirmed it and has not redeemed a hand. 
	 * @param gameContainer the appGameContainer that holds the game.
	 * @param stateGame the actual game.
	 * @param g Graphics object used for drawing boxes and text to the screen. 
	 */
	public void renderNoConfirmRollNoRedeem(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		if(!DiceGame.doublesRule || !mainDiceHandler.getDoubles()) // no doubles rule or no doubles
		{
			if(mainDiceHandler.getSelected() != 0)
			{
				mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
			}
		}
		else // doubles rule and doubles
		{
			mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		largeQueue.render(gameContainer, stateGame, g);
		QPromptBox.render(gameContainer, stateGame, g);
	}
	
	/**
	 * The method called by render when the player has rolled but has not redeemed a hand. 
	 * @param gameContainer the appGameContainer that holds the game.  
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen. 
	 */
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

	/**
	 * The method called by render when the palyer has rolled and confirmed it but has not redeemed a hand. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game.
	 * @param g Graphics object used for drawing boxes and text to the screen. 
	 */
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

	/**
	 * The method called by render when the player has rolled, redeemed a hand, and confirmed both. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderAllConfirmed(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		endTurnButton.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}
	
	/**
	 * The method called by render when the player has not rolled but has redeemed a hand and has not confirmed that redemption. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game.
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
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

	/**
	 * The method called by render when the player has not rolled but has redeemed a hand and confirmed it.  
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderNoRoll(GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		rollButton.render(gameContainer, stateGame, g);
		mainDiceHandler.render(gameContainer, stateGame, g);
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}

	/**
	 * The method called by render when the player has rolled but has not confirmed it and has redeemed and confirmed it. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderNoConfirmRoll (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		mainDiceHandler.render(gameContainer, stateGame, g);
		if(!DiceGame.doublesRule || !mainDiceHandler.getDoubles()) // no doubles rule or no doubles
		{
			if(mainDiceHandler.getSelected() != 0)
			{
				mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
			}
		}
		else // doubles rule and doubles
		{
			mainDieSelectedConfirmButton.render(gameContainer, stateGame, g);
		}
		finishedRedeemBox.render(gameContainer, stateGame, g);
	}

	// SpecialHandsRenderMethods
	/**
	 * The method called by renderNoConfirmRedeem or renderNoRollNoConfirmRedeem when a player tries to redeem a pair,
	 * a five of a kind, or any run and needs to confirm it.  
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderConfirmSimpleHands (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		confirmCancelList.render(gameContainer, stateGame, g);
	}

	/**
	 * The method called by renderNoConfirmRedeem or renderNoRollNoConfirmRedeem when a player tries to redeem a three of
	 * a kind and needs to confirm it.  
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderConfirmThreeOfAKind (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		threeOfAKindList.render(gameContainer, stateGame, g);
		if(threeOfAKindList.getSelectedIndex() != -1)
		{
			confirmCancelList.render(gameContainer, stateGame, g);
		}
	}
	
	/**
	 * The method called by renderNoConfirmRedeem or renderNoRollNoConfirmRedeem when a player tries to redeem a four of
	 * a kind and needs to confirm it. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
	public void renderConfirmFourOfAKind (GameContainer gameContainer, StateBasedGame stateGame, Graphics g)
	{
		fourOfAKindGroup.render(gameContainer, stateGame, g);
		if(fourOfAKindGroup.getSelectionListAtIndex(0).getSelectedIndex() != -1 && fourOfAKindGroup.getSelectionListAtIndex(1).getSelectedIndex() != -1)		
		{
			confirmCancelList.render(gameContainer, stateGame, g);
		}
	}
	
	/**
	 * The method called by render when the player has redeemed a run, confirmed it, and needs to roll the dice for it. 
	 * @param gameContainer the appGameContainer that holds the game. 
	 * @param stateGame the actual game. 
	 * @param g Graphics object used for drawing boxes and text to the screen.
	 */
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
		
	/**
	 * Method used to get the object of the player whose turn it is currently. 
	 * @return the actual player object requested. 
	 */
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
	
	/**
	 * The method called by update when the current turn is ended to start a new turn by resetting variables and changing
	 * whose turn it is.  
	 */
	public void newTurn()
	{
		getCurrentPlayerObject().InvertAllBoxes();

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
		confirmedHandForThisTurn = Hands.NONE;
	
		// reset objects
		mainDiceHandler.resetDice();
		runDiceHandler.resetDice();
		largeQueue.resetSelections();
		// set largeQueue values
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
		resetRedemption();
		QPromptBox.SetText("None");
		// first turn logic
	}

	/**
	 * The method called by alwaysUpdate to check if any player has won the game yet. 
	 * @return The integer of the player's number who won the game. 0 if nobody has won. 
	 */
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
	
	/**
	 * The method called by checkForWin if variant rules for new win conditions have been choosen.
	 * @return The integer of the player's number who won the game. 0 if nobody has won.
	 */
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
	
	/**
	 * The method called by updateNoConfirmRollNoRedeem or updateNoConfirmRoll to add the selected die to the 
	 * current player's score and the unselected die to the currentPlayer's queue.  
	 * @param dieSelected
	 * @param unSelected
	 */
	public void confirmMainDieSelected(int dieSelected, int unSelected)
	{
		getCurrentPlayerObject().addMainDieValue(dieSelected, unSelected);
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
		setCurrentHand(); // with new value things in queue move so need to reset current hand
	}
	
	/**
	 * The method called by updateNoConfirmRollNoRedeem or updateNoConfirmRoll when doubles are rolled and the doubles
	 * variant rule is chosen. It adds selected dice to score and unselected dice to queue. 
	 * @param die1 
	 * @param die2 
	 * @param diceSelected 
	 */
	public void confirmMainDieSelectedDoubles(int die1, int die2, int diceSelected)
	{
		getCurrentPlayerObject().addMainDieValueDoubles(die1, die2, diceSelected);
		largeQueue.setValues(getCurrentPlayerObject().getQueueValues());
		setCurrentHand(); // with new value things in queue move so need to reset current hand
	}
	
	// when I click on the largeQueue I need to setCurrentHand, and update QPromptBox
	/**
	 * The method used to figure out what hand is formed by the current large queue selections.
	 */
	public void setCurrentHand()
	{
		queueAnalyzer = new QueueAnalyzer (largeQueue.getSelectedValues());
		currentHand = queueAnalyzer.handFinder();
		QPromptBox.SetText(currentHand.toString());
	}
	
	/**
	 * The method called by updateNoRollNoConfirmRedeen or updateNoConfirmRedeem when the cancel button is hit while
	 * a player had redeemed a hand but not confirmed it. Also used by newTurn. 
	 */
	public void resetRedemption()
	{
		// if cancel is hit, deselect things
		confirmCancelList.resetSelection();
		threeOfAKindList.resetSelection();
		fourOfAKindGroup.resetSelection();
	}

	/**
	 * The method called by updateIsConfirmingRun when a player rolls the dice and has selected one to go to his queue. 
	 * @param dieSelected the value of the die that is selected.
	 * @param unSelected the value of the die that is unselected.
	 */
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
	
	/**
	 * The method called when a player confirms a three of a kind to add X to his score and subtract 3-X from 
	 * opponents' scores. 
	 * @param selectedIndex the index of the selectionList that chooses X for the three of a kind action. 
	 */
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
	
	/**
	 * The method called when a player confirms a three of a kind to add X* to his score and subtract 6-X*Y from
	 * opponents' scores. 
	 * @param firstIndex the index of the selectionList that chooses X. 
	 * @param secondIndex the index of the selectionList that chooses Y.
	 */
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
}