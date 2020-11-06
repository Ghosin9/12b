/*
* Dictionary.c
* Ly Phung
* lynphung
* 12M
* 5/11/19
* Implementation file for Dictionary.h
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

//Node
typedef struct NodeObj
{
	char* key;
	char* value;
	struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;

Node newNode(char* k, char* v)
{
	Node N = malloc(sizeof(NodeObj));
	assert(N!=NULL);
	N->key = k;
	N->value = v;
	N->next = NULL;
	return(N);
}

void freeNode(Node* pN)
{
	if(pN!=NULL && *pN!=NULL)
	{
		free(*pN);
		*pN = NULL;
	}
}

//dictionary
typedef struct DictionaryObj
{
	Node head;
	int numItems;
} DictionaryObj;

Dictionary newDictionary(void)
{
	Dictionary D = malloc(sizeof(DictionaryObj));
	assert(D!=NULL);
	D->head =NULL;
	D->numItems = 0;
	return D;
}

void freeDictionary(Dictionary* pD)
{
	if (pD!=NULL&& *pD!=NULL)
	{
		if (!isEmpty(*pD)) makeEmpty(*pD);
		free(*pD);
		*pD = NULL;
	}
}

int isEmpty(Dictionary D)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling isEmpty() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	return(D->numItems==0);
}

int size(Dictionary D)
{
	return D->numItems;
}

char* lookup(Dictionary D, char* k)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling lookup() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	Node N = D->head;
	for(;N!=NULL;N=N->next)
	{
		if (strcmp(N->key, k) ==0)
		{
			return N->value;
		}
	}
	return NULL;
}

void insert(Dictionary D, char* k, char* v)
{
	if (lookup(D, k) != NULL)
	{
		fprintf(stderr, "Dictionary Error: calling insert() on a duplicate key\n");
		exit(EXIT_FAILURE);
	}

	//if first term
	if(isEmpty(D))
	{
		D->head = newNode(k, v);
		D->numItems++;
		return;
	}

	Node N = D->head;
	for(int x = 1; x < D->numItems; x++)
	{
		N= N->next;
	}

	N->next = newNode(k, v);
	D->numItems++;
}

void delete(Dictionary D, char* k)
{
	if (lookup(D, k) == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling delete() on non-existent key\n");
		exit(EXIT_FAILURE);
	}

	if(D->numItems==0)
	{
		fprintf(stderr, "Dictionary Error: calling delete() on an empty dictionary\n");
		exit(EXIT_FAILURE);
	}

	Node N = D->head;
	Node before = N;
	for(int x = 0; x < D->numItems; x++)
	{
		if(strcmp(N->key, k) == 0)
		{
			//if first term
			if(x==0)
			{
				N = D->head;
				D->head = D->head->next;
			}
			break;
		}

		before = N;
		N = N->next;
	}

	before->next = N->next;
	freeNode(&N);
	D->numItems--;
}

void makeEmpty(Dictionary D)
{
	if(D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling makeEmpty() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	if(D->numItems==0)
	{
		fprintf(stderr, "Dictionary Error: calling makeEmpty() on an empty dictionary\n");
		exit(EXIT_FAILURE);
	}

	Node N = D->head;
	Node after = NULL;
	for(;N!=NULL;N=after)
	{
		after = N->next;
		delete(D, N->key);
	}
}

void printDictionary(FILE* out, Dictionary D)
{
	if (D ==NULL)
	{
		fprintf(stderr, "Dictionary Error: calling printDictionary() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	Node N = D->head;
	for(;N!=NULL;N=N->next)
	{
		fprintf(out, "%s %s\n", N->key, N->value);
	}
}
