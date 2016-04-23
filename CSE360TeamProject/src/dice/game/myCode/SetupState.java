package dice.game.myCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class SetupState extends ParentGameState
{	
	public SetupState (int sID)
	{
		super(sID);
	}

	@Override
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{
		super.enter(gameContainer, stateGame);
		
	}

	@Override
	public void render(GameContainer gamContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{
		g.drawString("Setup", 20, 20);
		
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
}