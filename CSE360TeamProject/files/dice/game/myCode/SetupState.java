package dice.game.myCode;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, CenteredTextButton, DiceGame   
public class SetupState extends ParentGameState 
{   
	private CenteredTextButton exitButton;
	private CenteredTextButton sumRuleButton; 
	
	public SetupState(int sID) 
	{ 
		super(sID); 
	}   
	
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", Place.SS_EXITBUTTON_XPOS, Place.SS_EXITBUTTON_YPOS, Place.SS_EXITBUTTON_WIDTH, Place.SS_EXITBUTTON_HEIGHT, DiceGame.smallFont);
		sumRuleButton = new CenteredTextButton("Sum Rule", Place.SS_SUMRULEBUTTON_XPOS, Place.SS_SUMRULEBUTTON_YPOS, Place.SS_SUMRULEBUTTON_WIDTH, Place.SS_SUMRULEBUTTON_HEIGHT, DiceGame.smallFont);
		if(DiceGame.sumRule)
		{
			sumRuleButton.SetSelected(true);
		}
	}
	
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		exitButton.render(gameContainer, stateGame, g);
		sumRuleButton.render(gameContainer, stateGame, g);
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
			if(sumRuleButton.GetSelected() == true)
			{
				DiceGame.sumRule = true;
			}
			stateGame.enterState(DiceGame.MAIN);
		}
		if(sumRuleButton.isWithinBound(clickPositionX, clickPositionY))
		{
			sumRuleButton.InvertSelection();
		}
	}    
}