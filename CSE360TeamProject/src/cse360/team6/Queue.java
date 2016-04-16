package cse360.team6;

public class Queue 
{
	private int [] queueValues; 
	private int numElements;
	private int size; 
	
	public Queue ()
	{
		size = 5;
		queueValues = new int [5];
		numElements = 0;
	}
	
	public Queue (int _size)
	{
		size = _size;
		queueValues = new int [size];
		numElements = 0;
	}
	
	public int getSize ()
	{
		return size;
	}
	
	public int getNumElements()
	{
		return numElements;
	}
	
	public int[] getQueueValues() 
	{
		return queueValues;
	}
		
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
	
	public void deleteValues(int [] indexes) // indices must be in descending order
	{
		for(int valueIndex = indexes.length - 1; valueIndex >= 0; valueIndex--)
		{
			queueValues[indexes[valueIndex]] = 0;
			for(int i = indexes[valueIndex]; i > 0; i--)
			{
				int temp = queueValues[i];
				queueValues[i] = queueValues[i - 1];
				queueValues[i - 1] = temp;
			}
		}	
	}
}
