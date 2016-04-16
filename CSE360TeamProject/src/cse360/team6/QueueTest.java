package cse360.team6;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void defaultConstructorTest() {
		Queue queue = new Queue();
		assertNotNull(queue);
	}
	
	@Test
	public void constructorTest() {
		Queue queue = new Queue(10);
		assertNotNull(queue);
	}

	@Test
	public void getSizeDefaultTest() {
		Queue queue = new Queue();
		assertEquals(5, queue.getSize());
	}
	
	@Test
	public void getSizeTest() {
		Queue queue = new Queue(7);
		assertEquals(7, queue.getSize());
	}
	
	@Test
	public void getNumElementsEmptyDefaultTest() {
		Queue queue = new Queue();
		assertEquals(0, queue.getNumElements());
	}
	
	@Test
	public void getNumElementsEmptyTest() {
		Queue queue = new Queue(12);
		assertEquals(0, queue.getNumElements());
	}
	
	@Test
	public void addValueEmptyDefaultTest() {
		Queue queue = new Queue();
		queue.addValue(5);
		int[] tempQueue = {0,0,0,0,5};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void addValueEmptyTest() {
		Queue queue = new Queue(10);
		queue.addValue(10);
		int[] tempQueue = {0,0,0,0,0,0,0,0,0,10};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void addValuePartialDefaultTest() {
		Queue queue = new Queue();
		queue.addValue(1);
		queue.addValue(2);
		queue.addValue(3);
		int[] tempQueue = {0,0,1,2,3};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void addValuePartialTest() {
		Queue queue = new Queue(10);
		queue.addValue(10);
		queue.addValue(9);
		queue.addValue(8);
		queue.addValue(7);
		queue.addValue(6);
		int[] tempQueue = {0,0,0,0,0,10,9,8,7,6};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void addValueFullDefaultTest() {
		Queue queue = new Queue();
		queue.addValue(1);
		queue.addValue(2);
		queue.addValue(3);
		queue.addValue(6);
		queue.addValue(5);
		queue.addValue(4);
		int[] tempQueue = {2,3,6,5,4};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void addValueFullTest() {
		Queue queue = new Queue(10);
		queue.addValue(10);
		queue.addValue(9);
		queue.addValue(8);
		queue.addValue(7);
		queue.addValue(6);
		queue.addValue(1);
		queue.addValue(2);
		queue.addValue(3);
		queue.addValue(4);
		queue.addValue(5);
		queue.addValue(10);
		int[] tempQueue = {9,8,7,6,1,2,3,4,5,10};
		assertArrayEquals(tempQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesEmptyDefault() {
		Queue queue = new Queue();
		int[] indexes = {0,1,2};
		queue.deleteValues(indexes);
		int[] testQueue = new int[5];
		assertArrayEquals(testQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesEmpty() {
		Queue queue = new Queue(10);
		int[] indexes = {0,2,4,8};
		queue.deleteValues(indexes);
		int[] testQueue = new int[10];
		assertArrayEquals(testQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesPartialDefault() {
		Queue queue = new Queue();
		queue.addValue(1);
		queue.addValue(2);
		queue.addValue(3);
		int[] indexes = {4,2,0};
		queue.deleteValues(indexes);
		int[] testQueue = {0,0,0,0,2};
		assertArrayEquals(testQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesPartial() {
		Queue queue = new Queue(7);
		queue.addValue(1);
		queue.addValue(3);
		queue.addValue(2);
		queue.addValue(5);
		queue.addValue(4);
		int[] indexes = {6,4,2,0};
		queue.deleteValues(indexes);
		int[] testQueue = {0,0,0,0,0,3,5};
		assertArrayEquals(testQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesFullDefault() {
		Queue queue = new Queue();
		queue.addValue(1);
		queue.addValue(2);
		queue.addValue(3);
		queue.addValue(4);
		queue.addValue(5);
		int[] indexes = {4,2,1};
		queue.deleteValues(indexes);
		int[] testQueue = {0,0,0,1,4};
		assertArrayEquals(testQueue, queue.getQueueValues());
	}
	
	@Test
	public void deleteValuesFull() {
		Queue queue = new Queue(9);
		queue.addValue(9);
		queue.addValue(8);
		queue.addValue(7);
		queue.addValue(6);
		queue.addValue(5);
		queue.addValue(4);
		queue.addValue(3);
		queue.addValue(2);
		queue.addValue(1);
		int[] indexes = {7,5,3,1};
		queue.deleteValues(indexes);
		int[] testQueue = {0,0,0,0,9,7,5,3,1};
		assertArrayEquals(testQueue, queue.getQueueValues());
	}

}
