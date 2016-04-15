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

public class My37GameState implements GameState
{
	
	private static final int DICEBOX1_XPOS = 248;
	private static final int DICEBOX1_YPOS = 16;
	private static final int DICEBOX1_WIDTH = 64;
	private static final int DICEBOX1_HEIGHT = 64;
	private MyCenteredTextBox DiceBox1;

	private static final int DICEBOX2_XPOS = 328;
	private static final int DICEBOX2_YPOS = 16;
	private static final int DICEBOX2_WIDTH = 64;
	private static final int DICEBOX2_HEIGHT = 64;
	private MyCenteredTextBox DiceBox2;

	private static final int RAETBOX_XPOS = 412;
	private static final int RAETBOX_YPOS = 32;
	private static final int RAETBOX_WIDTH = 96;
	private static final int RAETBOX_HEIGHT = 32;
	private MyCenteredTextBox RollAndEndTurnBox;
	
	private static final int P1SCOREBOX_XPOS = 16;
	private static final int P1SCOREBOX_YPOS = 96;
	private static final int P1SCOREBOX_WIDTH = 160;
	private static final int P1SCOREBOX_HEIGHT = 32;
	private MyCenteredTextBox P1ScoreBox;

	private static final int P1Q1BOX_XPOS = 16;
	private static final int P1Q1BOX_YPOS = 128;
	private static final int P1Q1BOX_WIDTH = 32;
	private static final int P1Q1BOX_HEIGHT = 32;
	private MyCenteredTextBox P1Q1Box;

	private static final int P1Q2BOX_XPOS = 48;
	private static final int P1Q2BOX_YPOS = 128;
	private static final int P1Q2BOX_WIDTH = 32;
	private static final int P1Q2BOX_HEIGHT = 32;
	private MyCenteredTextBox P1Q2Box;

	private static final int P1Q3BOX_XPOS = 80;
	private static final int P1Q3BOX_YPOS = 128;
	private static final int P1Q3BOX_WIDTH = 32;
	private static final int P1Q3BOX_HEIGHT = 32;
	private MyCenteredTextBox P1Q3Box;

	private static final int P1Q4BOX_XPOS = 112;
	private static final int P1Q4BOX_YPOS = 128;
	private static final int P1Q4BOX_WIDTH = 32;
	private static final int P1Q4BOX_HEIGHT = 32;
	private MyCenteredTextBox P1Q4Box;

	private static final int P1Q5BOX_XPOS = 144;
	private static final int P1Q5BOX_YPOS = 128;
	private static final int P1Q5BOX_WIDTH = 32;
	private static final int P1Q5BOX_HEIGHT = 32;
	private MyCenteredTextBox P1Q5Box;

	private static final int P2SCOREBOX_XPOS = 16;
	private static final int P2SCOREBOX_YPOS = 192;
	private static final int P2SCOREBOX_WIDTH = 160;
	private static final int P2SCOREBOX_HEIGHT = 32;
	private MyCenteredTextBox P2ScoreBox;

	private static final int P2Q1BOX_XPOS = 16;
	private static final int P2Q1BOX_YPOS = 224;
	private static final int P2Q1BOX_WIDTH = 32;
	private static final int P2Q1BOX_HEIGHT = 32;
	private MyCenteredTextBox P2Q1Box;

	private static final int P2Q2BOX_XPOS = 48;
	private static final int P2Q2BOX_YPOS = 224;
	private static final int P2Q2BOX_WIDTH = 32;
	private static final int P2Q2BOX_HEIGHT = 32;
	private MyCenteredTextBox P2Q2Box;

	private static final int P2Q3BOX_XPOS = 80;
	private static final int P2Q3BOX_YPOS = 224;
	private static final int P2Q3BOX_WIDTH = 32;
	private static final int P2Q3BOX_HEIGHT = 32;
	private MyCenteredTextBox P2Q3Box;

	private static final int P2Q4BOX_XPOS = 112;
	private static final int P2Q4BOX_YPOS = 224;
	private static final int P2Q4BOX_WIDTH = 32;
	private static final int P2Q4BOX_HEIGHT = 32;
	private MyCenteredTextBox P2Q4Box;

	private static final int P2Q5BOX_XPOS = 144;
	private static final int P2Q5BOX_YPOS = 224;
	private static final int P2Q5BOX_WIDTH = 32;
	private static final int P2Q5BOX_HEIGHT = 32;
	private MyCenteredTextBox P2Q5Box;
	
	private static final int P3SCOREBOX_XPOS = 16;
	private static final int P3SCOREBOX_YPOS = 288;
	private static final int P3SCOREBOX_WIDTH = 160;
	private static final int P3SCOREBOX_HEIGHT = 32;
	private MyCenteredTextBox P3ScoreBox;

	private static final int P3Q1BOX_XPOS = 16;
	private static final int P3Q1BOX_YPOS = 320;
	private static final int P3Q1BOX_WIDTH = 32;
	private static final int P3Q1BOX_HEIGHT = 32;
	private MyCenteredTextBox P3Q1Box;

	private static final int P3Q2BOX_XPOS = 48;
	private static final int P3Q2BOX_YPOS = 320;
	private static final int P3Q2BOX_WIDTH = 32;
	private static final int P3Q2BOX_HEIGHT = 32;
	private MyCenteredTextBox P3Q2Box;

	private static final int P3Q3BOX_XPOS = 80;
	private static final int P3Q3BOX_YPOS = 320;
	private static final int P3Q3BOX_WIDTH = 32;
	private static final int P3Q3BOX_HEIGHT = 32;
	private MyCenteredTextBox P3Q3Box;

	private static final int P3Q4BOX_XPOS = 112;
	private static final int P3Q4BOX_YPOS = 320;
	private static final int P3Q4BOX_WIDTH = 32;
	private static final int P3Q4BOX_HEIGHT = 32;
	private MyCenteredTextBox P3Q4Box;

	private static final int P3Q5BOX_XPOS = 144;
	private static final int P3Q5BOX_YPOS = 320;
	private static final int P3Q5BOX_WIDTH = 32;
	private static final int P3Q5BOX_HEIGHT = 32;
	private MyCenteredTextBox P3Q5Box;
		
	private static final int P4SCOREBOX_XPOS = 16;
	private static final int P4SCOREBOX_YPOS = 384;
	private static final int P4SCOREBOX_WIDTH = 160;
	private static final int P4SCOREBOX_HEIGHT = 32;
	private MyCenteredTextBox P4ScoreBox;

	private static final int P4Q1BOX_XPOS = 16;
	private static final int P4Q1BOX_YPOS = 416;
	private static final int P4Q1BOX_WIDTH = 32;
	private static final int P4Q1BOX_HEIGHT = 32;
	private MyCenteredTextBox P4Q1Box;

	private static final int P4Q2BOX_XPOS = 48;
	private static final int P4Q2BOX_YPOS = 416;
	private static final int P4Q2BOX_WIDTH = 32;
	private static final int P4Q2BOX_HEIGHT = 32;
	private MyCenteredTextBox P4Q2Box;

	private static final int P4Q3BOX_XPOS = 80;
	private static final int P4Q3BOX_YPOS = 416;
	private static final int P4Q3BOX_WIDTH = 32;
	private static final int P4Q3BOX_HEIGHT = 32;
	private MyCenteredTextBox P4Q3Box;

	private static final int P4Q4BOX_XPOS = 112;
	private static final int P4Q4BOX_YPOS = 416;
	private static final int P4Q4BOX_WIDTH = 32;
	private static final int P4Q4BOX_HEIGHT = 32;
	private MyCenteredTextBox P4Q4Box;

	private static final int P4Q5BOX_XPOS = 144;
	private static final int P4Q5BOX_YPOS = 416;
	private static final int P4Q5BOX_WIDTH = 32;
	private static final int P4Q5BOX_HEIGHT = 32;
	private MyCenteredTextBox P4Q5Box;
	
	private static final int LARGEQ1BOX_XPOS = 200;
	private static final int LARGEQ1BOX_YPOS = 96;
	private static final int LARGEQ1BOX_WIDTH = 48;
	private static final int LARGEQ1BOX_HEIGHT = 48;
	private MyCenteredTextBox LargeQ1Box;
	
	private static final int LARGEQ2BOX_XPOS = 248;
	private static final int LARGEQ2BOX_YPOS = 96;
	private static final int LARGEQ2BOX_WIDTH = 48;
	private static final int LARGEQ2BOX_HEIGHT = 48;
	private MyCenteredTextBox LargeQ2Box;
	
	private static final int LARGEQ3BOX_XPOS = 296;
	private static final int LARGEQ3BOX_YPOS = 96;
	private static final int LARGEQ3BOX_WIDTH = 48;
	private static final int LARGEQ3BOX_HEIGHT = 48;
	private MyCenteredTextBox LargeQ3Box;
	
	private static final int LARGEQ4BOX_XPOS = 344;
	private static final int LARGEQ4BOX_YPOS = 96;
	private static final int LARGEQ4BOX_WIDTH = 48;
	private static final int LARGEQ4BOX_HEIGHT = 48;
	private MyCenteredTextBox LargeQ4Box;

	private static final int LARGEQ5BOX_XPOS = 392;
	private static final int LARGEQ5BOX_YPOS = 96;
	private static final int LARGEQ5BOX_WIDTH = 48;
	private static final int LARGEQ5BOX_HEIGHT = 48;
	private MyCenteredTextBox LargeQ5Box;
	
	private static final int QPROMPTBOX_XPOS = 232;
	private static final int QPROMPTBOX_YPOS = 160;
	private static final int QPROMPTBOX_WIDTH = 176;
	private static final int QPROMPTBOX_HEIGHT = 32;
	private MyCenteredTextBox QPromptBox;
	
	private static final int REDEEMBOX_XPOS = 232;
	private static final int REDEEMBOX_YPOS = 192;
	private static final int REDEEMBOX_WIDTH = 176;
	private static final int REDEEMBOX_HEIGHT = 32;
	private MyCenteredTextBox RedeemBox;

	private static final int POKERBOX_XPOS = 464;
	private static final int POKERBOX_YPOS = 96;
	private static final int POKERBOX_WIDTH = 160;
	private static final int POKERBOX_HEIGHT = 32;
	private MyCenteredTextBox PokerBox;
	
	private static final int HANDSBOX_XPOS = 464;
	private static final int HANDSBOX_YPOS = 128;
	private static final int HANDSBOX_WIDTH = 160;
	private static final int HANDSBOX_HEIGHT = 256;
	private MyCenteredTextBox HandsBox;
	
	private static final int RULESBOX_XPOS = 464;
	private static final int RULESBOX_YPOS = 392;
	private static final int RULESBOX_WIDTH = 160;
	private static final int RULESBOX_HEIGHT = 32;
	private MyCenteredTextBox RulesBox;
	
	private static final int EXITBOX_XPOS = 464;
	private static final int EXITBOX_YPOS = 432;
	private static final int EXITBOX_WIDTH = 160;
	private static final int EXITBOX_HEIGHT = 32;
	private MyCenteredTextBox ExitBox;
	
	private static final int C1C1BOX_XPOS = 232;
	private static final int C1C1BOX_YPOS = 240;
	private static final int C1C1BOX_WIDTH = 176;
	private static final int C1C1BOX_HEIGHT = 32;
	private MyCenteredTextBox C1c1Box;

	private static final int C1C2BOX_XPOS = 232;
	private static final int C1C2BOX_YPOS = 272;
	private static final int C1C2BOX_WIDTH = 176;
	private static final int C1C2BOX_HEIGHT = 32;
	private MyCenteredTextBox C1c2Box;
	
	private static final int C2C1BOX_XPOS = 232;
	private static final int C2C1BOX_YPOS = 320;
	private static final int C2C1BOX_WIDTH = 176;
	private static final int C2C1BOX_HEIGHT = 32;
	private MyCenteredTextBox C2c1Box;
	
	private static final int C2C2BOX_XPOS = 232;
	private static final int C2C2BOX_YPOS = 352;
	private static final int C2C2BOX_WIDTH = 176;
	private static final int C2C2BOX_HEIGHT = 32;
	private MyCenteredTextBox C2c2Box;
	/*
	private static final int C2C3BOX_XPOS = 232;
	private static final int C2C3BOX_YPOS = 384;
	private static final int C2C3BOX_WIDTH = 176;
	private static final int C2C3BOX_HEIGHT = 32;
	private MyCenteredTextBox C2c3Box;
	
	private static final int C2C4BOX_XPOS = 232;
	private static final int C2C4BOX_YPOS = 416;
	private static final int C2C4BOX_WIDTH = 176;
	private static final int C2C4BOX_HEIGHT = 32;
	private MyCenteredTextBox C2c4Box;
	*/

	private static final int CONFIRMBOX_XPOS = 232;
	private static final int CONFIRMBOX_YPOS = 400;
	private static final int CONFIRMBOX_WIDTH = 176;
	private static final int CONFIRMBOX_HEIGHT = 32;
	private MyCenteredTextBox ConfirmBox;
	
	private static final int CANCELBOX_XPOS = 232;
	private static final int CANCELBOX_YPOS = 432;
	private static final int CANCELBOX_WIDTH = 176;
	private static final int CANCELBOX_HEIGHT = 32;
	private MyCenteredTextBox CancelBox;
	
	/*
	private static final float GAME_START_BUTTON_Y_POSITION_PERCENT_FROM_MIDDLE = -.1f;
	private static final float GAME_START_BUTTON_PERCENT = .1f;
	private static final float GAME_START_BUTTON_WIDTH_PERCENT = .3f;
	private MyCenteredTextButton gameStartButton;
	*/
	
	public My37GameState(int main)
	{}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException 
	{		
		/*
		Input input = gameContainer.getInput();
		if (input.isMousePressed(0))
		{
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			
			// ask the game name box if its been clicked
			// This re-enters the state we are already in, edit out later
			if(gameStartButton.isWithinBound(mouseX, mouseY))
			{
				stateGame.enterState(MyDiceGame.GAME_37);
			}
		}
		*/
	}
	
	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.setBackground(Color.white);
		if (DiceBox1 != null)
			DiceBox1.render(gameContainer, stateGame, g);
		if (DiceBox2 != null)
			DiceBox2.render(gameContainer, stateGame, g);
		if (RollAndEndTurnBox != null)
			RollAndEndTurnBox.render(gameContainer, stateGame, g);
		
		if (P1ScoreBox != null)
			P1ScoreBox.render(gameContainer, stateGame, g);
		if (P1Q1Box != null)
			P1Q1Box.render(gameContainer, stateGame, g);
		if (P1Q2Box != null)
			P1Q2Box.render(gameContainer, stateGame, g);
		if (P1Q3Box != null)
			P1Q3Box.render(gameContainer, stateGame, g);
		if (P1Q4Box != null)
			P1Q4Box.render(gameContainer, stateGame, g);
		if (P1Q5Box != null)
			P1Q5Box.render(gameContainer, stateGame, g);
		
		if (P2ScoreBox != null)
			P2ScoreBox.render(gameContainer, stateGame, g);
		if (P2Q1Box != null)
			P2Q1Box.render(gameContainer, stateGame, g);
		if (P2Q2Box != null)
			P2Q2Box.render(gameContainer, stateGame, g);
		if (P2Q3Box != null)
			P2Q3Box.render(gameContainer, stateGame, g);
		if (P2Q4Box != null)
			P2Q4Box.render(gameContainer, stateGame, g);
		if (P2Q5Box != null)
			P2Q5Box.render(gameContainer, stateGame, g);
		
		if (P3ScoreBox != null)
			P3ScoreBox.render(gameContainer, stateGame, g);
		if (P3Q1Box != null)
			P3Q1Box.render(gameContainer, stateGame, g);
		if (P3Q2Box != null)
			P3Q2Box.render(gameContainer, stateGame, g);
		if (P3Q3Box != null)
			P3Q3Box.render(gameContainer, stateGame, g);
		if (P3Q4Box != null)
			P3Q4Box.render(gameContainer, stateGame, g);
		if (P3Q5Box != null)
			P3Q5Box.render(gameContainer, stateGame, g);

		if (P4ScoreBox != null)
			P4ScoreBox.render(gameContainer, stateGame, g);
		if (P4Q1Box != null)
			P4Q1Box.render(gameContainer, stateGame, g);
		if (P4Q2Box != null)
			P4Q2Box.render(gameContainer, stateGame, g);
		if (P4Q3Box != null)
			P4Q3Box.render(gameContainer, stateGame, g);
		if (P4Q4Box != null)
			P4Q4Box.render(gameContainer, stateGame, g);
		if (P4Q5Box != null)
			P4Q5Box.render(gameContainer, stateGame, g);

		if (LargeQ1Box != null)
			LargeQ1Box.render(gameContainer, stateGame, g);
		if (LargeQ2Box != null)
			LargeQ2Box.render(gameContainer, stateGame, g);
		if (LargeQ3Box != null)
			LargeQ3Box.render(gameContainer, stateGame, g);
		if (LargeQ4Box != null)
			LargeQ4Box.render(gameContainer, stateGame, g);
		if (LargeQ5Box != null)
			LargeQ5Box.render(gameContainer, stateGame, g);

		if (QPromptBox != null)
			QPromptBox.render(gameContainer, stateGame, g);
		if (RedeemBox != null)
			RedeemBox.render(gameContainer, stateGame, g);
		if (PokerBox != null)
			PokerBox.render(gameContainer, stateGame, g);
		if (HandsBox != null)
			HandsBox.render(gameContainer, stateGame, g);
		if (RulesBox != null)
			RulesBox.render(gameContainer, stateGame, g);
		if (ExitBox != null)
			ExitBox.render(gameContainer, stateGame, g);
		
		if (C1c1Box != null)
			C1c1Box.render(gameContainer, stateGame, g);
		if (C1c2Box != null)
			C1c2Box.render(gameContainer, stateGame, g);
		
		if (C2c1Box != null)
			C2c1Box.render(gameContainer, stateGame, g);
		if (C2c2Box != null)
			C2c2Box.render(gameContainer, stateGame, g);
		/*
		if (C2c3Box != null)
			C2c3Box.render(gameContainer, stateGame, g);
		if (C2c4Box != null)
			C2c4Box.render(gameContainer, stateGame, g);
		*/
		if (ConfirmBox != null)
			ConfirmBox.render(gameContainer, stateGame, g);
		if (CancelBox != null)
			CancelBox.render(gameContainer, stateGame, g);


		/*
		if (gameStartButton != null)
			gameStartButton.render(gameContainer, stateGame, g);
		*/
	}
	
	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		//initialize fonts
		MyDiceGame.initializeFonts();
		DiceBox1 = new MyCenteredTextBox ("", DICEBOX1_XPOS, DICEBOX1_YPOS, DICEBOX1_WIDTH, DICEBOX1_HEIGHT, MyDiceGame.largeFont);
		DiceBox2 = new MyCenteredTextBox ("", DICEBOX2_XPOS, DICEBOX2_YPOS, DICEBOX2_WIDTH, DICEBOX2_HEIGHT, MyDiceGame.largeFont);
		RollAndEndTurnBox = new MyCenteredTextBox ("Roll", RAETBOX_XPOS, RAETBOX_YPOS, RAETBOX_WIDTH, RAETBOX_HEIGHT, MyDiceGame.smallFont);
		
		P1ScoreBox = new MyCenteredTextBox ("Player 1: 15", P1SCOREBOX_XPOS, P1SCOREBOX_YPOS, P1SCOREBOX_WIDTH, P1SCOREBOX_HEIGHT, MyDiceGame.smallFont);
		P1Q1Box = new MyCenteredTextBox ("1", P1Q1BOX_XPOS, P1Q1BOX_YPOS, P1Q1BOX_WIDTH, P1Q1BOX_HEIGHT, MyDiceGame.smallFont);
		P1Q2Box = new MyCenteredTextBox ("2", P1Q2BOX_XPOS, P1Q2BOX_YPOS, P1Q2BOX_WIDTH, P1Q2BOX_HEIGHT, MyDiceGame.smallFont);
		P1Q3Box = new MyCenteredTextBox ("3", P1Q3BOX_XPOS, P1Q3BOX_YPOS, P1Q3BOX_WIDTH, P1Q3BOX_HEIGHT, MyDiceGame.smallFont);
		P1Q4Box = new MyCenteredTextBox ("4", P1Q4BOX_XPOS, P1Q4BOX_YPOS, P1Q4BOX_WIDTH, P1Q4BOX_HEIGHT, MyDiceGame.smallFont);
		P1Q5Box = new MyCenteredTextBox ("10", P1Q5BOX_XPOS, P1Q5BOX_YPOS, P1Q5BOX_WIDTH, P1Q5BOX_HEIGHT, MyDiceGame.smallFont);
		
		P2ScoreBox = new MyCenteredTextBox ("Player 2: 25", P2SCOREBOX_XPOS, P2SCOREBOX_YPOS, P2SCOREBOX_WIDTH, P2SCOREBOX_HEIGHT, MyDiceGame.smallFont);
		P2Q1Box = new MyCenteredTextBox ("1", P2Q1BOX_XPOS, P2Q1BOX_YPOS, P2Q1BOX_WIDTH, P2Q1BOX_HEIGHT, MyDiceGame.smallFont);
		P2Q2Box = new MyCenteredTextBox ("9", P2Q2BOX_XPOS, P2Q2BOX_YPOS, P2Q2BOX_WIDTH, P2Q2BOX_HEIGHT, MyDiceGame.smallFont);
		P2Q3Box = new MyCenteredTextBox ("8", P2Q3BOX_XPOS, P2Q3BOX_YPOS, P2Q3BOX_WIDTH, P2Q3BOX_HEIGHT, MyDiceGame.smallFont);
		P2Q4Box = new MyCenteredTextBox ("5", P2Q4BOX_XPOS, P2Q4BOX_YPOS, P2Q4BOX_WIDTH, P2Q4BOX_HEIGHT, MyDiceGame.smallFont);
		P2Q5Box = new MyCenteredTextBox ("1", P2Q5BOX_XPOS, P2Q5BOX_YPOS, P2Q5BOX_WIDTH, P2Q5BOX_HEIGHT, MyDiceGame.smallFont);		

		P3ScoreBox = new MyCenteredTextBox ("Player 3: 8", P3SCOREBOX_XPOS, P3SCOREBOX_YPOS, P3SCOREBOX_WIDTH, P3SCOREBOX_HEIGHT, MyDiceGame.smallFont);
		P3Q1Box = new MyCenteredTextBox ("2", P3Q1BOX_XPOS, P3Q1BOX_YPOS, P3Q1BOX_WIDTH, P3Q1BOX_HEIGHT, MyDiceGame.smallFont);
		P3Q2Box = new MyCenteredTextBox ("10", P3Q2BOX_XPOS, P3Q2BOX_YPOS, P3Q2BOX_WIDTH, P3Q2BOX_HEIGHT, MyDiceGame.smallFont);
		P3Q3Box = new MyCenteredTextBox ("10", P3Q3BOX_XPOS, P3Q3BOX_YPOS, P3Q3BOX_WIDTH, P3Q3BOX_HEIGHT, MyDiceGame.smallFont);
		P3Q4Box = new MyCenteredTextBox ("7", P3Q4BOX_XPOS, P3Q4BOX_YPOS, P3Q4BOX_WIDTH, P3Q4BOX_HEIGHT, MyDiceGame.smallFont);
		P3Q5Box = new MyCenteredTextBox ("4", P3Q5BOX_XPOS, P3Q5BOX_YPOS, P3Q5BOX_WIDTH, P3Q5BOX_HEIGHT, MyDiceGame.smallFont);		

		P4ScoreBox = new MyCenteredTextBox ("Player 4: 34", P4SCOREBOX_XPOS, P4SCOREBOX_YPOS, P4SCOREBOX_WIDTH, P4SCOREBOX_HEIGHT, MyDiceGame.smallFont);
		P4Q1Box = new MyCenteredTextBox ("5", P4Q1BOX_XPOS, P4Q1BOX_YPOS, P4Q1BOX_WIDTH, P4Q1BOX_HEIGHT, MyDiceGame.smallFont);
		P4Q2Box = new MyCenteredTextBox ("7", P4Q2BOX_XPOS, P4Q2BOX_YPOS, P4Q2BOX_WIDTH, P4Q2BOX_HEIGHT, MyDiceGame.smallFont);
		P4Q3Box = new MyCenteredTextBox ("6", P4Q3BOX_XPOS, P4Q3BOX_YPOS, P4Q3BOX_WIDTH, P4Q3BOX_HEIGHT, MyDiceGame.smallFont);
		P4Q4Box = new MyCenteredTextBox ("8", P4Q4BOX_XPOS, P4Q4BOX_YPOS, P4Q4BOX_WIDTH, P4Q4BOX_HEIGHT, MyDiceGame.smallFont);
		P4Q5Box = new MyCenteredTextBox ("1", P4Q5BOX_XPOS, P4Q5BOX_YPOS, P4Q5BOX_WIDTH, P4Q5BOX_HEIGHT, MyDiceGame.smallFont);		

		LargeQ1Box = new MyCenteredTextBox ("1", LARGEQ1BOX_XPOS, LARGEQ1BOX_YPOS, LARGEQ1BOX_WIDTH, LARGEQ1BOX_HEIGHT, MyDiceGame.mediumFont);
		LargeQ2Box = new MyCenteredTextBox ("2", LARGEQ2BOX_XPOS, LARGEQ2BOX_YPOS, LARGEQ2BOX_WIDTH, LARGEQ2BOX_HEIGHT, MyDiceGame.mediumFont);
		LargeQ3Box = new MyCenteredTextBox ("3", LARGEQ3BOX_XPOS, LARGEQ3BOX_YPOS, LARGEQ3BOX_WIDTH, LARGEQ3BOX_HEIGHT, MyDiceGame.mediumFont);
		LargeQ4Box = new MyCenteredTextBox ("4", LARGEQ4BOX_XPOS, LARGEQ4BOX_YPOS, LARGEQ4BOX_WIDTH, LARGEQ4BOX_HEIGHT, MyDiceGame.mediumFont);
		LargeQ5Box = new MyCenteredTextBox ("10", LARGEQ5BOX_XPOS, LARGEQ5BOX_YPOS, LARGEQ5BOX_WIDTH, LARGEQ5BOX_HEIGHT, MyDiceGame.mediumFont);

		QPromptBox = new MyCenteredTextBox ("Run of 4", QPROMPTBOX_XPOS, QPROMPTBOX_YPOS, QPROMPTBOX_WIDTH, QPROMPTBOX_HEIGHT, MyDiceGame.smallFont);
		RedeemBox = new MyCenteredTextBox ("Redeem Queue", REDEEMBOX_XPOS, REDEEMBOX_YPOS, REDEEMBOX_WIDTH, REDEEMBOX_HEIGHT, MyDiceGame.smallFont);

		PokerBox = new MyCenteredTextBox ("Poker Hands", POKERBOX_XPOS, POKERBOX_YPOS, POKERBOX_WIDTH, POKERBOX_HEIGHT, MyDiceGame.smallFont);
		HandsBox = new MyCenteredTextBox ("P", HANDSBOX_XPOS, HANDSBOX_YPOS, HANDSBOX_WIDTH, HANDSBOX_HEIGHT, MyDiceGame.smallFont);
		RulesBox = new MyCenteredTextBox ("View Rules", RULESBOX_XPOS, RULESBOX_YPOS, RULESBOX_WIDTH, RULESBOX_HEIGHT, MyDiceGame.smallFont);
		ExitBox = new MyCenteredTextBox ("Return to Main", EXITBOX_XPOS, EXITBOX_YPOS, EXITBOX_WIDTH, EXITBOX_HEIGHT, MyDiceGame.smallFont);
		C1c1Box = new MyCenteredTextBox ("Add to Your Score", C1C1BOX_XPOS, C1C1BOX_YPOS, C1C1BOX_WIDTH, C1C1BOX_HEIGHT, MyDiceGame.smallFont);
		C1c2Box = new MyCenteredTextBox ("Subtract Opponents'", C1C2BOX_XPOS, C1C2BOX_YPOS, C1C2BOX_WIDTH, C1C2BOX_HEIGHT, MyDiceGame.smallFont);		
		
		C2c1Box = new MyCenteredTextBox ("1", C2C1BOX_XPOS, C2C1BOX_YPOS, C2C1BOX_WIDTH, C2C1BOX_HEIGHT, MyDiceGame.smallFont);
		C2c2Box = new MyCenteredTextBox ("9", C2C2BOX_XPOS, C2C2BOX_YPOS, C2C2BOX_WIDTH, C2C2BOX_HEIGHT, MyDiceGame.smallFont);
		
		ConfirmBox = new MyCenteredTextBox ("Confirm", CONFIRMBOX_XPOS, CONFIRMBOX_YPOS, CONFIRMBOX_WIDTH, CONFIRMBOX_HEIGHT, MyDiceGame.smallFont);
		CancelBox = new MyCenteredTextBox ("Cancel", CANCELBOX_XPOS, CANCELBOX_YPOS, CANCELBOX_WIDTH, CANCELBOX_HEIGHT, MyDiceGame.smallFont);
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