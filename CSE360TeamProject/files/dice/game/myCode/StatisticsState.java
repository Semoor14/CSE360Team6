package dice.game.myCode;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, StatsReadWrite, CenteredTextButton, DiceGame   
public class StatisticsState extends ParentGameState 
{   
	private String stats; 
	private CenteredTextButton exitButton;
	
	public StatisticsState(int sID) 
	{ 
		super(sID); 
		StatsReadWrite fileHandler = new StatsReadWrite(); 
		stats = fileHandler.getStats(); 
	}   
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", 464, 432, 160, 32, DiceGame.smallFont); 
	}   
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		g.setFont (DiceGame.smallFont);
		g.drawString((new StringBuilder("Stats:\n")).append(stats).toString(), 20F, 20F); 
		exitButton.render(gameContainer, stateGame, g); 
	}   
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int delta) throws SlickException 
	{ 
		Input input = gameContainer.getInput(); 
		if(input.isMousePressed(0)) 
		{ 
			int mouseX = input.getMouseX(); 
			int mouseY = input.getMouseY(); 
			updateAlwaysClicking(stateGame, mouseX, mouseY); 
			} 
		}   
	public void updateAlwaysClicking(StateBasedGame stateGame, int clickPositionX, int clickPositionY) 
	{ 
		if(exitButton.isWithinBound(clickPositionX, clickPositionY))
		{
			stateGame.enterState(DiceGame.MAIN);
		}
	} 
}