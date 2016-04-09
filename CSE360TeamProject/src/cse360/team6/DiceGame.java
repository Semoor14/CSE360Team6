package cse360.team6;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DiceGame extends StateBasedGame
{
	public static final int MAIN = 0;
	public static final int SETUP = 1;
	public static final int RULES = 2;
	public static final int STATISTICS = 3;
	public static final int GAME = 4;
	
	public static void main (String[] args)
	{
		try
		{
			AppGameContainer gameContainer = new AppGameContainer(new DiceGame("37 Game"), 600, 600, false);
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
	public void initStatesList(GameContainer arg0) throws SlickException
	{
		// TODO Auto-generated method stub
		
	}

}
