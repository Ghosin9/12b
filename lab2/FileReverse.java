/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12M
4/17/19
Program that takes in a file as input and reverses it in an output file
File Reverse
------------------------------------------------------------------------------*/
import java.io.*;
import java.util.Scanner;

class FileReverse
{

	public static void main (String []args) throws IOException
	{
		Scanner in;
		PrintWriter out;
		String line;
		String[] token;
		int i, n, lineNumber = 0;
		// check number of command line arguments is at least 2
		if(args.length < 2)
		{
			System.out.println("Usage: FileCopy <input file> <output file>");
			System.exit(1);
 		}
 		// open files
 		in = new Scanner(new File(args[0]));
 		out = new PrintWriter(new FileWriter(args[1]));
 		// read lines from in, extract and print tokens from each line
 		while( in.hasNextLine() )
 		{
 			lineNumber++;

 			// trim leading and trailing spaces, then add one trailing space so
 			// split works on blank lines
 			line = in.nextLine().trim() + " ";

 			// split line around white space
 			token = line.split("\\s+");

 			// print out tokens
 			n = token.length;
 			//out.println("Line " + lineNumber + " contains " + n + " tokens:");

 			for(i=0; i<n; i++)
 			{
 				out.println(" "+stringReverse(token[i], token[i].length()));
 			}
 		}
 	// close files
 	in.close();
 	out.close();
	}

	public static String stringReverse(String s, int n)
	{
		if (n == 0)
		{
			return "";
		}

		return s.charAt(n-1) + stringReverse(s.substring(0, n-1), n-1);
	}
}