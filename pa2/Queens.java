/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/17/19
Queens.java file that contains the queen placement algorithm
Queens.java
------------------------------------------------------------------------------*/

class Queens
{
	public static void main (String[] args)
	{
		//check length
		if (args.length<1 || args.length>2)
		{
			System.out.println("Usage: Queens [-v] number\n Option: -v verbose output, print all solutions");
			System.exit(1);
		}

		//for -v command
		if (args.length==2 && !args[0].equals("-v"))
		{
			System.out.println("Usage: Queens [-v] number\n Option: -v verbose output, print all solutions");
			System.exit(1);
		}

		//PARSE INT 
		int n = 0;
		String mode = "";
		try
		{
			if (args.length==1)
			{
				n = Integer.parseInt(args[0]);
			}
			else
			{
				n = Integer.parseInt(args[1]);
				mode = "verbose";
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Usage: Queens [-v] number\n Option: -v verbose output, print all solutions");
			System.exit(1);
		}

		//initialize board
		int[][] board = new int[n+1][n+1];
		for(int r=0; r<board.length; r++)
		{
			for (int c=0; c<board[r].length; c++)
			{
				board[r][c] = 0;
			}
		}

		//recursive call
		int numSolutions = findSolutions(board, 1, mode);
		if(numSolutions ==1)
			System.out.println(n + "-Queens has " + numSolutions + " solution");
		else
			System.out.println(n + "-Queens has " + numSolutions + " solutions");

	}

	static void placeQueen(int[][] B, int i, int j)
	{
		//change to -1
		int right = j+1;
		int left = j-1;
		for (int x=i+1; x<B.length; x++)
		{
			//cols
			B[x][j]--;
			if(right<B.length)
			{
				B[x][right]--;
				right++;
			}
			if(left>=1)
			{
				B[x][left]--;
				left--;
			}
		}
		B[i][j]++;
		B[i][0]=j;
	}

	static void removeQueen(int[][] B, int i, int j)
	{
		//change to +1
		int right =j+1;
		int left =j-1;
		for (int x=i+1; x<B.length; x++)
		{
			//cols
			B[x][j]++;
			if(right<B.length)
			{
				B[x][right]++;
				right++;
			}
			if(left>=1)
			{
				B[x][left]++;
				left--;
			}
		}
		B[i][j]--;
		B[i][0]=0;
	}

	static void printBoard(int[][] B)
	{
		String line = "(";
		for(int x=1; x <B.length; x++)
		{
			if(x!=B.length-1)
				line+=B[x][0] + ", ";
			else
				line+=B[x][0];
		}
		line+=")";
		System.out.println(line);
	}

	static int findSolutions(int[][] B, int i, String mode)
	{
		int sum=0;
		if(i>=B.length)
		{
			if (mode.equals("verbose"))
			{
				printBoard(B);
			}
			return 1;
		}
		else
		{
			for(int c=1; c<B.length; c++)
			{
				if (B[i][c]==0)
				{
					placeQueen(B, i, c);
					sum += findSolutions(B, i+1, mode);
					removeQueen(B, i, c);
				}
			}
		}
		return sum;
	}
}