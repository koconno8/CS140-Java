import java.io.BufferedReader;
class skeleton_for_p1
{
	public static void main(String[] args)
	{
    {
    	if(args.length < 1)
    	{
    		System.out.println("No Arguments Found!");
    		System.exit(0);
    	}
    	System.out.println(args[0]);
    	}
}
		// create the DecimalFormat here
		java.text.DecimalFormat df = new
		java.text.DecimalFormat("###,###,###,###,###");
		
		// try/catch block to catch any exceptions related to the BufferedReader
		try
		{
			// put your code here to open the BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args)));

			// loop to read the input file
			while((inn = input.readLine()) != null)
			{
				// create the StringTokenizer
				java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
			
				// loop over the tokens of the StringTokenizer
				while(hasMoreTokens())
				{
					// try/catch block for checking if the current token is an integer
					try
					{
						int v = integer.parseInt(token); 
						// convert the current token into an int
						// increment int counter and int sum
						int v +=;
					}
					catch(Exception e)
					{
						// you shouldn't need anything here
						// if the current token is not an int, the Integer.parseInt() statement will
						// throw an exception and come here
					}
					// loop over the commandline arguments with indices 1, 2, 3, ... , args.length-1
					// and compare each to the current token using s1.equalsIgnoreCase(s2) as 
					// mentioned in the lab description
				}
			}
			// close the BufferedReader
			input.close();
			// output the results
		}
		catch(Exception e)
		{
			// output the exception if there is one and exit
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
