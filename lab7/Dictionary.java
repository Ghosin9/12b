/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12M
5/28/19
Dictionary.java that implements BST in a Dictionary Object.
Dictionary.java
------------------------------------------------------------------------------*/

class Dictionary implements DictionaryInterface
{
	private class Node
	{
		String key;
		String value;
		Node left;
		Node right;

		public Node(String k, String v)
		{
			key = k;
			value = v;
			left = right = null;
		}
	}

	Node root;
	int numPairs;

	public Dictionary()
	{
		root = null;
		numPairs = 0;
	}

	private  Node findKey(Node R, String k)
	{
		if(R == null || k.equals(R.key))
			return R;
		if(k.compareTo(R.key) < 0)
			return findKey(R.left, k);
		else //k.compareTo(R.key) > 0
			return findKey(R.right, k);
	}

	private Node findParent(Node N, Node R)
	{
		Node P = null;
		if(N!=R)
		{
			P = R;
			while(P.left !=N && P.right!=N)
			{
				if(N.key.compareTo(P.key)<0)
					P = P.left;
				else
					P = P.right;
			}
		}
		return P;
	}

	private Node findLeftmost(Node R)
	{
		Node L = R;
		if (L!= null)
			for(;L.left != null; L=L.left);
		return L;
	}

	public boolean isEmpty()
	{
		return(numPairs==0);
	}

	public int size()
	{
		return numPairs;
	}

	public String lookup(String k)
	{
		Node N;
		N = findKey(root, k);
		if(N == null)
			return null;
		else
			return N.value;
	}

	public void insert(String k, String v) throws DuplicateKeyException
	{
		Node N, A, B;
		N = new Node(k, v);
		B = null;
		A = root;

		if(findKey(root, k) != null)
		{
			throw new DuplicateKeyException("Dictionary Error: cannot insert() duplicate key: " + k);
		}

		while (A!=null)
		{
			B = A;
			if(k.compareTo(A.key)<0)
				A = A.left;
			else
				A = A.right;
		}
		if(B== null)
			root = N;
		else if (k.compareTo(B.key) < 0)
			B.left = N;
		else
			B.right = N;
		numPairs++;
	}

	public void delete(String k) throws KeyNotFoundException
	{
		Node N, P, S;

		N = findKey(root, k);
		if(N == null)
		{
			throw new KeyNotFoundException("Dictionary Error: cannot delete() non-existent key: " + k);
		}

		if(N.left == null && N.right == null)
		{
			if (N == root)
				root = null;
			else
			{
				P = findParent(N, root);
				if(P.right == N)
					P.right = null;
				else
					P.left = null;
			}
		}
		else if (N.right == null)
		{
			if (N == root)
				root = N.left;
			else
			{
				P = findParent(N, root);
				if(P.right == N)
					P.right = N.left;
				else
					P.left = N.left;
			}
		}
		else if (N.left == null)
		{
			if(N==root)
				root = N.right;
			else
			{
				P = findParent(N, root);
				if (P.right == N)
					P.right = N.right;
				else
					P.left = N.right;
			}
		}
		else
		{
			S = findLeftmost(N.right);
			N.key = S.key;
			N.value = S.value;
			P = findParent(S, N);
			if (P.right == S)
				P.right = S.right;
			else
				P.left = S.right;
		}
		numPairs--;
	}

	public void makeEmpty()
	{
		root = null;
		numPairs = 0;
	}

	public String toString()
	{
		line = "";
		printInOrder(root);

		return line;
	}

	String line;
	private void printInOrder(Node R)
	{
		if (R!=null)
		{
			printInOrder(R.left);
			line += R.key + " " + R.value + "\n";
			printInOrder(R.right);
		}
	}
}