/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/27/19
Dictionary.java that creates a Dictionary ADT with the necessary operators and states.
Dictionary.java
------------------------------------------------------------------------------*/

class Dictionary implements DictionaryInterface
{

	private class Node {
      String myKey, myValue;
      Node next;

      Node(String key, String value){
      	myKey = key;
      	myValue = value;
        next = null;
      }
  	}

  	private Node head;
  	private int numItems;

  	public Dictionary()
  	{
  		head = null;
  		numItems = 0;
  	}

	public boolean isEmpty()
	{
		return (numItems ==0);
	}

	public int size()
	{
		return numItems;
	}

	public String lookup(String key)
	{
		Node N = head;
		for(;N!=null; N=N.next)
		{
			if (N.myKey.equals(key))
			{
				return N.myValue;
			}
		}
		return null;
	}

	public void insert(String key, String value) throws DuplicateKeyException
	{
		if (lookup(key)!= null)
			throw new DuplicateKeyException("cannot insert duplicate keys");
		
		//if first value
		if(head==null)
		{
			head = new Node(key, value);
			numItems++;
			return;
		}

		Node N = head;
		for(int i=1; i<numItems; i++)
		{
			N = N.next;
		}
		N.next = new Node(key, value);
		numItems++;
	}

	public void delete(String key) throws KeyNotFoundException
	{
		if (lookup(key)==null)
			throw new KeyNotFoundException("cannot delete non-existent key");

		Node N = head;
		Node before = N;
		for(int i=0; i<numItems; i++)
		{
			if (N.myKey.equals(key))
			{
				if (i==0) //if first term
				{
					head = head.next;
					N.next = null;
				}
				break;
			}
			
			before = N;
			N = N.next;
		}
		
		before.next = N.next;
		
		numItems--;
	}

	public void makeEmpty()
	{
		head = null;
		numItems=0;
	}

	public String toString()
	{
		StringBuffer line = new StringBuffer();
		Node N = head;

		for(; N!=null; N=N.next)
		{
			line.append("key=").append(N.myKey).append(" value=").append(N.myValue).append("\n");
		}

		return new String(line);
	}
}