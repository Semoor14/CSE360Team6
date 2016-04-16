package cse360.team6;
/**
 * The QueueAnalyzer class takes an array or 'Player Queue' and identifies whether or not the player has any available 
 * hands which they can redeem. The class constructor recieves a queue from the game state and outputs an enumeration with a
 * toString literal.
 * @version 4/15/2016
 * @author Scott
 *
 */
public class QueueAnalyzer 
{
	/**
	 * Hands contains enumeration types for each hand. These enumeration types have string literals 
	 * which describe the hand and are used in other logic structures throughout our game. 
	 * 
	 * @author Scott
	 *
	 */
	public enum Hands
	{
		PAIR ("Pair"), THREE_OF_KIND ("Three of a Kind"), RUN_OF_THREE ("Run of Three"), FOUR_OF_KIND ("Four of a Kind"),
		TWO_PAIR ("Two Pair"), RUN_OF_FOUR ("Run of Four"), RUN_OF_FIVE ("Run of Five"), FIVE_OF_KIND ("Five of a Kind"), NONE ("None");
		
		private final String handName;
		
		private Hands(String name)
		{	
			handName = name;
		}
		
		public String toString() 
		{	
			return this.handName;
		}
	}
	
	/**
	 * Constructor QueueAnalyzer receives a que[] from the primary game state, which the player selects. The constructor then 
	 * sorts the que to be analyzed later.
	 *  
	 * @param que
	 */
	public QueueAnalyzer(int[] que)
	{
		int[] queAnalysis = QueueSort(que);		 
	}
	
	/**
	 * getNumElements takes a queue of unknown length and returns the number of elements in the queue
	 * 
	 * @param que
	 * @return que.length returns the number of elements in the que
	 */
	public int getNumElements(int[] que)
	{
		return que.length;
	}
	
	/**
	 * QueueSort takes an array and uses insertion sort to sort the array.
	 * 
	 * @param que
	 * @return que que array is returned as a ascending sorted array
	 */
	public int[] QueueSort(int[] que)
	{	
		int currentVal;
		
		int position;
		
		for(int index = 0; index < que.length; index++)
		{
			currentVal = que[index];
			
			position = index;
			
			while( position > 0 && que[position-1] > currentVal)
			{
				que[position] = que[position -1];
				
				position = position -1;
			}
			
			que[position] = currentVal;
			
		}
		
		return que;
	}
	
	/**
	 * handFinder takes in a queue array and a number of elements and checks whether or not the player has a hand 
	 * 
	 *  
	 * @param que
	 * @param elements
	 * @return
	 */
	public Hands handFinder(int[] que, int elements)
	{
		Hands hand = Hands.NONE;
		
		switch(elements)
		{
		case 1: elements = 1;
		
			hand = Hands.NONE;
			
		case 2: elements = 2;
		
			hand = isPair(que);
			
			break;
			
		case 3: elements = 3;
		
			if(isThreeOfKind(que)!= Hands.NONE)
			{
				hand = isThreeOfKind(que);
			}
			else if(isRunOfThree(que)!= Hands.NONE)
			{
				hand = isRunOfThree(que);
			}
			else
			{
				hand = Hands.NONE;
			}
			break;
			
		case 4: elements = 4;
		
			if(isFourOfKind(que)!= Hands.NONE)
			{
				hand = isFourOfKind(que);
			}
			else if(isTwoPair(que) != Hands.NONE)
			{
				hand = isTwoPair(que);
			}
			else if (isRunOfFour(que) != Hands.NONE)
			{
				hand = isRunOfFour(que);
			}
			else
			{
				hand = Hands.NONE;
			}
			break;
			
		case 5: elements = 5;
		
			if(isRunOfFive(que) != Hands.NONE)
			{
				hand = isRunOfFive(que);
			}
			else if(isFiveOfKind(que) != Hands.NONE)
			{
				hand = isFiveOfKind(que);
			}
			else
			{
				hand = Hands.NONE;
			}
			break;
		}	
		return hand;
	}
	/**
	 * isPair takes in a que and determines if a pair is available and returns an Enum Hands
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isPair(int[] que)
	{		
		Hands result = Hands.NONE;
		if(que[0] == que[1])
		{
			result = Hands.PAIR;
		}
		return result;	
	}
	/**
	 * isThreeOfKind takes in a que and determines if three of the same value exists returns an Enum Hands
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isThreeOfKind(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[0] == que[1] && que[0] == que[2])
		{
			result = Hands.THREE_OF_KIND;
		}
		return result;
	}
	/**
	 * isRunOfThree takes in a que and determines if the values are in rising consecutive orderailable and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isRunOfThree(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[2] == que[1] + 1 && que[1] == que[0] + 1)
		{
			result = Hands.RUN_OF_THREE;
		}
		return result;
	}
	/**
	 * isFourOfKind takes in a que and determines if the four values are the same and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isFourOfKind(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[0] == que[1] && que[0] == que[2] && que[0] == que[3])
		{
			result = Hands.FOUR_OF_KIND;
		}
		return result;
	}
	/**
	 * istwoPair takes in a que and determines if a two pairs exists and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isTwoPair(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[0] == que[1] && que[2] == que[3])
		{	
			result = Hands.TWO_PAIR;
		}
		else if(que[0] == que[2] && que[1] == que[3])
		{	
			result = Hands.TWO_PAIR;
		}
		else if(que[0] == que[3] && que[1] == que[2])
		{	
			result = Hands.TWO_PAIR;
		}
		return result;
	}
	/**
	 * isRunOfFour takes in a que and determines if four elements are in rising consecutive
	 *     order and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isRunOfFour(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[3] == que[2] + 1 && que[2] == que[1] + 1 && que[1] == que[0] + 1)
		{
			result = Hands.RUN_OF_FOUR;
		}
		return result;
	}
	/**
	 * isRunOfFive takes in a que and determines if five elements are in rising consecutive
	 *      order and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isRunOfFive(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[4] == que[3] + 1 && que[3] == que[2] + 1 && que[2] == que[1] + 1 && que[1] == que[0] + 1)
		{
			result = Hands.RUN_OF_FIVE;
		}
		return result;
	}
	/**
	 * isPair takes in a que and determines if five elements are equal and returns an Enum
	 * 
	 * @param que
	 * @return result
	 */
	public Hands isFiveOfKind(int[] que)
	{
		Hands result = Hands.NONE;
		if(que[0] == que[1] && que[0]== que[2] && que[0] == que[3] && que[0] == que[4])
		{
			result = Hands.FIVE_OF_KIND;
		}
		return result;
	}
}


