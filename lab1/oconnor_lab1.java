import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
class skeleton_for_p1
{
	public static void main(String[] args)
	{
		int lineCount = 0;
		int tokenCount = 0;
		int intCount = 0;
		long intSum = 0;
		

    	if(args.length < 1)
    	{
    		System.out.println("No Arguments Found!");
    		System.exit(0);
    	}
    	int [] array = new int[args.length-1];
    	//System.out.println(args[0]);
    	
		// create the DecimalFormat here
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,###,###,###");
		
		// try/catch block to catch any exceptions related to the BufferedReader
		try
		{
			// put your code here to open the BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

			// loop to read the input file
			String inn; 
			while((inn = input.readLine()) != null)
			{
				// create the StringTokenizer
				java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
				lineCount++;
			
				// loop over the tokens of the StringTokenizer
				while(st.hasMoreTokens())
				{
						String token = st.nextToken();
						tokenCount++;
						
					// try/catch block for checking if the current token is an integer
					try
					{
						int v = Integer.parseInt(token); 
						// convert the current token into an int
						// increment int counter and int sum
						v++;
						intCount++;
						intSum += v;
					}
					catch(Exception e)
					{
						// you shouldn't need anything here
					}
					// loop over the commandline arguments with indices 1, 2, 3, ... , args.length-1
					for(int i = 1; i < args.length; i++)
					{
						if (token.equalsIgnoreCase(args[i]))
						{
							array[i-1] ++;
						}
					}
					// and compare each to the current token using s1.equalsIgnoreCase(s2) as 
					// mentioned in the lab description
				}
			}
			// close the BufferedReader
			
			input.close();
			// output the results
			System.out.println("lineCount = " + df.format(lineCount));
			System.out.println("tokenCount = " + df.format(tokenCount));
			System.out.println("intCount = " + df.format(intCount));
			System.out.println("intSum = " + df.format(intSum));
			for(int i = 1; i < args.length; i++)
			{
				System.out.println(args[i] + " count = " + df.format(array[i-1]));
			}
		}
		
		catch(Exception e)
		{
			// output the exception if there is one and exit
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}

