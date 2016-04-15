package dice.game.myCode;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MyDiceGame extends StateBasedGame 
{
	// not used yet so commenting out
	//public static final int MAIN = 0;
	//public static final int SETUP = 1;
	//public static final int RULES = 2;
	//public static final int STATISTICS = 3;
	public static final int GAME_37 = 0; // will be 4
	public static final int TEST_37 = 0; // WON'T EXIST
	
	
	public static final int WIDTH   = 640;
    public static final int HEIGHT  = 480;
    public static final int FPS     = 60;
    
    public static TrueTypeFont smallFont;
    public static TrueTypeFont mediumFont;
    public static TrueTypeFont largeFont;

    public static void initializeFonts()
    {
		Font sFont = new Font("Arial", Font.PLAIN, 18);
		MyDiceGame.smallFont = new TrueTypeFont(sFont,false);
		
		Font mFont = new Font("Arial", Font.PLAIN, 26);
		MyDiceGame.mediumFont = new TrueTypeFont(mFont,false);
		
		Font lFont = new Font("Arial", Font.PLAIN, 40);
		MyDiceGame.largeFont = new TrueTypeFont(lFont,false);    	
    }
    
    /*
    public static MyCenteredTextBox createMyCenteredTextBox(String text, float XPercent, float YPercent, float WidthPercent, float HeightPercent, TrueTypeFont FontToUse)
    {
    	MyCenteredTextBox result;
		int boxWidth = (int)(WIDTH * WidthPercent);
    	int boxHeight = (int)(HEIGHT * HeightPercent);
		int boxX = (WIDTH - boxWidth)/2;
		int boxY = (HEIGHT - boxHeight)/2;
		boxX += WIDTH * XPercent;
		boxY += HEIGHT * YPercent;
		result = new MyCenteredTextBox(text, boxX, boxY, boxWidth, boxHeight, FontToUse);	
    	return result;
    }
    
    public static MyCenteredTextButton createMyCenteredTextButton(String text, float WidthPercent, float HeightPercent, float XPercent, float YPercent, TrueTypeFont FontToUse)
    {
    	MyCenteredTextButton result;
		int boxWidth = (int)(WIDTH * WidthPercent);
    	int boxHeight = (int)(HEIGHT * HeightPercent);
		int boxX = (WIDTH - boxWidth)/2;
		int boxY = (HEIGHT - boxHeight)/2;
		boxX += WIDTH * XPercent;
		boxY += HEIGHT * YPercent;
		result = new MyCenteredTextButton(text, boxX, boxY, boxWidth, boxHeight, FontToUse);	
    	return result;
    }
    */
    public static void main (String[] args)
	{
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new MyDiceGame("37 Game"));
			gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			gameContainer.setTargetFrameRate(FPS);
			gameContainer.setShowFPS(false);
			gameContainer.start();
		} catch (SlickException e)
		{
			e.printStackTrace();
		}
	}

	public MyDiceGame(String name)
	{
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException
	{
		// this.addState(new MainMenuGameState(MAIN));
        // this.addState(new SetupGameState(SETUP));
        // this.addState(new RulesGameState(RULES));
        // this.addState(new StatisticsGameState(STATISTICS));
		// this.addState(new My37GameState(GAME_37));
		// comment out line below to run test state instead of game state
        // this.addState(new My37GameState(GAME_37));
        this.addState(new My37TestState(TEST_37));
	}
	
}
