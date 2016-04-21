package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class ScoreBox 
{
	private int ScoreBoxXPosition = 16;
	private int ScoreBox1YPosition = 96;
	private int ScoreBoxWidth = 160;
	private int ScoreBoxHeight = 32;
	private int ScoreBoxYChange = ScoreBoxHeight + 32 + 32; // QueueBoxWidth and

	private CenteredTextBox scoreBox; 
	
	public ScoreBox(String message, int YMultiplier, TrueTypeFont sFont) // small Font
	{
		int YPosition = Place.SB_BOX1_YPOS + + Place.SB_BOX_YCHANGE * YMultiplier;
		scoreBox = new CenteredTextBox(message, Place.SB_BOX_XPOS, YPosition, Place.SB_BOX_WIDTH, Place.SB_BOX_HEIGHT, sFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
	}	
	public CenteredTextBox getBox()
	{
		return scoreBox;
	}
}

