package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.LargeQueue;
import dice.game.myCode.Place;

public class LargeQueueTest {
	
	@Test
	public void largeQueueConstructorTest()
	{
		LargeQueue lQueue = new LargeQueue(null);
		assertNotNull(lQueue);
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
	
	@Test
	public void getSelectedValuesTest()
	{
		LargeQueue lQueue = new LargeQueue(null);
		int[] values = lQueue.getSelectedValues();
		assertEquals(values.length, 0);
		
		lQueue.setValues(new int[]{1,2,3,4,5});
		boolean result = lQueue.isWithinBound(Place.LQ_BUTTON1_XPOS+3, Place.LQ_BUTTON_YPOS+3);
		assertTrue(result);
		
		values = lQueue.getSelectedValues();
		assertEquals(values.length, 1);
		assertEquals(values[0], 5);
	}
	
	@Test
	public void getSelectedIndexesTest()
	{
		LargeQueue lQueue = new LargeQueue(null);
		int[] values = lQueue.getSelectedIndexes();
		assertEquals(values.length, 0);
		
		lQueue.setValues(new int[]{1,2,3,4,5});
		boolean result = lQueue.isWithinBound(Place.LQ_BUTTON1_XPOS+3, Place.LQ_BUTTON_YPOS+3);
		assertTrue(result);
		
		values = lQueue.getSelectedIndexes();
		assertEquals(values.length, 1);
		assertEquals(values[0], 4);
	}
	
	@Test
	public void resetSelectionTest ()
	{
		LargeQueue lQueue = new LargeQueue(null);
		
		lQueue.setValues(new int[]{1,2,3,4,5});
		for (int i = 0;i<5;i++)
		{
			boolean result = lQueue.isWithinBound(Place.LQ_BUTTON1_XPOS+Place.LQ_BUTTON_WIDTH*i+3, Place.LQ_BUTTON_YPOS+3);
			assertTrue(result);
		}
		
		int[] values = lQueue.getSelectedIndexes();
		assertEquals(values.length, 5);
		
		for (int i = 0;i<values.length;i++)
		{
			assertEquals(values[i], i);
		}
		
		lQueue.resetSelections();
		
		values = lQueue.getSelectedIndexes();
		assertEquals(values.length, 0);
	}
}
