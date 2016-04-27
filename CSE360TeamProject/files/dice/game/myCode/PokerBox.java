package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class PokerBox 
{		
	//P,R3,R4,R5,3K,4K,5K
	private final String PAIR_TEXT = "P-"; 
	private final String RUN_THREE_TEXT = "R3-";
	private final String RUN_FOUR_TEXT = "R4-";
	private final String RUN_FIVE_TEXT = "R5-";
	private final String THREE_KIND_TEXT = "3K-";
	private final String FOUR_KIND_TEXT = "4K-";
	private final String FIVE_KIND_TEXT = "5K-";
	//private final String TWO_PAIR_TEXT = "2P-";
	//private final String FULL_HOUSE_TEXT = "FH-";

	
	private CenteredTextBox smallBox;
	// always keep empty, its just a box
	private CenteredTextBox largeBox;
	
	public PokerBox(TrueTypeFont smallFont)
	{
		//centered text box 'poker hand'	
		smallBox = new CenteredTextBox("Poker Hands",Place.PB_BOX_XPOS, Place.PB_SMALLBOX_YPOS, Place.PB_BOX_WIDTH, Place.PB_SMALLBOX_HEIGHT,smallFont);
		largeBox = new CenteredTextBox("P", Place.PB_BOX_XPOS, Place.PB_LARGEBOX_YPOS, Place.PB_BOX_WIDTH, Place.PB_LARGEBOX_HEIGHT, smallFont);
	}
	
	public void render(GameContainer gameContainer, StateBasedGame game, Graphics g)
	{
		smallBox.render(gameContainer, game, g);
		largeBox.render(gameContainer, game, g);
	}
}