class oconnor_p1
{
	// constructor for the class
	public oconnor_p1()
	{	
	}
	
	// method to sort an array of String values using selection sort
	// sorting the array element starting at lowerBound and ending at upperBound
	public String[] selectionSort(String[] values, int lowerBound, int upperBound)
	{// i=0(lower) i<.length()
		for(int i = lowerBound; i < upperBound; i++)
		{
			for(int j = i + 1 ; j <= upperBound; j++) //j=i+1
			{
				if(values[j].compareTo(values[i]) < 0) //not sure if < or >
				{
					//swap(values[j], values[i]); //save first var as something else first
					String vari = values[j];
					String able = values[i];
					values [j] = able;
					values [i] = vari;
				}
			}
		}
		return values;
	}
	
	// method to return the number of array elements <= testValue with indices in [lowerBound, upperBound]
	// using a for loop to examine the array elements
	public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int elements = 0;
		//int testValue; 
		for(int i=lowerBound; i <= upperBound; i++)
		{
			if(values[i] <= testValue)
			{
				elements ++;
			}
		}
		return elements;
	}
	
	// method to return the number of array elements >= testValue with indices in [lowerBound, upperBound]
	// using a while loop to examine the array elements
	public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int i = lowerBound;
		int elements = 0;
		while(i <= upperBound)
		{		
			if(values[i] >= testValue)
			{
				elements ++;
			}
			i++;		
		}
		return elements;
	}
	
	// method to return the number of array elements in [testValue1, testValue2] or [testValue2, testValue1] with 
	// indices in [lowerBound, upperBound] using a do-while loop to examine the array elements
	public int doWhileLoopTest(int lowerBound, int upperBound, int testValue1, int testValue2, int[] values)
	{
		int counter = 0;
		int i = lowerBound;
		do
		{
			if(values[i] >= testValue1)
			{
				if(values[i] <= testValue2)
				{
					counter++;
				}
			}
			if(values[i] <= testValue1)
			{
				if(values[i] >= testValue2)
				{
					counter++;
				}
			}
			i++;
		}
		while(i <= upperBound);
		return counter;
	}
	
	// method to return the number of array elements that match the switch cases [0, 2, 4, 6, 8, 10, 12, 14, 16, 18] and the default case with 
	// indices in [lowerBound, upperBound]
	public int[] switchTest(int lowerBound, int upperBound, int[] values)
	{
		//values = new int[upperBound];
		int[] array = new int[11];
		//int count = 0;
		for(int i = lowerBound; i < upperBound+1; i++) //lower to upper
		{
			switch(values[i])
			{
				case 0: 
				array[0] ++;
				break;
				
				case 2: 
				array[1] ++;
				break;
				case 4:
				array [2] ++;
				break;
				case 6:
				array [3] ++;
				break;
				case 8:
				array [4] ++;
				break;
				case 10:
				array [5] ++;
				break;
				case 12:
				array [6] ++;
				break;
				case 14:
				array [7] ++;
				break;
				case 16:
				array[8] ++;
				break;
				case 18:
				array [9] ++;
				break;	
				default:
				array [10]++;
				break;
			}
		}
		return array; //do I return array? Wouldn't it show the amount per case
		
		
	}	
}
