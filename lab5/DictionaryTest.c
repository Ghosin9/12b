/*
* DictionaryTest.c
* Ly Phung
* lynphung
* 12M
* 5/11/19
* Test file for Dictionary.h
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

int main(int argc, char* argv[])
{
	Dictionary A = newDictionary();
   	
   	printf("%s\n", (isEmpty(A)?"true":"false"));
   	printf("%d\n", size(A));

   	insert(A, "1", "poop");
   	printDictionary(stdout, A);

   	insert(A, "2", "yes");
   	printDictionary(stdout, A);
   	insert(A, "3", "hahahhahhhhahaha");
   	printf("%s\n", (isEmpty(A)?"true":"false"));
   	printf("%d\n", size(A));

   	//printf("key=\"%s\" %s\"%s\"\n", "1", (lookup(A, "1") ==NULL?"not found ":"value="), lookup(A, "1"));
   	//printf("key=\"%s\" %s\"%s\"\n", "2", (lookup(A, "2") ==NULL?"not found ":"value="), lookup(A, "2"));
   	//printf("key=\"%s\" %s\"%s\"\n", "3", (lookup(A, "3") ==NULL?"not found ":"value="), lookup(A, "3"));
   	printDictionary(stdout, A);

   	delete(A, "1");
   	//delete(A, "2");
   	//delete(A, "3");
   	printDictionary(stdout, A);
   	printf("%s\n", (isEmpty(A)?"true":"false"));
   	printf("%d\n", size(A));

   	makeEmpty(A);
   	printf("%s\n", (isEmpty(A)?"true":"false"));
   	printf("%d\n", size(A));

   	freeDictionary(&A);

   	return(EXIT_SUCCESS);
}