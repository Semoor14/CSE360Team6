package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Displays player name and score 
 * @author Scott
 */
public class ScoreBox 
{
	/**
	 * The centered text box that displays the players name and score.
	 */
	private CenteredTextBox scoreBox; 
	
	/**
	 * Initializes a ScoreBox with the given score message, yMultiplier, and font for displaying text
	 * @param message The string message to show.
	 * @param YMultiplier How far down the screen the score should be.
	 * @param sFont The font to display the message and the score in.
	 */
	public ScoreBox(String message, int YMultiplier, TrueTypeFont sFont) // small Font
	{
		int YPosition = Place.SB_BOX1_YPOS + Place.SB_BOX_YCHANGE * YMultiplier;
		scoreBox = new CenteredTextBox(message, Place.SB_BOX_XPOS, YPosition, Place.SB_BOX_WIDTH, Place.SB_BOX_HEIGHT, sFont);
	}
	
	/**
	 * Renders the box by telling the inner box to render itself.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		scoreBox.render(gameContainer, game, g);
	}
	
	/**
	 * Returns the CenteredTextBox used by this score box to display the text.
	 * @return The CenteredTextBox used by this score box.
	 */
	public CenteredTextBox getBox()
	{
		return scoreBox;
	}
}

