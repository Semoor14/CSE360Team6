package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.QueueAnalyzer;

public class QueueAnalyzerTest {

	public enum Hands{
		PAIR, THREE_OF_KIND, RUN_OF_THREE, FOUR_OF_KIND,
		TWO_PAIR, RUN_OF_FOUR, RUN_OF_FIVE, FIVE_OF_KIND, NONE
	}
	
	QueueAnalyzer.Hands hand;
	
	@Test
	public void testConstructor()
	{
		int [] queueToBeAnalyzed = {3,2,4,1};
	
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		assertNotNull(analyzer);
	}
	
	public void testOneElement()
	{
		int [] queueToBeAnalyzed = {2};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.NONE);
		
		
	}
	
	@Test
	public void testIsPair()
	{
		
		int [] queueToBeAnalyzed = {2,2};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.PAIR);
	}
	
	@Test 
	public void testIsNotHandOfTwo()
	{
		int [] queueToBeAnalyzed = {2,1};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.NONE);
	}
	
	@Test
	public void testIsRunOfThree()
	{
		int [] queueToBeAnalyzed = {2,3,1};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.RUN_OF_THREE);
	}
	
	@Test
	public void testIsNotHandOfThree()
	{
		int [] queueToBeAnalyzed = {1,3,4};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.NONE);	
	}

	@Test
	public void testIsThreeOfKind()
	{
		int [] queueToBeAnalyzed = {1,1,1};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.THREE_OF_KIND);
	}
	
	@Test
	public void testIsNotHandOfFour()
	{
		int [] queueToBeAnalyzed = {1,3,5,2};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.NONE);	
		
	}
	
	@Test
	public void testIsRunOfFour()
	{
		int [] queueToBeAnalyzed = {1,3,4,2};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.RUN_OF_FOUR);
		
	}
	
	@Test
	public void testIsFourOfKind()
	{
		int [] queueToBeAnalyzed = {1,1,1,1};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.FOUR_OF_KIND);
		
	}
	
	@Test
	public void testIsNotHandOfFive()
	{
		int [] queueToBeAnalyzed = {1,1,1,2,4};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.NONE);
		
	}
	
	@Test
	public void testIsRunOfFive()
	{
		int [] queueToBeAnalyzed = {1,2,3,5,4};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.RUN_OF_FIVE);
		
	}
	
	@Test
	public void testIsFiveOfKind()
	{
		int [] queueToBeAnalyzed = {4,4,4,4,4};
		
		QueueAnalyzer analyzer = new QueueAnalyzer(queueToBeAnalyzed);
		
		hand = analyzer.handFinder();
		
		assertEquals(hand,QueueAnalyzer.Hands.FIVE_OF_KIND);
		
	}
	
	@Test
	public void testToStringPair()
	{ 	
		assertEquals(QueueAnalyzer.Hands.PAIR.toString(),"Pair");
	}
	
	@Test
	public void testToStringNone()
	{ 	
		assertEquals(QueueAnalyzer.Hands.NONE.toString(),"None");
	}
	
	@Test
	public void testToStringThreeOfKind()
	{ 	
		assertEquals(QueueAnalyzer.Hands.THREE_OF_KIND.toString(),"Three of a Kind");
	}
	
	@Test
	public void testToStringRunOfThree()
	{ 	
		assertEquals(QueueAnalyzer.Hands.RUN_OF_THREE.toString(),"Run of Three");
	}
	
	@Test
	public void testToStringFourOfKind()
	{ 	
		assertEquals(QueueAnalyzer.Hands.FOUR_OF_KIND.toString(),"Four of a Kind");
	}
	
	@Test
	public void testToStringRunOfFour()
	{ 	
		assertEquals(QueueAnalyzer.Hands.RUN_OF_FOUR.toString(),"Run of Four");
	}
	
	@Test
	public void testToStringFiveOfKind()
	{ 	
		assertEquals(QueueAnalyzer.Hands.FIVE_OF_KIND.toString(),"Five of a Kind");
	}
	
	@Test
	public void testToStringRunOfFive()
	{ 	
		assertEquals(QueueAnalyzer.Hands.RUN_OF_FIVE.toString(),"Run of Five");
	}
	
}
