class fullTest_p1
{
	public static void main(String[] args)
	{
		// make sure we have 3 commandline arguments, if not, output what we are looking
		// for and exit
		if( args.length != 2 )
		{
			System.out.println("format test_p1 \"test data filename\" \"sorted data filename\"");
			System.exit(0);
		}
		
		double[] results = new double[16];
		
		try
		{
			// define the bounds and test values
			int[] lowerBound = new int[] {1200, 140, 3000, 2250, 1555};
			int[] upperBound = new int[] {6448, 6600, 8200, 9999, 7500};
			int[] testValue = new int[] {58, 550};
			int[] testValue1 = new int[] {89, 450};
			int[] testValue2 = new int[] {450, 89};
			
			int[] checkValues = new int[] {385, 2297, 2790, 2790};
			int[] checkSwitchValues = new int[] {3, 5, 11, 7, 6, 4, 8, 2, 5, 12, 5883};
			
			// instantiate a BufferedReader to read from the input file
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			java.io.BufferedReader inputSorted = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[1])));
			String inn;
			
			// ArrayList<String> to temporarily store the lines from the input file,
			// we will be discussing ArrayList shortly, for now just think of it
			// as a resizable array
			java.util.ArrayList<String> inputLists = new java.util.ArrayList<>();
			
			// read the input file and store the lines in inputLists
			while( (inn = input.readLine()) != null )
			{
				if( (inn.trim().length() > 0) && (!inn.trim().startsWith("#")) )
				{
					inputLists.add(inn.trim());
				}
			}
			input.close();
			
			String[] sortedValues = new String[inputLists.size()];
			for( int i = 0; i < sortedValues.length; i++ )
			{
				sortedValues[i] = inputSorted.readLine();
			}
			inputSorted.close();
			
			// allocate the array to sort 
			String[] valuesToSort = new String[inputLists.size()];
			System.out.println("\"" + args[0] + "\"" + " has " + valuesToSort.length + " values to process");
			
			// define the array that will be returned from selection sort
			String[] valuesSorted;
			
			// allocate the array to hold the test values 
			int[] testValues = new int[inputLists.size()];
			
			// populate the array to sort and the test value array
			for( int i = 0; i < valuesToSort.length; i++ )
			{
				valuesToSort[i] = inputLists.get(i);
				try
				{
					testValues[i] = Integer.parseInt(inputLists.get(i));
				}
				catch(Exception e)
				{
					System.err.println("\"" + inputLists.get(i) + "\" is not an integer");
				}
			}

			// instantiate a copy of the program to test
			oconnor_p1 testClass = new oconnor_p1();
			
			// call selection sort
			valuesSorted = testClass.selectionSort(valuesToSort, lowerBound[0], upperBound[0]);
			
			if( false )
			{
				for( int i = 0; i < valuesSorted.length; i++ )
				{
					System.out.println(valuesSorted[i]);
				}
			}
			
			// check the sorted values
			boolean sortWorked = true;
			for( int i = 0; (i < valuesSorted.length) && sortWorked; i++ )
			{
				if( !valuesSorted[i].equals(sortedValues[i]) )
				{
					System.out.println("i = " + i + " " + valuesSorted[i] + " " + sortedValues[i]);
					results[0] = 1.0;
					sortWorked = false;
				}
			}
			
			// call the for loop test and output the results
			int forLoopTestResult = testClass.forLoopTest(lowerBound[1], upperBound[1], testValue[0], testValues);
			System.out.println("forLoopTestResult = " + forLoopTestResult);
			if( checkValues[0] != forLoopTestResult )
			{
				results[1] = 1.0;
			}
			
			// call the while loop test and output the results
			int whileLoopTestResult = testClass.whileLoopTest(lowerBound[2], upperBound[2], testValue[1], testValues);
			System.out.println("whileLoopTestResult = " + whileLoopTestResult);
			if( checkValues[1] != whileLoopTestResult )
			{
				results[2] = 1.0;
			}
			
			// call the do while loop test and output the results
			int doWhileLoopTestResult = testClass.doWhileLoopTest(lowerBound[3], upperBound[3], testValue1[0], testValue2[0], testValues);
			System.out.println("doWhileLoopTestResult = " + doWhileLoopTestResult);
			if( checkValues[2] != doWhileLoopTestResult )
			{
				results[3] = 1.0;
			}
			
			// call the do while loop test a second time, with testvalue1 and testValue2 swapped, 
			// and output the results
			int doWhileLoopTestResult2 = testClass.doWhileLoopTest(lowerBound[3], upperBound[3], testValue1[1], testValue2[1], testValues);
			System.out.println("doWhileLoopTestResult2 = " + doWhileLoopTestResult2);
			if( checkValues[2] != doWhileLoopTestResult2 )
			{
				results[4] = 1.0;
			}
			
			// call the switch test  and output the results
			int[] switchTestResult = testClass.switchTest(lowerBound[4], upperBound[4], testValues);
			for( int i = 0; i < switchTestResult.length; i++ )
			{
				System.out.println("switchTestResult[" + i + "] = " + switchTestResult[i]);
				if( checkSwitchValues[i] != switchTestResult[i] )
				{
					results[5+i] = 1.0;
				}
			}
			
			System.err.print("results =");
			for( int i = 0; i < results.length; i++ )
			{
				System.err.print("\t" + results[i]);
			}
			System.err.println();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		
	}
}
