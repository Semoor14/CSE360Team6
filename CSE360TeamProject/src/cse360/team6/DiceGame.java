package cse360.team6;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The main class of the DiceBased game 36.
 * Comntains the main method and methods to initialize the game and its states.
 * @author Kyle Chapman
 */
public class DiceGame extends StateBasedGame
{
	//the IDs of the various gamestates
	public static final int MAIN = 0;
	public static final int SETUP = 1;
	public static final int RULES = 2;
	public static final int STATISTICS = 3;
	public static final int GAME_37 = 4;
	
	//the width, height, and target FPS of the game window
	public static final int WIDTH   = 640;
    public static final int HEIGHT  = 640;
    public static final int FPS     = 60;
    
    //global references to the three fonts used in the game
    public static TrueTypeFont smallFont;
    public static TrueTypeFont mediumFont;
    public static TrueTypeFont largeFont;
	
	public static void main (String[] args)
	{
		//makes a new AppGameContainer, sets its properties, and begins the game
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new DiceGame("37 Game"));
			gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			gameContainer.setTargetFrameRate(FPS);
			gameContainer.start();
		} catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a new DiceGame object.
	 * @param name The name of the game.
	 */
	public DiceGame(String name)
	{
		super(name);
	}

	/**
	 * Called by the Slick framework. Initializes the various states of the game.
	 * @param GameContainer the AppGameContainer window that contains our game.
	 */
	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException
	{
		this.addState(new MainMenuGameState(MAIN));
        this.addState(new SetupGameState(SETUP));
        this.addState(new RulesGameState(RULES));
        this.addState(new StatisticsGameState(STATISTICS));
        this.addState(new Game37GameState(GAME_37));
	}
}
