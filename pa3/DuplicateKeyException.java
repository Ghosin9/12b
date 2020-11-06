/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/27/19
DuplicateKeyException.java that throws a runtime error if there are duplicate keys
DuplicateKeyException.java
------------------------------------------------------------------------------*/

class DuplicateKeyException extends RuntimeException
{
	public DuplicateKeyException(String e)
	{
		super(e);
	}
}