package cse360.team6;

public class QueueAnalyzer 
{
	public enum Hands{
		PAIR, THREE_OF_KIND, RUN_OF_THREE, FOUR_OF_KIND,
		TWO_PAIR, RUN_OF_FOUR, RUN_OF_FIVE, FIVE_OF_KIND, NONE
	}

	public QueueAnalyzer(int[] que)
	{
		int[] queAnalysis = QueueSort(que);
		
		int numElements = queAnalysis.length;
		 
		handFinder(queAnalysis,numElements);
	}
	
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
			System.out.println("pair");
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
			return Hands.RUN_OF_FOUR;
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


