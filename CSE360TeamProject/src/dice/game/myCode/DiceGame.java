package dice.game.myCode;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;


public class DiceGame extends StateBasedGame 
{
	public static final int MAIN = 0;
	public static final int SETUP = 1;
	public static final int RULES = 2;
	public static final int STATISTICS = 3;
	public static final int GAME_37 = 4;
	
	
	public static final int WIDTH   = 640;
    public static final int HEIGHT  = 480;
    public static final int FPS     = 60;
    
    public static TrueTypeFont smallFont;
    public static TrueTypeFont mediumFont;
    public static TrueTypeFont largeFont;
    public static TrueTypeFont veryLargeFont;

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

    public static void main (String[] args)
	{
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new DiceGame("37 Game"));
			gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			gameContainer.setTargetFrameRate(FPS);
			gameContainer.setShowFPS(false);
			gameContainer.start();
		} catch (SlickException e)
		{
			e.printStackTrace();
		}
	}

	public DiceGame(String name)
	{
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException
	{
		this.addState(new MainMenuState(MAIN));
        this.addState(new SetupState(SETUP));
        this.addState(new RulesState(RULES));
        this.addState(new StatisticsState(STATISTICS));
        this.addState(new Game37State(GAME_37));
	}
	
}