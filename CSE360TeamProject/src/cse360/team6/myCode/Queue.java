package cse360.team6.myCode;

public class Queue 
{
	int [] queueValues; 
	int numElements;
	int size; 
	
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
	
	public int[] getArray()
	{
		return queueValues;
	}
	
	public int getSize ()
	{
		return size;
	}
	
	public int getNumElements()
	{
		return numElements;
	}
		
	public void addValue (int value)
	{
		for(int moveIndex = 3; moveIndex >= 0; moveIndex--)
		{
			queueValues[moveIndex] = queueValues[moveIndex+1];
		}
		queueValues[4] = value;
		if(numElements < size)
		{
			numElements++;
		}
	}	
	
	public void deleteValues(int [] indexes)
	{
		for(int valueIndex = indexes.length - 1; valueIndex >= 0; valueIndex--)
		{
			queueValues[indexes[valueIndex]] = 0;
			for(int i = indexes[valueIndex]; i < indexes.length - 1; i++)
			{
				int temp = queueValues[i];
				queueValues[i] = queueValues[i + 1];
				queueValues[i + 1] = temp;
			}
		}	
	}
}