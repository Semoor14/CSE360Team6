package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MyScoreBox 
{
	private int ScoreBoxXPosition = 16;
	private int ScoreBox1YPosition = 96;
	private int ScoreBoxWidth = 160;
	private int ScoreBoxHeight = 32;
	private int ScoreBoxYChange = ScoreBoxHeight + 32 + 32; // QueueBoxWidth and

	private MyCenteredTextBox scoreBox; 
	
	public MyScoreBox(String message, int YMultiplier, TrueTypeFont sFont) // small Font
	{
		int YPosition = ScoreBox1YPosition + ScoreBoxYChange * YMultiplier;
		scoreBox = new MyCenteredTextBox(message, ScoreBoxXPosition, YPosition, ScoreBoxWidth, ScoreBoxHeight, sFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
	}	
	public MyCenteredTextBox getBox()
	{
		return scoreBox;
	}
}
