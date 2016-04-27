package dice.game.myCode;

// class for all coordinates
/**
 * Contains place holder for all coordinates in all states of the game by pixel count.
 * @author Scott
 */
public class Place 
{
	// GameState
	public static final int GS_ENDTURNROLLDIECONFIRM_XPOS = 412;
	public static final int GS_ENDTURNROLLDIECONFIRM_YPOS = 32;
	public static final int GS_ENDTURNROLLDIECONFIRM_WIDTH = 112;
	public static final int GS_ENDTURNROLLDIECONFIRM_HEIGHT = 32;
	
	public static final int GS_QPROMPTBOX_XPOS = 232;
	public static final int GS_QPROMPTBOX_YPOS = 152;
	public static final int GS_QPROMPTBOX_WIDTH = 176;
	public static final int GS_QPROMPTBOX_HEIGHT = 32;	
	
	public static final int GS_REDEEMBUTTON_XPOS = 232;
	public static final int GS_REDEEMBUTTON_YPOS = 192; 
	public static final int GS_REDEEMBUTTON_WIDTH = 176;
	public static final int GS_REDEEMBUTTON_HEIGHT = 32;

	public static final int GS_RULESBUTTON_XPOS = 464;
	public static final int GS_RULESBUTTON_YPOS = 392;
	public static final int GS_RULESBUTTON_WIDTH = 160;
	public static final int GS_RULESBUTTON_HEIGHT = 32;

	public static final int GS_EXITBUTTON_XPOS = 464;
	public static final int GS_EXITBUTTON_YPOS = 432;
	public static final int GS_EXITBUTTON_WIDTH = 160;
	public static final int GS_EXITBUTTON_HEIGHT = 32;

	public static final int GS_FINISHEDREDEEMBOX_XPOS = 208;
	public static final int GS_FINISHEDREDEEMBOX_YPOS = 96;
	public static final int GS_FINISHEDREDEEMBOX_WIDTH = 224;
	public static final int GS_FINISHEDREDEEMBOX_HEIGHT = 32;

	public static final int GS_WHOWONTHEGAMEBOX_XPOS = 0;
	public static final int GS_WHOWONTHEGAMEBOX_YPOS = 0;
	public static final int GS_WHOWONTHEGAMEBOX_WIDTH = 640;
	public static final int GS_WHOWONTHEGAMEBOX_HEIGHT = 480;
	
	public static final int GS_CONFIRMCANCELLIST_XPOS = 232;
	public static final int GS_CONFIRMCANCELLIST_YPOS = 400;
	public static final int GS_CONFIRMCANCELLIST_WIDTH = 176;
	public static final int GS_CONFIRMCANCELLIST_HEIGHT = 64;

	public static final int GS_RUNDIECONFIRMBUTTON_XPOS = 232;
	public static final int GS_RUNDIECONFIRMBUTTON_YPOS = 280;
	public static final int GS_RUNDIECONFIRMBUTTON_WIDTH = 176;
	public static final int GS_RUNDIECONFIRMBUTTON_HEIGHT = 32;
	
	public static final int GS_THREEOFKINDLIST_XPOS = 232;
	public static final int GS_THREEOFKINDLIST_YPOS = 192; 
	public static final int GS_THREEOFKINDLIST_WIDTH = 176;
	public static final int GS_THREEOFKINDLIST_HEIGHT = 128;
	
	public static final int GS_FOUROFKINDGROUP_XPOS = 232;
	public static final int GS_FOUROFKINDGROUP_YPOS = 192; 
	public static final int GS_FOUROFKINDGROUP_WIDTH = 176;
	public static final int GS_FOUROFKINDGROUP_ELEMENTHEIGHT = 32;
	public static final int GS_FOUROFKINDGROUP_ELEMENTSPACING = 8;
	
	public static final int GS_SUMDIFFERENCE_XPOS = 64;
	public static final int GS_SUMDIFFERENCE_YPOS = 32;
	public static final int GS_SUMDIFFERENCE_WIDTH = 64;
	public static final int GS_SUMDIFFERENCE_HEIGHT = 32;

	// DiceHandler
	public static final int DH_DIE1BUTTON_XPOS = 248;
	public static final int DH_DIE2BUTTON_XPOS = 328;
	// main YPos
	public static final int DH_MAINDIEBUTTON_YPOS = 16;
	// run YPos
	public static final int DH_RUNDIEBUTTON_YPOS = 184+16; // 208
	public static final int DH_DIEBUTTON_WIDTH = 64;
	public static final int DH_DIEBUTTON_HEIGHT = 64;
	
	// LargeQueue
	public static final int LQ_BUTTON1_XPOS = 200;
	public static final int LQ_BUTTON_YPOS = 96;
	public static final int LQ_BUTTON_WIDTH = 48;
	public static final int LQ_BUTTON_HEIGHT = 48;
	
	// ScoreBox
	public static final int SB_BOX_XPOS = 16;
	public static final int SB_BOX1_YPOS = 96;
	public static final int SB_BOX_WIDTH = 160;
	public static final int SB_BOX_HEIGHT = 32;
	public static final int SB_BOX_YCHANGE = 96;
	
	// SmallQueue
	public static final int SQ_BOX1_XPOS = 16;
	public static final int SQ_BOX1_YPOS = 128;
	public static final int SQ_BOX_WIDTH = 32;
	public static final int SQ_BOX_HEIGHT = 32;
	public static final int SQ_BOX_YCHANGE = 96;
	
	// PokerBox
	public static final int PB_BOX_XPOS = 464;
	public static final int PB_SMALLBOX_YPOS = 128;
	public static final int PB_BOX_WIDTH = 160;
	public static final int PB_SMALLBOX_HEIGHT = 32;
	public static final int PB_LARGEBOX_YPOS = 128+32;
	public static final int PB_LARGEBOX_HEIGHT = 256-32;
	
	// MainMenuState
	public static final int MS_GAMENAMEBOX_XPOS = 272;
	public static final int MS_GAMENAMEBOX_YPOS = 48;
	public static final int MS_GAMENAMEBOX_WIDTH = 96;
	public static final int MS_GAMENAMEBOX_HEIGHT = 64;	
	
	public static final int MS_GAMESTARTBUTTON_XPOS = 224;
	public static final int MS_GAMESTARTBUTTON_YPOS = 144;
	public static final int MS_GAMESTARTBUTTON_WIDTH = 192;
	public static final int MS_GAMESTARTBUTTON_HEIGHT = 48;	

	public static final int MS_GAMESETUPBUTTON_XPOS = 224;
	public static final int MS_GAMESETUPBUTTON_YPOS = 144+64;
	public static final int MS_GAMESETUPBUTTON_WIDTH = 192;
	public static final int MS_GAMESETUPBUTTON_HEIGHT = 48;	

	public static final int MS_GAMERULESBUTTON_XPOS = 224;
	public static final int MS_GAMERULESBUTTON_YPOS = 144+128;
	public static final int MS_GAMERULESBUTTON_WIDTH = 192;
	public static final int MS_GAMERULESBUTTON_HEIGHT = 48;	

	public static final int MS_GAMESTATISTICSBUTTON_XPOS = 224;
	public static final int MS_GAMESTATISTICSBUTTON_YPOS = 144+192;
	public static final int MS_GAMESTATISTICSBUTTON_WIDTH = 192;
	public static final int MS_GAMESTATISTICSBUTTON_HEIGHT = 48;	

	public static final int MS_GAMEEXITBUTTON_XPOS = 224;
	public static final int MS_GAMEEXITBUTTON_YPOS = 144+256;
	public static final int MS_GAMEEXITBUTTON_WIDTH = 192;
	public static final int MS_GAMEEXITBUTTON_HEIGHT = 48;	
	
	// Setup State
	public static final int SS_EXITBUTTON_XPOS = 464;
	public static final int SS_EXITBUTTON_YPOS = 432;
	public static final int SS_EXITBUTTON_WIDTH = 160;
	public static final int SS_EXITBUTTON_HEIGHT = 32;
	
	public static final int SS_SUMRULEBUTTON_XPOS = 120;
	public static final int SS_SUMRULEBUTTON_YPOS = 120;
	public static final int SS_SUMRULEBUTTON_WIDTH = 160;
	public static final int SS_SUMRULEBUTTON_HEIGHT = 32;

	
	
	

	
}
