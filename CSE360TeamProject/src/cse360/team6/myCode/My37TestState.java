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
	private MyDiceHandler diceHandler;
	
	private int endTurn_XPos;
	private int endTurn_YPos;
	private int endTurn_Width;
	private int endTurn_Height;
	
	private MyCenteredTextButton endTurn;
	
	public My37TestState(int main)
	{}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int delta) throws SlickException 
	{
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			largeQueue.isWithinBound(mouseX, mouseY);
			diceHandler.isWithinBound(mouseX, mouseY);
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
		g.setBackground(Color.white);
		if (largeQueue != null)
			largeQueue.render(gameContainer, stateGame, g);
		if(player1 != null)
			player1.render(gameContainer, stateGame, g);
		if(diceHandler != null)
			diceHandler.render(gameContainer, stateGame, g);
		/*
		if (C2c4Box != null)
			C2c4Box.render(gameContainer, stateGame, g);
		if (gameStartButton != null)
			gameStartButton.render(gameContainer, stateGame, g);
		*/
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		//initialize fonts
		MyDiceGame.initializeFonts();
		largeQueue = new MyLargeQueue(MyDiceGame.mediumFont);
		player1 = new MyPlayer("Player 1", 1, MyDiceGame.smallFont);
		diceHandler = new MyDiceHandler(MyDiceGame.largeFont, MyDiceGame.smallFont);
		endTurn = new MyCenteredTextButton("End Turn", endTurn_XPos, endTurn_YPos, endTurn_Width, endTurn_Height, MyDiceGame.smallFont);
		// C2c3Box = new MyCenteredTextBox ("5", C2C3BOX_XPOS, C2C3BOX_YPOS, C2C3BOX_WIDTH, C2C3BOX_HEIGHT, MyDiceGame.smallFont);
		// C2c4Box = new MyCenteredTextBox ("9", C2C4BOX_XPOS, C2C4BOX_YPOS, C2C4BOX_WIDTH, C2C4BOX_HEIGHT, MyDiceGame.smallFont);
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
