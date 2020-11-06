/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12M
1/18/19
Search.java file that contains mergesort, binary search 
Search.java
------------------------------------------------------------------------------*/

import java.io.*;
import java.util.Scanner;

class Search
{
  public static void main(String args[]) throws IOException
	{
    Scanner in;
    String line;
    String[] token;
    int i, n =0, lineNumber = 0;
    // check number of command line arguments is at least 2
    if(args.length < 2)
    {
      System.out.println("Usage: Search file target1 [target2 ..]");
      System.exit(1);
    }
    // open files
    in = new Scanner(new File(args[0]));
    // read lines from in, extract and print tokens from each line
    while( in.hasNextLine() )
    {
      lineNumber++;
      in.nextLine();
    }

    in = new Scanner(new File(args[0]));

    token = new String[lineNumber];

    int count=0;
    while(in.hasNextLine())
    {
      // trim leading and trailing spaces, then add one trailing space so
      // split works on blank lines
      line = in.nextLine().trim() + " ";

      // split line around white space
      token[count] = line.split("\\s+")[0];

      // print out tokens
      n = token.length;
      //out.println("Line " + lineNumber + " contains " + n + " tokens:");
      count++;
    }

    	//create num array
    	int[] nums = new int[n];
    	for (int x=0; x<n; x++)
    	{
    		nums[x] = x+1;
    	}

      //mergesort
      mergeSort(token, nums, 0, n-1);

      //binary search
      for (int x=1; x<args.length; x++)
      {
        String tar = args[x];
        int temp = binarySearch(token, 0, token.length, tar);
        if (temp == -1)
        {
          System.out.println(tar + " not found");
        }
        else
        {
          System.out.println(tar + " found on line " + nums[temp]);
        }
      }

      in.close();
   }

	static int binarySearch(String[] A, int p, int r, String t)
	{
	    int q;
	    if(p > r) 
	    {
	    	return -1;
	    }
	    else
	    {
	       	q = (p+r)/2;
	       	if(t.equals(A[q]))
	       	{
	       		return q;
	     	  }
	     	else if(t.compareTo(A[q]) < 0)
	     	{
	     		return binarySearch(A, p, q-1, t);
	     	}
	     	else // t.compareTo(A[q]) > 0 aka t>A[q]
	     	{
	      	  return binarySearch(A, q+1, r, t);
	       }
	    }
	}

	public static void mergeSort(String[] word, int[] lineNumber, int p, int r)
	{
		int q;
      	if(p < r) 
      	{
      		q = (p+r)/2;
          //System.out.println(p + " " + q + " " + r);
         	mergeSort(word, lineNumber, p, q);
         	mergeSort(word, lineNumber, q+1, r);
         	merge(word, lineNumber, p, q, r);
      	}
   }

   // merge()
   // merges sorted subarrays A[p..q] and A[q+1..r]
   public static void merge(String[] word, int[] lineNumber, int p, int q, int r)
   {
   		int n1 = q-p+1;
      int n2 = r-q;
      String[] L = new String[n1];
     	String[] R = new String[n2];
     	int i, j, k;
     	int[] left = new int [n1];
     	int[] right = new int [n2];

    	//copying word array to left and right arrays
    	for(i=0; i<n1; i++)
    	{
       	L[i] = word[p+i];
        left[i] = lineNumber[p+i];
   	  }
    	for(j=0; j<n2; j++)
    	{ 
       	R[j] = word[q+j+1];
        right[j] = lineNumber[q+1+j];
      }

      //merging the arrays back together
      i = 0; j = 0;
     	for(k=p; k<=r; k++)
     	{
     		if( i<n1 && j<n2 )
     		{
        	if(L[i].compareTo(R[j]) < 0)
        	{
           		word[k] = L[i];
           		lineNumber[k] = left[i];
           		i++;
       		}
       		else
       		{
           		word[k] = R[j];
           		lineNumber[k] = right[j];
           		j++;
        	}
        }
         	else if( i<n1 )
         	{
          	word[k] = L[i];
          	lineNumber[k] = left[i];
          	i++;
         	}
         	else
         	{   // j<n2
            	word[k] = R[j];
            	lineNumber[k] = right[j];
            	j++;
         	}
      	}
   	}
}