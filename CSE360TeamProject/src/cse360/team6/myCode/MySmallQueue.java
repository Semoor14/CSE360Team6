package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MySmallQueue 
{
	private int QBox1XPosition = 16;
	private int MySmallQueue1YPosition = 128;
	private int QBoxWidth = 32;
	private int QBoxHeight = 32;
	private int YPositionChange = 96;
	
	private MyCenteredTextBox QBox1;
	private MyCenteredTextBox QBox2;
	private MyCenteredTextBox QBox3;
	private MyCenteredTextBox QBox4;
	private MyCenteredTextBox QBox5;

	public MySmallQueue(int YMultiplier, TrueTypeFont sFont)
	{
		int YPosition = MySmallQueue1YPosition + YPositionChange * YMultiplier;
		QBox1 = new MyCenteredTextBox("", QBox1XPosition, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox2 = new MyCenteredTextBox("", QBox1XPosition + QBoxWidth, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox3 = new MyCenteredTextBox("", QBox1XPosition + QBoxWidth * 2, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox4 = new MyCenteredTextBox("", QBox1XPosition + QBoxWidth * 3, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox5 = new MyCenteredTextBox("", QBox1XPosition + QBoxWidth * 4, YPosition, QBoxWidth, QBoxHeight, sFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		QBox1.render(gameContainer, game, g);
		QBox2.render(gameContainer, game, g);
		QBox3.render(gameContainer, game, g);
		QBox4.render(gameContainer, game, g);
		QBox5.render(gameContainer, game, g);
	}
	
	
	
}
