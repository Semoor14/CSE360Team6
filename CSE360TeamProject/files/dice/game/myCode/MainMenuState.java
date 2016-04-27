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

/**
 * Main menu game state, from main menu you can enter states: 
 * Start game, setup, rules stats and you may close the game window.
 * @author Scott
 */
public class MainMenuState  extends ParentGameState
{	
	private CenteredTextBox gameNameBox;
	private CenteredTextButton gameStartButton;
	private CenteredTextButton gameSetupButton;
	private CenteredTextButton gameRulesButton;
	private CenteredTextButton gameStatisticsButton;
	private CenteredTextButton gameExitButton;
	
	/**
	 * @param sID state ID identifies which game state to enter. 
	 */
	public MainMenuState(int sID)
	{
		super(sID);
	}
	
	/**
	 * Handles button click location and changes game state based on 
	 * X/Y click locations.
	 * @param gameContainer
	 * @param stateGame
	 * @param arg2
	 * @throws SlickException
	 */
	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException 
	{
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			//ask the game name box if its been clicked
			if(gameStartButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(DiceGame.GAME_59);
			}
			if(gameSetupButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(DiceGame.SETUP);
			}
			if(gameRulesButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(DiceGame.RULES);
			}
			if(gameStatisticsButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(DiceGame.STATISTICS);
			}
			if(gameExitButton.isWithinBound(mouseX, mouseY))
			{
				gameContainer.exit();
			}
		}
	}
	
	/**
	 * Renders main menu game state including centered text buttons for start game setup rules and statistics.
	 * @param gameContainer
	 * @param stateGame
	 * @param g
	 * @throws SlickException
	 */
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.white);
		if (gameNameBox != null)
			gameNameBox.render(gameContainer, stateGame, g);
		if (gameStartButton != null)
			gameStartButton.render(gameContainer, stateGame, g);
		if (gameSetupButton != null)
			gameSetupButton.render(gameContainer, stateGame, g);
		if (gameRulesButton != null)
			gameRulesButton.render(gameContainer, stateGame, g);
		if (gameStatisticsButton != null)
			gameStatisticsButton.render(gameContainer, stateGame, g);
		if (gameExitButton != null)
			gameExitButton.render(gameContainer, stateGame, g);
	}
	
	/**
	 * Enter creates centered text buttons, which check if a click has occured within bounds of the click. 
	 * Then changes the game state based on what was clicked.
	 * @param gameContainer
	 * @param stateGame
	 * @throws SlickException
	 */
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		super.enter(gameContainer, stateGame);
		
		gameNameBox = new CenteredTextBox("59", Place.MS_GAMENAMEBOX_XPOS, Place.MS_GAMENAMEBOX_YPOS, Place.MS_GAMENAMEBOX_WIDTH, Place.MS_GAMENAMEBOX_HEIGHT, DiceGame.veryLargeFont);				
		gameStartButton = new CenteredTextButton("Play Game", Place.MS_GAMESTARTBUTTON_XPOS, Place.MS_GAMESTARTBUTTON_YPOS, Place.MS_GAMESTARTBUTTON_WIDTH, Place.MS_GAMESTARTBUTTON_HEIGHT, DiceGame.mediumFont);
		gameSetupButton = new CenteredTextButton("Setup", Place.MS_GAMESETUPBUTTON_XPOS, Place.MS_GAMESETUPBUTTON_YPOS, Place.MS_GAMESETUPBUTTON_WIDTH, Place.MS_GAMESETUPBUTTON_HEIGHT, DiceGame.mediumFont); 
		gameRulesButton = new CenteredTextButton("Rules", Place.MS_GAMERULESBUTTON_XPOS, Place.MS_GAMERULESBUTTON_YPOS, Place.MS_GAMERULESBUTTON_WIDTH, Place.MS_GAMERULESBUTTON_HEIGHT, DiceGame.mediumFont); 
		gameStatisticsButton = new CenteredTextButton("Statistics", Place.MS_GAMESTATISTICSBUTTON_XPOS, Place.MS_GAMESTATISTICSBUTTON_YPOS, Place.MS_GAMESTATISTICSBUTTON_WIDTH, Place.MS_GAMESTATISTICSBUTTON_HEIGHT, DiceGame.mediumFont);
		gameExitButton = new CenteredTextButton("Exit", Place.MS_GAMEEXITBUTTON_XPOS, Place.MS_GAMEEXITBUTTON_YPOS, Place.MS_GAMEEXITBUTTON_WIDTH, Place.MS_GAMEEXITBUTTON_HEIGHT, DiceGame.mediumFont);
	}
}