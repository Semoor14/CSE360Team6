package dice.game.myCode;
/**
 * This class is a state to read and display statistics using StatsReadWrite class
 * @author Nicholas Miller
 * @version 4/29/2016
 */
import org.newdawn.slick.*; 
import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, StatsReadWrite, CenteredTextButton, DiceGame   
public class StatisticsState extends ParentGameState 
{   
	private String stats; //string storing previous stats or message stating the lack of
	private CenteredTextButton exitButton;
	/**
	 * constructor
	 * @param sID
	 */
	public StatisticsState(int sID) 
	{ 
		super(sID); 
		
	}   
	/**
	 * method initially ran upon entering the StatisticsState
	 * initializes exitButton and stats
	 * @param gameContainer
	 * @param stateGame
	 * @param delta
	 * 
	 * @throws SlickException
	 */
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", 464, 432, 160, 32, DiceGame.smallFont);
		StatsReadWrite fileHandler = new StatsReadWrite(); 
		stats = "Statistics:\n";
		stats += fileHandler.getStats(); 
	}   
	/**
	 * render puts everything on the screen
	 * including exitButton and stats
	 * @param gameContainer
	 * @param stateGame
	 * @param delta
	 * 
	 * @throws SlickException
	 */
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		g.setFont (DiceGame.smallFont);
		String[] tokens = stats.split("\n");
		for(int i = 0; i<tokens.length; i++){
			g.drawString(tokens[i], 20F, i*25+20); 
		}
		
		exitButton.render(gameContainer, stateGame, g); 
	}   
	/**
	 * update method is used for when the exit button is pressed
	 * @param gameContainer
	 * @param stateGame
	 * @param delta
	 * 
	 * @throws SlickException
	 */
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
	/**
	 * detects if exit button specifically is pressed
	 * @param stateGame
	 * @param clickPositionX
	 * @param clickPositionY
	 */
	public void updateAlwaysClicking(StateBasedGame stateGame, int clickPositionX, int clickPositionY) 
	{ 
		if(exitButton.isWithinBound(clickPositionX, clickPositionY))
		{
			stateGame.enterState(DiceGame.MAIN);
		}
	} 
}