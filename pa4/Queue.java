/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
5/7/19
Queue.java that implements the Queue Interface with the appropriate states and methods.
Queue.java
------------------------------------------------------------------------------*/

class Queue implements QueueInterface
{
	private class Node
	{
		private Object item;
		private Node next;

		public Node(Object x)
		{
			item = x;
			next = null;
		}
	}

	private Node head;
	private int numItems;

	public Queue()
	{
		head = null;
		numItems = 0;
	}

	public boolean isEmpty()
	{
		return (numItems==0);
	}

	public int length()
	{
		return numItems;
	}

	public void enqueue(Object newItem)
	{
		if (numItems==0)
		{
			head = new Node(newItem);
		}
		else
		{
			Node N = head;
			for(;N.next!=null; N= N.next){}
			N.next = new Node(newItem);
		}
		numItems++;
	}

	public Object dequeue() throws QueueEmptyException
	{
		if (numItems==0)
			throw new QueueEmptyException("Cannot call dequeue() on an empty Queue");

		Node N = head;
		head = head.next;
		Object x = N.item;
		N.next = null;
		numItems--;

		return x;
	}

	public Object peek() throws QueueEmptyException
	{
		if(numItems==0)
			throw new QueueEmptyException("Cannot call peek() on an empty Queue");

		return head.item;
	}

	public void dequeueAll() throws QueueEmptyException
	{
		if(numItems==0)
			throw new QueueEmptyException("Cannot call dequeueAll() on an empty Queue");

		head = null;
		numItems = 0;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		Node N = head;
		for(;N!=null; N = N.next)
		{
			sb.append(N.item).append(" ");
		}

		return new String(sb);
	}
}