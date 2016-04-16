package cse360.team6;
/**
 * The QueueAnalyzer class takes an array or 'Player Queue' and identifies whether or not the player has any available 
 * hands which they can redeem. The class constructor recieves a queue from the game state and outputs an enumeration with a
 * toString literal.
 * 
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
	 * @return que que array is returned as a descending sorted array
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
	
	public Hands isPair(int[] que)
	{		
		if(que[0]==que[1])
		{
			return Hands.PAIR;
		}
		else
		{
			return Hands.NONE;	
		}	
	}
	
	public Hands isThreeOfKind(int[] que)
	{
		if(que[0] == que[1] && que[0] == que[2])
		{
			return Hands.THREE_OF_KIND;
		}
		else
		{
			return Hands.NONE;
		}
	}
	
	public Hands isRunOfThree(int[] que)
	{
		if(que[2] == que[1]+1 && que[1] == que[0]+1)
		{
			return Hands.RUN_OF_THREE;
		}
		else 
		{
			return Hands.NONE;
		}
	}
	
	public Hands isFourOfKind(int[] que)
	{
		if(que[0] == que[1] && que[0] == que[2] && que[0]==que[3])
		{
			return Hands.FOUR_OF_KIND;
		}
		else 
		{
			return Hands.NONE;
		}
	}
	
	public Hands isTwoPair(int[] que)
	{
		if(que[0]==que[1] && que[2]==que[3])
		{	
			return Hands.TWO_PAIR;
		}
		else if(que[0]== que[2] && que[1] == que[3])
		{	
			return Hands.TWO_PAIR;
		}
		else if(que[0]== que[3] && que[1] == que[2])
		{	
			return Hands.TWO_PAIR;
		}
		else
		{
			return Hands.NONE;
		}
	}
	
	public Hands isRunOfFour(int[] que)
	{
		if(que[3] == que[2]+1 &&que[2] == que[1]+1 && que[1] == que[0]+1)
		{
			return Hands.RUN_OF_FOUR;
		}
		else 
		{
			return Hands.NONE;
		}
	}
	
	public Hands isRunOfFive(int[] que)
	{
		if(que[4] == que[3]+1 && que[3] == que[2]+1 && que[2] == que[1]+1 && que[1] == que[0]+1)
		{
			return Hands.RUN_OF_FIVE;
		}
		else 
		{
			return Hands.NONE;
		}
	}
	
	public Hands isFiveOfKind(int[] que)
	{
		if(que[0] == que[1] && que[0]== que[2] && que[0] == que[3] && que[0] == que[4])
		{
			return Hands.FIVE_OF_KIND;
		}
		else
		{
			return Hands.NONE;
		}
	}
}


