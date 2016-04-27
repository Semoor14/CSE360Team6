package dice.game.myCode;

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
	public static final int GAME_59 = 4;
	
	//the width, height, and target FPS of the game window
	public static final int WIDTH   = 640;
    public static final int HEIGHT  = 480;
    public static final int FPS     = 60;
        
    //global references to the three fonts used in the game
    public static TrueTypeFont smallFont;
    public static TrueTypeFont mediumFont;
    public static TrueTypeFont largeFont;
    public static TrueTypeFont veryLargeFont;
    
    // variables for scoring
    public static final int NUM_TO_WIN = 59;
    public static int SUM_NUM_TO_WIN = 163;

    // variables for variant rules
    public static boolean sumRule;
    
    /** 
     * initializes font variables to font type
     */
    public static void initializeFonts()
    {
		Font sFont = new Font("Arial", Font.PLAIN, 18);
		DiceGame.smallFont = new TrueTypeFont(sFont,false);
		
		Font mFont = new Font("Arial", Font.PLAIN, 26);
		DiceGame.mediumFont = new TrueTypeFont(mFont,false);
		
		Font lFont = new Font("Arial", Font.PLAIN, 40);
		DiceGame.largeFont = new TrueTypeFont(lFont,false);
		
		Font vlFont = new Font("Arial", Font.PLAIN, 60);
		DiceGame.veryLargeFont = new TrueTypeFont(vlFont,false);
    }
    /**
     * Runs game sets variables width, height of container, as well as frame rates
     * catche slick exceptions 
     * @param args
     */
    public static void main (String[] args)
	{
    	//makes a new AppGameContainer, sets its properties, and begins the game
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new DiceGame("59 Game"));
			gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			gameContainer.setTargetFrameRate(FPS);
			gameContainer.setShowFPS(false);
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
	    sumRule = false;
		
	}
	
	/**
	 * Called by the Slick framework. Initializes the various states of the game.
	 * @param GameContainer the AppGameContainer window that contains our game.
	 */
	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException
	{
		this.addState(new MainMenuState(MAIN));
        this.addState(new SetupState(SETUP));
        this.addState(new RulesState(RULES));
        this.addState(new StatisticsState(STATISTICS));
        this.addState(new Game59State(GAME_59));
	}
	
}