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

public class MainMenuState  extends ParentGameState
{	
	private CenteredTextBox gameNameBox;

	private CenteredTextButton gameStartButton;
	
	public MainMenuState(int sID)
	{
		super(sID);
	}
	
	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException 
	{
		// TODO Auto-generated method stub
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			//ask the game name box if its been clicked
			if(gameStartButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(DiceGame.GAME_37);
			}
		}
	}
	
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.gray);
		if (gameNameBox != null)
			gameNameBox.render(gameContainer, stateGame, g);
		if (gameStartButton != null)
			gameStartButton.render(gameContainer, stateGame, g);
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		super.enter(gameContainer, stateGame);
		
		gameNameBox = new CenteredTextBox("37", Place.MS_GAMENAMEBOX_XPOS, Place.MS_GAMENAMEBOX_YPOS, Place.MS_GAMENAMEBOX_WIDTH, Place.MS_GAMENAMEBOX_HEIGHT, DiceGame.veryLargeFont);				
		gameStartButton = new CenteredTextButton("Play Game", Place.MS_GAMESTARTBUTTON_XPOS, Place.MS_GAMESTARTBUTTON_YPOS, Place.MS_GAMESTARTBUTTON_WIDTH, Place.MS_GAMESTARTBUTTON_HEIGHT, DiceGame.mediumFont);
	}
}