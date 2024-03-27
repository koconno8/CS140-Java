import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;

class oconnor_lab2
{
	public static void main(String[] args)
	{	
		// put some code here to check for three commandline arguments
		if(args.length != 3)
		{
			System.out.println("Need 3 Arguments!");
			System.exit(0);
		}
		
		// puts some code here to check that the first commandline argument starts with "b" or "t"
		if( args[0].startsWith("b") )
		{
			convertBinaryToText(args[1], args[2]);
		}
		else if(( args[0].startsWith("t") ))
		{
			convertTextToBinary(args[1], args[2]);
		}
		else
		{
			System.out.println("Augment was incorrect");
			System.exit(0);
		}
	}
	
	private static void convertBinaryToText(String inputFilename, String outputFilename)
	{
		System.out.println("convertBinaryToText");
		try
		{
			// put your code to read a binary file and output it as a text file
			BufferedInputStream input = new BufferedInputStream(new java.io.FileInputStream(inputFilename));		
			PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(outputFilename)));			
			String inn;	
			byte[] array = new byte[1];		
			while(input.read(array)>0)
			{
				String str = new String(array);
	
				output.print(str);
				//inn = input.readLine();
			}
			output.close();
			input.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");
		try
		{
			// put your code to read a text file and output it as a binary file
			
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
			DataOutputStream output = new java.io.DataOutputStream(new java.io.FileOutputStream(outputFilename));
			//java.io.PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.BufferedWriter(outputFilename))); 
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			String inn;
			while((inn = input.readLine())!= null)
			{
				byte[] array = inn.getBytes();
				inputLines.add(inn);
				output.write(array);
				output.write(System.lineSeparator().getBytes());
				
			}
			output.close();
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}

