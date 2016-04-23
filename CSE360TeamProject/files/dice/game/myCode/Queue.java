package dice.game.myCode;

/**
 * A numerical Queue.
 * @author Edward Borroughs
 */
public class Queue 
{
	private int [] queueValues; 
	private int numElements;
	private int size; 
	
	/**
	 * Constructs a Queue of the default size which is 5.
	 */
	public Queue ()
	{
		size = 5;
		queueValues = new int [5];
		numElements = 0;
	}
	
	/**
	 * Constructs a queue of the given size.
	 * @param size The size of the queue.
	 */
	public Queue (int size)
	{
		this.size = size;
		queueValues = new int [size];
		numElements = 0;
	}
	/**
	 * Returns the array of the queue.
	 * @return the array of the queue.
	 */
	
	public int[] getArray()
	{
		return queueValues;
	}
	
	/**
	 * Returns the size of this queue.
	 * @return The size of the queue.
	 */
	public int getSize ()
	{
		return size;
	}
	
	/**
	 * Returns the actual number of elements in the queue.
	 * @return The number of elements in the queue.
	 */
	public int getNumElements()
	{
		return numElements;
	}
	
	/**
	 * Get the values of the queue in an integer array.
	 * @return The values of the queue in an integer array.
	 */
	public int[] getQueueValues() 
	{
		return queueValues;
	}
	
	/**
	 * Add the given integer value to the queue.
	 * @param value The integer value to add to the queue.
	 */
	public void addValue (int value)
	{
		for(int moveIndex = 0; moveIndex < size - 1; moveIndex++)
		{
			queueValues[moveIndex] = queueValues[moveIndex+1];
		}
		queueValues[size - 1] = value;
		if(numElements < size)
		{
			numElements++;
		}
	}	
	
	/**
	 * Delete the values in the queue at the given indices.
	 * @param indexes The list of indices to delete.
	 */
	public void deleteValues(int [] indices) // indices must be in descending order
	{
		for(int valueIndex = indices.length - 1; valueIndex >= 0; valueIndex--)
		{
			queueValues[indices[valueIndex]] = 0;
			for(int queueIndex = indices[valueIndex]; queueIndex > 0; queueIndex--)
			{
				int temp = queueValues[queueIndex];
				queueValues[queueIndex] = queueValues[queueIndex - 1];
				queueValues[queueIndex - 1] = temp;
			}
		}	
	}
}