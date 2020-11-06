/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/5/19
Subset.java file that contains mergesort, binary search 
Subset.java
------------------------------------------------------------------------------*/

import java.io.*;
import java.util.Scanner;

class Subset
{
	public static void main(String[] args)
	{
		int n = 0, k = 0;
		int[] B;

		//check commandline args
		if(args.length < 2)
		{
			System.out.println("Usage: Java Subset <int> <int>");
			System.exit(1);
		}

		try
		{
			n = Integer.parseInt(args[0]);
			k = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Usage: Java Subset <int> <int>");
			System.exit(1);
		}

		if (k < 0 || k > n)
		{
			System.out.println("Usage: Java Subset <int> <int>");
			System.exit(1);
		}

		//initialize the 0 array
		B = new int[n+1];
		for(int x = 0; x < n+1; x++)
		{
			B[x] = 0;
		}

		printSubsets(B, k, 1);
	}

	static String setToString(int[] B)
	{
		String line = "{";
		for(int x = 1; x < B.length; x++)
		{
			if(B[x] == 1)
			{
				line += x;

				//if theres more #'s to add ", "
				for(int y = x+1; y < B.length; y++)
				{
					if (B[y] == 1)
					{
						line += ", ";
						break;
					}
				}
			}
		}

		//if no elements were added
		if (line.equals("{"))
			line+= " ";

		line += "}";
		return line;
	}

	static void printSubsets(int[] B, int k, int i)
	{
		//if enough elements were included
		if (k == 0)
		{
			System.out.println(setToString(B));
			return;
		}

		//if end of array and not enough elements were included
		if (i == B.length)
			return;

		//set up left and right arrays
		int[] left = new int[B.length];
		int[] right = new int[B.length];
		for(int x=0; x <B.length; x++)
		{
			left[x] = B[x];
			right[x] = B[x];
		}
		//include the left element
		left[i] = 1;

		printSubsets(left, k-1, i+1);
		printSubsets(right, k, i+1);
	}
}