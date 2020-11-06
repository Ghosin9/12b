/*
* Dictionary.c
* Ly Phung
* lynphung
* 12B
* 5/30/19
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

const int tableSize=101;
// rotate_left()
// rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) 
{
	int sizeInBits = 8*sizeof(unsigned int);
 	shift = shift & (sizeInBits - 1);
 	if ( shift == 0 )
 	return value;
 	return (value << shift) | (value >> (sizeInBits - shift));
}

// pre_hash()
// turn a string into an unsigned int
unsigned int pre_hash(char* input) 
{
 	unsigned int result = 0xBAE86554;
 	while (*input) 
 	{
	 	result ^= *input++;
	 	result = rotate_left(result, 5);
	}
 	return result;
}

// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key)
{
 	return pre_hash(key)%tableSize;
}

//dictionary
typedef struct DictionaryObj
{
	Node* table;
	int numItems;
} DictionaryObj;

Dictionary newDictionary(void)
{
	Dictionary D = malloc(sizeof(DictionaryObj));
	assert(D!=NULL);
	D->table = calloc(tableSize, sizeof(NodeObj));
	for(int x=0; x<tableSize; x++)
	{
		D->table[x] = NULL;
	}
	D->numItems = 0;
	return D;
}

void freeDictionary(Dictionary* pD)
{
	if (pD!=NULL&& *pD!=NULL)
	{
		if (!isEmpty(*pD))
			makeEmpty(*pD);
		free((*pD)->table);
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
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling size() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	return D->numItems;
}

char* lookup(Dictionary D, char* k)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling lookup() on a NULL Dictionary reference\n");
	}

	int index = hash(k);
	Node N = D->table[index];
	for(; N!=NULL; N=N->next)
	{
		if(strcmp(N->key, k) == 0)
			return N->value;
	}
	return NULL;
}

void insert(Dictionary D, char* k, char* v)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling insert() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	if (lookup(D, k) != NULL)
	{
		fprintf(stderr, "Dictionary Error: calling insert() on a duplicate key\n");
		exit(EXIT_FAILURE);
	}

	int index = hash(k);
	//only term in hash(k)
	if (D->table[index] == NULL)
	{
		D->table[index] = newNode(k, v);
	}
	else //if there are other terms in hash(k)
	{
		Node N = D->table[index];
		D->table[index] = newNode(k, v);
		D->table[index]->next = N;
	}
	D->numItems++;
}

void delete(Dictionary D, char* k)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling delete() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	if (lookup(D, k) == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling delete() on a non-existent key\n");
		exit(EXIT_FAILURE);
	}

	int index = hash(k);
	Node N = D->table[index];
	Node before = N;
	for(; N!= NULL; N=N->next)
	{
		if (strcmp(N->key, k) == 0)
		{
			//if first term in list
			if(strcmp(N->key, D->table[index]->key)== 0)
			{
				D->table[index] = D->table[index]->next;
			}
			else
			{
				before->next = N->next;
			}
			break;
		}

		before = N;
	}

	freeNode(&N);
	N = NULL;
	D->numItems--;
}

void makeEmpty(Dictionary D)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling makeEmpty() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	for(int x=0; x<tableSize; x++)
	{
		Node N = D->table[x];
		Node after = NULL;
		for(;N!=NULL;N=after)
		{
			after = N->next;
			delete(D, N->key);
		}
	}
}

void printDictionary(FILE* out, Dictionary D)
{
	if (D == NULL)
	{
		fprintf(stderr, "Dictionary Error: calling printDictionary() on a NULL Dictionary reference\n");
		exit(EXIT_FAILURE);
	}

	for(int x=0; x<tableSize; x++)
	{
		Node N = D->table[x];
		for(;N!=NULL;N=N->next)
		{
			fprintf(out, "%s %s\n", N->key, N->value);
		}
	}
}