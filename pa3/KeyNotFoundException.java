/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/27/19
KeyNotFoundException.java that throws a runtime error if there is no existing key
KeyNotFoundException.java
------------------------------------------------------------------------------*/

class KeyNotFoundException extends RuntimeException
{
	public KeyNotFoundException(String e)
	{
		super(e);
	}
}