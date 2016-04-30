package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A box containing text about the effect of redeeming a certain kind of poker hand.
 * @author Nicholas Stanton and Scott Moore
 */
public class PokerBox 
{		
	/**
	 * The different texts for each kind of hand.
	 */
	private final String PAIR_TEXT = "P: Skip"; 
	private final String RUN_THREE_TEXT = "R3: Q+new3";
	private final String RUN_FOUR_TEXT = "R4: Q+new4,";
	private final String RUN_FOUR_TEXT_2 = "OpQ+other4";
	private final String RUN_FIVE_TEXT = "R5: Q+new5,";
	private final String RUN_FIVE_TEXT_2 = "OpQ deleted";
	private final String THREE_KIND_TEXT = "3K: S+X,";
	private final String THREE_KIND_TEXT_2 = "OpS-(3-X),Skip";
	private final String FOUR_KIND_TEXT = "4K: S+X*Y,";
	private final String FOUR_KIND_TEXT_2 = "OpS-(6-X*Y),Extra";
	private final String FIVE_KIND_TEXT = "5K: Win";
	
	/**
	 * The different smaller boxes making up the box.
	 */
	private CenteredTextBox smallBox;
	private CenteredTextBox largeBox;
	
	/**
	 * The font the strings display in.
	 */
	private TrueTypeFont stringFont;
	
	/**
	 * Initializes the PokerBox with all its different text lines.
	 * @param smallFont The font to display the text in.
	 */
	public PokerBox(TrueTypeFont smallFont)
	{
		//centered text box 'poker hand'	
		smallBox = new CenteredTextBox("Poker Hands",Place.PB_BOX_XPOS, Place.PB_SMALLBOX_YPOS, Place.PB_BOX_WIDTH, Place.PB_SMALLBOX_HEIGHT,smallFont);
		largeBox = new CenteredTextBox("", Place.PB_BOX_XPOS, Place.PB_LARGEBOX_YPOS, Place.PB_BOX_WIDTH, Place.PB_LARGEBOX_HEIGHT, smallFont);
		stringFont = smallFont;
	}
	
	/**
	 * Renders the different boxes of the pokerbox.
	 * @param gameContainer The container for the whole game.
	 * @param game The StateBasedGame handler.
	 * @param g The graphics object.
	 */
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		smallBox.render(gameContainer, game, g);
		largeBox.render(gameContainer, game, g);
		g.setFont(stringFont);
		int xPos = Place.PB_BOX_XPOS + Place.PB_STRING_XSPACING;
		int yPos =  Place.PB_LARGEBOX_YPOS+ Place.PB_STRING_YSPACING;
		g.drawString(PAIR_TEXT, xPos, yPos);
		g.drawString(RUN_THREE_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE);
		g.drawString(RUN_FOUR_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE*2);
		g.drawString(RUN_FOUR_TEXT_2, xPos, yPos + Place.PB_STRING_YDIFFERENCE*3);
		g.drawString(RUN_FIVE_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE*4);
		g.drawString(RUN_FIVE_TEXT_2, xPos, yPos + Place.PB_STRING_YDIFFERENCE*5);
		g.drawString(THREE_KIND_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE*6);
		g.drawString(THREE_KIND_TEXT_2, xPos, yPos + Place.PB_STRING_YDIFFERENCE*7);
		g.drawString(FOUR_KIND_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE*8);
		g.drawString(FOUR_KIND_TEXT_2, xPos, yPos + Place.PB_STRING_YDIFFERENCE*9);
		g.drawString(FIVE_KIND_TEXT, xPos, yPos + Place.PB_STRING_YDIFFERENCE*10);
	}
}