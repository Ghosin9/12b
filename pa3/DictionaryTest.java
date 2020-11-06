/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12B
4/27/19
DictionaryTest.java that tests the Dictionary.java file
DictionaryTest.java
------------------------------------------------------------------------------*/

class DictionaryTest
{
	public static void main(String[] args)
	{
		Dictionary dict = new Dictionary();

		//test methods
		dict.insert("1", "69");
		System.out.println(dict.toString());
		dict.insert("2", "420");
		System.out.println(dict.toString());
		dict.insert("3", "yes boiiiiii");
		
		//lookup 1st term
		System.out.println(dict.lookup("1"));
		//lookup middle term
		System.out.println(dict.lookup("2"));
		//lookup last term
		System.out.println(dict.lookup("3"));
		System.out.println();
		System.out.println(dict.toString());
		
		//delete first item
		dict.delete("1");
		//middle item
		//dict.delete("2");
		//last item
		//dict.delete("3");
		System.out.println(dict.toString());
		
		dict.insert("4", "dictionary");
		System.out.println(dict.toString());
		
		dict.makeEmpty();
		System.out.println(dict.toString());
		
		//test keynotfound
		//dict.delete("7");
		
		//test duplicatekey
		//dict.insert("4", "notdictionary");
	}
}