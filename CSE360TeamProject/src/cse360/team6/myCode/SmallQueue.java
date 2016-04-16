package cse360.team6.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class SmallQueue 
{
	private int QBox1XPosition = 16;
	private int MySmallQueue1YPosition = 128;
	private int QBoxWidth = 32;
	private int QBoxHeight = 32;
	private int YPositionChange = 96;
	
	private CenteredTextBox QBox1;
	private CenteredTextBox QBox2;
	private CenteredTextBox QBox3;
	private CenteredTextBox QBox4;
	private CenteredTextBox QBox5;

	public SmallQueue(int YMultiplier, TrueTypeFont sFont)
	{
		int YPosition = MySmallQueue1YPosition + YPositionChange * YMultiplier;
		QBox1 = new CenteredTextBox("", QBox1XPosition, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox2 = new CenteredTextBox("", QBox1XPosition + QBoxWidth, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox3 = new CenteredTextBox("", QBox1XPosition + QBoxWidth * 2, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox4 = new CenteredTextBox("", QBox1XPosition + QBoxWidth * 3, YPosition, QBoxWidth, QBoxHeight, sFont);
		QBox5 = new CenteredTextBox("", QBox1XPosition + QBoxWidth * 4, YPosition, QBoxWidth, QBoxHeight, sFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		QBox1.render(gameContainer, game, g);
		QBox2.render(gameContainer, game, g);
		QBox3.render(gameContainer, game, g);
		QBox4.render(gameContainer, game, g);
		QBox5.render(gameContainer, game, g);
	}
	
	//In Small Queue
	public void changeAllBoxesText(int []que)
	{
			QBox5.SetText(que[0]+"");
			QBox4.SetText(que[1]+"");
			QBox3.SetText(que[2]+"");
			QBox2.SetText(que[3]+"");
			QBox1.SetText(que[4]+"");
		}
	//small queue
	public void invertSmallBoxes()
	{
		QBox5.InvertSelection();
		QBox4.InvertSelection();
		QBox3.InvertSelection();
		QBox2.InvertSelection();
		QBox1.InvertSelection();
	}
	
	
}
