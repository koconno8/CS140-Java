import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.File;

class oconnor_p2
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
			byte[] array = new byte[8];	
			java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.wrap(array);	
			
			int numberOfBlocks, arrEl, intV;
			char lett, charV;
			long longV;
			short shortV;
			float floatV;
			double doubleV, dubV;
			
			int currbytes = input.read(array, 0, 4);
			numberOfBlocks = byteBuffer.getInt(0);

			for(int i = 0; i < numberOfBlocks; i++)
			{	
				input.read(array, 0, 2);
				char type = byteBuffer.getChar(0);

				switch(type)
				{
					case 'i':
						input.read(array, 0, 4);
						intV = byteBuffer.getInt(0);
						output.println("int\t" + intV);
						break;
					
					case 'l':
						input.read(array, 0, 8);
						longV = byteBuffer.getLong(0);
						output.println("long\t" + longV);
						break;

					case 'h':
						input.read(array, 0, 2);
						shortV = byteBuffer.getShort(0);
						output.println("short\t" + shortV);
						break;

					case 'f':
						input.read(array, 0, 4);
						floatV = byteBuffer.getFloat(0);
						output.println("float\t" + floatV);
						break;

					case 'd':
						input.read(array, 0, 8);
						doubleV = byteBuffer.getDouble(0);
						output.println("double\t" + doubleV);
						break;

					case 'a':
						output.print("int array\t");
						input.read(array, 0, 4);
						arrEl = byteBuffer.getInt(0);
						int c = 0;
						for(int d = 0; d < arrEl; d++)
						{
							if(c < arrEl - 1)
							{
								input.read(array, 0, 4);
								intV = byteBuffer.getInt(0);
								output.print(intV + ",");
								c++;
							}
							else
							{
								input.read(array, 0, 4);
								intV = byteBuffer.getInt(0);
								output.println(intV);
							}
						}
						break;

					case 's':
						output.print("string\t");
						input.read(array, 0, 4);
						arrEl = byteBuffer.getInt(0);
						for(int j = 0; j < arrEl; j++)
						{	
							input.read(array, 0, 2);
							charV = byteBuffer.getChar(0);
							output.print(charV);
						} 
						output.print("\n");
						break;

					case 'e':
						output.print("double array\t");
						input.read(array, 0, 4);
						arrEl = byteBuffer.getInt(0);
						int j = 0;
						for(int k = 0; k < arrEl; k++)
						{
							if(j < arrEl - 1)
							{
								input.read(array, 0, 8);
								dubV = byteBuffer.getDouble(0);
								output.print(dubV + ",");
								j++;
							}
							else
							{
								input.read(array, 0, 8);
								dubV = byteBuffer.getDouble(0);
								output.println(dubV);
							}
						}
						break;

					default:
						System.out.println("does not fit into category");
						break;
				}
			}
			output.close();
			input.close();
		}
		catch(Exception e)
		{
			//System.out.println(e.toString());
			//e.printStackTrace();
			System.exit(0);
		}
	}
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		//Add right char to each one
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
				String trimmed;
				trimmed = inn.trim();
				if ((trimmed.length() != 0) && (!(trimmed.startsWith("#"))));
				{
					inputLines.add(trimmed);	
				}
			}
				output.writeInt(inputLines.size());
				for(int i = 0; i < inputLines.size(); i++)
				{
					String[] stringSplit = inputLines.get(i).split("\t");
					//System.out.println(stringSplit[0]);
					switch (stringSplit[0])
					{
						case "int":
							output.writeChar('i');
							output.writeInt(Integer.parseInt(stringSplit[1]));
							break;

						case "long":
						output.writeChar('l');
							output.writeLong(Long.parseLong(stringSplit[1]));
							break;

						case "short":
						output.writeChar('h');
							output.writeShort(Short.parseShort(stringSplit[1]));
							break;
						
						case "float":
						output.writeChar('f');
							output.writeFloat(Float.parseFloat(stringSplit[1]));
							break;
						
						case "double":
							output.writeChar('d');
							System.out.println(stringSplit[1]);
							output.writeDouble(Double.parseDouble(stringSplit[1]));
							break;

						case "int array":
							output.writeChar('a');
							String[] integers = stringSplit[1].split(",");
							output.writeInt(integers.length);
							for(int j = 0; j < integers.length; j++)
							{
								output.writeInt(Integer.parseInt(integers[j]));
							}
							break;

						case "string":
							output.writeChar('s');
							output.writeInt(stringSplit[1].length());
							for(int j = 0; j < stringSplit[1].length(); j++)
							{
								output.writeChar(stringSplit[1].charAt(j));
							}
							break; 

						case "double array":
							output.writeChar('e');
							String[] dubArr = stringSplit[1].split(",");
							output.writeInt(dubArr.length);
							for(int j = 0; j < dubArr.length; j++)
							{
								output.writeDouble(Double.parseDouble(dubArr[j]));
							}
							break;

						default:
							System.out.println(stringSplit[0] + " does not fit into a category.");							
					}
				}
			
			output.close();
			input.close();
		}
		catch(Exception e)
		{
			//System.out.println(e.toString());
			e.printStackTrace();
			System.exit(0);
		}
	}
}

