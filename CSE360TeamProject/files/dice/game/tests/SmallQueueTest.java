package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.SmallQueue;
import dice.game.myCode.LargeQueue;
import dice.game.myCode.Place;

public class SmallQueueTest {
	
	@Test
	public void SmalsQueueConstructorTest()
	{
		SmallQueue sQueue = new SmallQueue(1, null);
		assertNotNull(sQueue);
	}
	
	@Test
	public void getBooleanSelectedIndexTest()
	{
		LargeQueue lQueue = new LargeQueue(null);
		boolean[] values = lQueue.getBooleanSelectedIndexes();
		assertEquals(values.length, 5);
		
		for (int i = 0;i<values.length;i++)
		{
			assertFalse(values[i]);
		}
		
		lQueue.setValues(new int[]{1,2,3,4,5});
		boolean result = lQueue.isWithinBound(Place.LQ_BUTTON1_XPOS+3, Place.LQ_BUTTON_YPOS+3);
		assertTrue(result);
		values = lQueue.getBooleanSelectedIndexes();
		assertTrue(values[4]);
		
		for (int i = 0;i<values.length-1;i++)
		{
			assertFalse(values[i]);
		}
	}
}
