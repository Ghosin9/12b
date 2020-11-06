/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
5/7/19
Simulation.java that contains the algorithm to use Queue.java.
Simulation.java
------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Simulation
{
	private static Scanner in = null;
	private static PrintWriter rpt = null, trc = null;
	private static String line = null;
	private static Queue myQueue = null;
	private static Queue[] processors = null;
	
	public static void main(String[] args)
	{
		Scanner in = null;
		myQueue = new Queue();
		
		if (args.length!=1)
		{
			System.out.println("Usage: Simulation <input_file>");
			System.exit(1);
		}
		
		//open output file
		try {
			rpt = new PrintWriter(new FileWriter(args[0] + ".rpt"));
			trc = new PrintWriter(new FileWriter(args[0] + ".trc"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//add objects to queue based on inputfile
		try {
			in = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		int jobs = Integer.parseInt(in.nextLine());
		for(int x = 0; x < jobs; x++)
		{
			String[] s = in.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			myQueue.enqueue(new Job(a, b));
		}
		
		//prepare rpt file
		rpt.println("Report file: " + args[0] + ".rpt");
		rpt.println(jobs + " Jobs:");
		rpt.println(myQueue);
		rpt.println();
		rpt.println("***********************************************************");
		
		//prepare trc file
		trc.println("Trace file: " + args[0] + ".trc");
		trc.println(jobs + " Jobs:");
		trc.println(myQueue);
		trc.println();
		
		for(int x = 1; x < jobs; x++)
		{
			traceFile(x);
			reportFile(x);
		}
		
		in.close();
		rpt.close();
		trc.close();
	}
	
	public static void traceFile(int count)
	{
		boolean cont = true;
		int time = 0, lowTime = Integer.MIN_VALUE;
		
		//make processors array and initialize values
		processors = new Queue[count+1];
		for(int x = 0; x <processors.length; x++)
		{
			processors[x] = new Queue();
		}
		
		//copy myQueue
		for(int x = 0; x < myQueue.length(); x++)
		{
			Job j = (Job) myQueue.dequeue();
			Job k = new Job(j.getArrival(), j.getDuration());
			processors[0].enqueue(k);
			myQueue.enqueue(j);
		}
		
		//first prints
		trc.println("*****************************");
		if (count == 1)
			trc.println(count + " processor:");
		else
			trc.println(count + " processors:");
		trc.println("*****************************");
		//print time = 0
		trc.println("time=" + time);
		for(int x = 0; x < count+1; x++)
			trc.println(x + ": " + processors[x]);
		trc.println();
		
		do
		{
			//first calculate nextTime
			Job c1 = null;
			if (processors[0].length() !=0)
			{
				c1 = (Job) processors[0].peek();
				if (c1.getFinish() == -1)
					lowTime = c1.getArrival();
				else
				{
					for(int x = 1; x<processors.length; x++)
					{
						if (processors[x].length() != 0)
						{
							c1 = (Job) processors[x].peek();
							lowTime = c1.getFinish();
						}
					}
				}
			}
			else
			{
				for(int x = 1; x<processors.length; x++)
				{
					if (processors[x].length() != 0)
					{
						c1 = (Job) processors[x].peek();
						lowTime = c1.getFinish();
					}
				}
			}
			
			for(int x = 1; x < processors.length; x++)
			{
				if (processors[x].length() != 0) //checks for null pointer
				{
					Job c2 = (Job) processors[x].peek();
					if(c2.getFinish() != -1)
					{
						if (lowTime > c2.getFinish())
							lowTime = c2.getFinish();
					}
				}
				time = lowTime;
			}
			
			//finish change
			for(int x = 1; x < processors.length; x++)
			{
				if(processors[x].length() != 0) //checks for null pointer
				{
					Job j = (Job) processors[x].peek();
					if (time == j.getFinish()) //if finish time, then dequeue and re-add to processors[0]
					{
						j = (Job) processors[x].dequeue();
						processors[0].enqueue(j);
						if (processors[x].length() > 0)
						{
							j = (Job) processors[x].peek();
							j.computeFinishTime(time);
						}
					}
				}
			}
			
			//arrival change
			if (processors[0].length() != 0)
			{
				boolean repeat = false;
				do
				{
					if (processors[0].isEmpty())
						break;
					Job j = (Job) processors[0].peek();
					if (time == j.getArrival())
					{
						int low = Integer.MAX_VALUE, index = 1;
						for(int x = 1; x < processors.length; x++)
						{
							if (processors[x].length() == 0)//if the number is 0 , then break
							{
								index = x;
								break;
							}
							else // if not then check low value
							{
								if (low > processors[x].length()) //replace low value and index
								{
									low = processors[x].length();
									index = x;
								}
							}
						}
						j = (Job) processors[0].dequeue(); //remove from 0 queue
						processors[index].enqueue(j); //add to shortest queue
						if (processors[index].peek().equals(j))//if its the first value
							j.computeFinishTime(time); //calculate finish time
					}
					
					if(!processors[0].isEmpty())
					{
						j = (Job) processors[0].peek();
						if (j.getArrival() == time)
							repeat = true;
						else
							repeat = false;
					}
				} while (repeat);
			}
			
			//prints
			trc.println("time=" + time);
			for(int x = 0; x < processors.length; x++)
			{
				trc.print(x + ": " + processors[x]);
				trc.println();
			}
			trc.println();
			
			//check if finished
			cont = false;
			for(int x = 1; x < processors.length; x++)
			{
				if(processors[x].length() != 0)
					cont = true;
			}
			
			for(int x = 0; x < processors[0].length(); x++)
			{
				if (processors[0].length() != 0)
				{
					Job j = (Job) processors[0].dequeue();
					if (j.getFinish()==-1)
						cont = true;
					processors[0].enqueue(j);
				}
			}
		} while(cont);
	}
	
	public static void reportFile(int n)
	{
		int count = 0, total = 0, max = 0;
		double ave = 0;
		if (n == 1)
			rpt.print(n + " processor: ");
		else
			rpt.print(n + " processors: ");
		
		if (processors[0].length() != 0)
		{
			Job J;
			while (processors[0].length() > 0)
			{
				J = (Job) processors[0].peek();
				total += J.getWaitTime();
				if (max < J.getWaitTime())
				{
					max = J.getWaitTime();
				}
				count++;
				processors[0].dequeue();
			}
		}
		
		if (count ==0)
			ave = 0;
		else
			ave = (double)total/count;
		
		rpt.println("totalWait=" + total + ", maxWait=" + max + ", averageWait=" + new DecimalFormat("#0.00").format(ave));
	}
}
