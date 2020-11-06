/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
5/7/19
QueueTest.java that tests Queue.java.
QueueTest.java
------------------------------------------------------------------------------*/

public class QueueTest {
	public static void main(String[] args)
	{
		Queue A = new Queue();
		
		System.out.println("A length: " + A.length()); //length = 0
		System.out.println("A isEmpty(): " + A.isEmpty()); //true
		
		A.enqueue(1); //add 1
		A.enqueue(2); //add 2
		A.enqueue("yesearstrae"); //add different objects
		A.enqueue(new Job(69, 420)); //add job object
		
		System.out.println("A: " + A); //print
		System.out.println("A length(): " + A.length()); //length = 4
		System.out.println("A peek(): " + A.peek()); //return 1
		
		A.dequeue(); //remove 1
		
		System.out.println("A: " + A);
		System.out.println("A length(): " + A.length()); //length = 3
		System.out.println("A isEmpty(): " + A.isEmpty()); //false
		
		A.dequeueAll(); //dequeue
		System.out.println("A: " + A); //blank
		System.out.println("A length(): " + A.length()); //length = 0
		System.out.println("A isEmpty(): " + A.isEmpty()); //true
		
		//empty exceptions
		try
		{
			A.dequeue();
		}
		catch (QueueEmptyException e)
		{
			System.out.println(e); //print error
		}
		
		try
		{
			A.dequeueAll();
		}
		catch (QueueEmptyException e)
		{
			System.out.println(e); //print error
		}
		
		try
		{
			A.peek();
		}
		catch (QueueEmptyException e)
		{
			System.out.println(e); //print error
		}
	}
}
