package cse360.team6;

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
    public static final int HEIGHT  = 640;
    public static final int FPS     = 60;
    
    public static TrueTypeFont smallFont;
    public static TrueTypeFont mediumFont;
    public static TrueTypeFont largeFont;
	
	public static void main (String[] args)
	{
	
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new DiceGame("37 Game"));
			gameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			gameContainer.setTargetFrameRate(FPS);
			gameContainer.setShowFPS(true);
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
		this.addState(new MainMenuGameState(MAIN));
        this.addState(new SetupGameState(SETUP));
        this.addState(new RulesGameState(RULES));
        this.addState(new StatisticsGameState(STATISTICS));
        this.addState(new Game37GameState(GAME_37));
	}

}
