/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12M
5/19/19
ListTest.java that tests the List ADT.
ListTest.java
------------------------------------------------------------------------------*/

class ListTest
{
	public static void main(String[] args)
	{
		List<String> I = new List<String>();
		List<String> S = new List<String>();
		List<List<String>> list = new List<List<String>>();

		I.add(1, "yes");
		I.add(2, "no");
		I.add(3, "jneiajrnkejirnuejakmreka");

		S.add(1, "one");
		S.add(2, "two");
		S.add(3, "three");

		list.add(1, I);
		list.add(2, S);
		System.out.println("I: " + I);
		System.out.println("S: " + S);
		System.out.println("list: " + list);
		System.out.println("I.equals(I) is "+I.equals(I));
	    System.out.println("I.equals(S) is "+I.equals(S));

	    System.out.println("I.size() is "+I.size());

	    I.remove(1);

	    System.out.println("I: " + I);

	    try{
         System.out.println(I.get(200));
      }catch(ListIndexOutOfBoundsException e){
         System.out.println("Caught Exception: ");
         System.out.println(e);
         System.out.println("Continuing without interruption");
      }

      System.out.println("I.get(2) is "+I.get(2));

      I.removeAll();

      System.out.println(I);
      System.out.println("I.size() is "+I.size());
	}
}