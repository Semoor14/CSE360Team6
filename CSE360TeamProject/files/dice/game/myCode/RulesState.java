package dice.game.myCode;

import org.newdawn.slick.*; import org.newdawn.slick.state.StateBasedGame;   
// Referenced classes of package dice.game.myCode: 
// ParentGameState, CenteredTextButton, DiceGame, ReadRules   
public class RulesState extends ParentGameState 
{
	private CenteredTextButton exitButton; 
	private String rules; 
	
	public RulesState(int sID) 
	{
		super(sID); 
	}   
	
	public void enter(GameContainer gameContainer, StateBasedGame stateGame) throws SlickException 
	{ 
		super.enter(gameContainer, stateGame); 
		exitButton = new CenteredTextButton("Return to Main", 464, 432, 160, 32, DiceGame.smallFont); 
		rules = ReadRules.read(); 
	}   
	public void render(GameContainer gameContainer, StateBasedGame stateGame, Graphics g) throws SlickException 
	{ 
		g.drawString(rules, 20F, 20F); 
		exitButton.render(gameContainer, stateGame, g); 
	}   
	
	public void update(GameContainer gameContainer, StateBasedGame stateGame, int arg2) throws SlickException 
	{ 
		Input input = gameContainer.getInput(); if(input.isMousePressed(0)) 
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

