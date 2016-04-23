package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class SmallQueue 
{	
	private CenteredTextBox QBox1;
	private CenteredTextBox QBox2;
	private CenteredTextBox QBox3;
	private CenteredTextBox QBox4;
	private CenteredTextBox QBox5;

	public SmallQueue(int YMultiplier, TrueTypeFont sFont)
	{
		int YPosition = Place.SQ_BOX1_YPOS + Place.SQ_BOX_YCHANGE * YMultiplier;
		QBox1 = new CenteredTextBox("", Place.SQ_BOX1_XPOS, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox2 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox3 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*2, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);		
		QBox4 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*3, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);
		QBox5 = new CenteredTextBox("", Place.SQ_BOX1_XPOS + Place.SQ_BOX_WIDTH*4, YPosition, Place.SQ_BOX_WIDTH, Place.SQ_BOX_HEIGHT, sFont);		
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