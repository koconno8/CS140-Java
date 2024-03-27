import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.io.File;
import java.io.FileWriter;


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
			File file = new File(inputFilename);
			int fileLength = (int) file.length();
			
			BufferedInputStream input = new BufferedInputStream(new java.io.FileInputStream(inputFilename));		
			
			byte[] array = new byte[fileLength];
			input.read(array);

			input.close();	
			
			
			//while(input.read(array)>0)
			while(byteBuffer)
			{
				String str = new String(array);
	
				output.print(str);
				//inn = input.readLine();
			}
			output.close();


			ByteBuffer bBuff = ByteBuffer.wrap(byteArray);

			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));

			int number_of_blocks, number_of_elements, iValue;
			char type, cValue;
			float fValue;
			long lValue;
			short sValue;
			double dValue;
			String str; 

			number_of_blocks = bBuff.getInt();

			for (int i = 0; i = number_of_blocks; i++)
			{
				type = bBuff.getChar();

				switch(type)
				{
					case "i":
						iValue = bBuff.getChar();
						output.println("int\t" + iValue);
						break;

					case "a":
						output.println("int\t" + lValue);
						number_of_elements = bBuff.getInt();

						for (int j = 0; j < number_of_elements-1; j++)
						{
							iValue = bBuff.getChar();
							output.print(iValue + ",");
						}

						iValue = bBuff.getInt();
						output.println(iValue);
						break;
					
					case "l":
						lValue = bBuff.getLong();
						output.println("long\t" + lValue);
						break;

					case "h":
						sValue = bBuff.getShort();
						output.println("short\t" + sValue);
						break;

					case "f":
						fValue = bBuff.getFloat();
						output.println("float\t" + fValue);
						break;
					
					case "d":
						dValue = bBuff.getDouble();
						output.println("double\t" + dValue);
						break;

					case "e":
						output.println("double array\t");
						
						number_of_elements = bBuff.getInt();

						for(int j = 0; j = number_of_elements; j++)
						{
							dValue = bBuff.getDouble();
							output.println(dValue + ",");
						}
						dValue = bBuff.getDouble();
						output.println(dValue);
						break;

					case "s":
						output.print("string\t");

						number_of_elements = bBuff.getInt;

						for(int j = 0; j<number_of_elements; j++)
						{
							cValue = bBuff.getChar();
							output.print(cValue);
						}
						output.println();
						break;
					
					default:
						System.out.println("Error, Unknown type " + type + ".");
				}
			}
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
			
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			String inn, vari;
			while((inn = input.readLine())!= null)
			{
				vari = rawline.trim();
                if ((vari.length() != 0) && (!line.startsWith("#")))
                {
                    inputLines.add(vari);
                }
			}

			//output.close();
			input.close();

            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFilename)));

            output.writeInt(inputLines.size());

            for (int i = 0; i< lines.size(); i++)
            {
                String[] split = inputLines.get(i).split("\t");

                switch (split[0])
                {
                    case "int":
                    output.writeChar('i');
                    output.writeInt(Integer.parseInt(split[1]));
                    break;

                    case "int array":
                    output.writeChar('a');
                    String[] ints = split[1].split(",");
                    output.writeInt(ints.length);

                    for (int j=0; j<ints.length;j++)
					{
                        output.writeInt(Integer.parseInt(ints[j]));
					}
                    break;

                    case "long":
                    output.writeChar('l');
                    output.writeLong(Long.parseLong(split[1]));
                    break;

                    case "short":
                    output.writeChar('h');
                    output.writeShort(Short.parseShort(split[1]));
                    break;

                    case "float":
                    output.writeChar('f');
                    output.writeFloat(Float.parseFloat(split[1]));
                    break;
                    
                    case "double":
                    output.writeChar('d');
                    output.writeDouble(Double.parseDouble(split[1]));
                    break;

                    case "double array":
                        output.writeChar('e');
                        String[] doubles = split[1].split(",");
                        output.writeInt(doubles.length());
                        for (int j = 0; j<doubles.length(); j++)
						{
                            output.writeDouble(Double.parseDouble(doubles[j]));
						}
                        break;
                    
                    case "string":
                        output.writeChar('s');
                        output.writeInt(split[1].length());
                        for (int j = 0; j<split[1].length(); j++)
						{
                            output.writeChar(split[1].charAt(j));
						}
                        break;

                    default:
                        System.out.println("Error, Unknown type " + split[0] + ".");




                }
            }
		}

		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
