package cse360.team6;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuGameState  implements GameState
{
	private static final float GAME_NAME_BOX_Y_POSITION_PERCENT_FROM_MIDDLE = .1f;
	private static final float GAME_NAME_BOX_HEIGHT_PERCENT = .1f;
	private static final float GAME_NAME_BOX_WIDTH_PERCENT = .15f;
	private CenteredTextBox gameNameBox;
	
	private static final float GAME_START_BUTTON_Y_POSITION_PERCENT_FROM_MIDDLE = -.1f;
	private static final float GAME_START_BUTTON_PERCENT = .1f;
	private static final float GAME_START_BUTTON_WIDTH_PERCENT = .3f;
	private CenteredTextButton gameStartButton;
	
	public MainMenuGameState(int main){}
	
	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException {
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException {
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
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException {
		g.setBackground(Color.gray);
		if (gameNameBox != null)
			gameNameBox.render(gameContainer, stateGame, g);
		if (gameStartButton != null)
			gameStartButton.render(gameContainer, stateGame, g);
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException {
		//initialize fonts
		Font sFont = new Font("Arial", Font.PLAIN, 18);
		DiceGame.smallFont = new TrueTypeFont(sFont,false);
		
		Font mFont = new Font("Arial", Font.PLAIN, 26);
		DiceGame.mediumFont = new TrueTypeFont(mFont,false);
		
		Font lFont = new Font("Arial", Font.PLAIN, 40);
		DiceGame.largeFont = new TrueTypeFont(lFont,false);
		
		int boxHeight = (int)(gameContainer.getHeight() * GAME_NAME_BOX_HEIGHT_PERCENT);
		int boxWidth = (int)(gameContainer.getWidth() * GAME_NAME_BOX_WIDTH_PERCENT);
		
		int boxX = (gameContainer.getWidth() - boxWidth)/2;
		int boxY = (gameContainer.getHeight() - boxHeight)/2;
		boxY -= gameContainer.getHeight() * GAME_NAME_BOX_Y_POSITION_PERCENT_FROM_MIDDLE;;
		
		gameNameBox = new CenteredTextBox("37", boxX, boxY, boxWidth, boxHeight, DiceGame.largeFont);
		
		int buttonHeight = (int)(gameContainer.getHeight() * GAME_START_BUTTON_PERCENT);
		int buttonWidth = (int)(gameContainer.getWidth() * GAME_START_BUTTON_WIDTH_PERCENT);
		
		int buttonX = (gameContainer.getWidth() - buttonWidth)/2;
		int buttonY = (gameContainer.getHeight() - buttonHeight)/2;
		buttonY -= gameContainer.getHeight() * GAME_START_BUTTON_Y_POSITION_PERCENT_FROM_MIDDLE;
		
		gameStartButton = new CenteredTextButton("Start Game", buttonX, buttonY, buttonWidth, buttonHeight, DiceGame.mediumFont);
	}

	@Override
	public void leave(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return DiceGame.MAIN;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int numClicked) {
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int button, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
