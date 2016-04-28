package dice.game.myCode;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, CenteredTextButton, DiceGame   
public class SetupState extends ParentGameState 
{   
	private CenteredTextButton exitButton;
	private CenteredTextButton sumRuleButton; 
	private CenteredTextButton doublesRuleButton;
	private CenteredTextBox titleBox;
	
	public SetupState(int sID) 
	{ 
		super(sID); 
	}   
	
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", Place.SS_EXITBUTTON_XPOS, Place.SS_EXITBUTTON_YPOS, Place.SS_EXITBUTTON_WIDTH, Place.SS_EXITBUTTON_HEIGHT, DiceGame.smallFont);
		sumRuleButton = new CenteredTextButton("Sum Rule", Place.SS_SUMRULEBUTTON_XPOS, Place.SS_SUMRULEBUTTON_YPOS, Place.SS_SUMRULEBUTTON_WIDTH, Place.SS_SUMRULEBUTTON_HEIGHT, DiceGame.mediumFont);
		titleBox = new CenteredTextBox("Choose Rules", Place.SS_TITLEBOX_XPOS, Place.SS_TITLEBOX_YPOS, Place.SS_TITLEBOX_WIDTH, Place.SS_TITLEBOX_HEIGHT, DiceGame.mediumFont);
		if(DiceGame.sumRule)
		{
			sumRuleButton.SetSelected(true);
		}
		
		doublesRuleButton = new CenteredTextButton("Doubles Rule", Place.SS_DOUBLESRULEBUTTON_XPOS, Place.SS_DOUBLESRULEBUTTON_YPOS, Place.SS_DOUBLESRULEBUTTON_WIDTH, Place.SS_DOUBLESRULEBUTTON_HEIGHT, DiceGame.mediumFont);
		if(DiceGame.doublesRule)
		{
			doublesRuleButton.SetSelected(true);
		}
	}
	
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		exitButton.render(gameContainer, stateGame, g);
		sumRuleButton.render(gameContainer, stateGame, g);
		doublesRuleButton.render(gameContainer, stateGame, g);
		titleBox.render(gameContainer, stateGame, g);
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
			else // sumRuleButton.GetSelected() == false
			{
				DiceGame.sumRule = false;
			}
			
			if(doublesRuleButton.GetSelected() == true)
			{
				DiceGame.doublesRule = true;
			}
			else // doublesRuleButton.GetSelected() == false
			{
				DiceGame.doublesRule = false;
			}
			stateGame.enterState(DiceGame.MAIN);
		}
		if(sumRuleButton.isWithinBound(clickPositionX, clickPositionY))
		{
			sumRuleButton.InvertSelection();
		}
		if(doublesRuleButton.isWithinBound(clickPositionX, clickPositionY))
		{
			doublesRuleButton.InvertSelection();
		}

	}    
}