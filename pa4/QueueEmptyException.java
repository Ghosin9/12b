/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
5/7/19
QueueEmptyException.java that throws a runtime error if the Queue is empty.
QueueEmptyException.java
------------------------------------------------------------------------------*/

class QueueEmptyException extends RuntimeException
{
	public QueueEmptyException(String e)
	{
		super(e);
	}
}