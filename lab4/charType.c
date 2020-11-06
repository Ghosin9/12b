/*
* charType.c
* Ly Phung
* lynphung
* 12M
* 5/2/19
* Reads input file and prints how many alphabetic, digital, punctuational, and whitespace chars are in each line of the file
*/

#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extract_chars(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments 
int main(int argc, char* argv[])
{
   FILE* in;			// handle for input file                  
   FILE* out;       	// handle for output file                 
   char* line;      	// string holding input line              
   char* alpha; 		// string holding all alphabetic chars
   char* digits;		// string holding all digits
   char* punctuation;	// string holding all punctuation
   char* whitespace;	// string holding all whitespace

   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and alpha_num on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alpha = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   digits = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   punctuation = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   whitespace = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && alpha!=NULL && digits!= NULL && punctuation!=NULL && whitespace!=NULL);

   int lineNumber = 1;
   // read each line in input file, extracting chars
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
   	//extracts the chars
   	extract_chars(line, alpha, digits, punctuation, whitespace);

   	fprintf(out, "line %d contains:\n", lineNumber);

   	if (strlen(alpha) == 1)
		fprintf(out, "%d alphabetical character: %s \n", strlen(alpha), alpha);
   	else
   		fprintf(out, "%d alphabetical characters: %s \n", strlen(alpha), alpha);

   	if (strlen(digits) == 1)
   		fprintf(out, "%d numeric character: %s \n", strlen(digits), digits);
   	else
   		fprintf(out, "%d numeric characters: %s \n", strlen(digits), digits);

   	if (strlen(punctuation) == 1)
   		fprintf(out, "%d punctuation character: %s \n", strlen(punctuation), punctuation);
   	else
   		fprintf(out, "%d punctuation characters: %s \n", strlen(punctuation), punctuation);

   	if (strlen(whitespace) == 1)
   		fprintf(out, "%d whitespace character: %s \n", strlen(whitespace), whitespace);
   	else
   		fprintf(out, "%d whitespace characters: %s \n", strlen(whitespace), whitespace);
   	lineNumber++;
   }

   // free heap memory 
   free(line);
   free(alpha);
   free(digits);
   free(punctuation);
   free(whitespace);
   line = NULL;
   alpha = NULL;
   digits = NULL;
   punctuation = NULL;
   whitespace = NULL;

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extract_chars(char* s, char* a, char* d, char* p, char* w)
{
	//reset chars*
	memset(a, '\0', MAX_STRING_LENGTH);
   	memset(d, '\0', MAX_STRING_LENGTH);
   	memset(p, '\0', MAX_STRING_LENGTH);
   	memset(w, '\0', MAX_STRING_LENGTH);

	int i=0, al=0, di=0, pu=0, wh=0;
	while(s[i]!='\0' && i<MAX_STRING_LENGTH)
	{
		if( isalpha(s[i]) ) 
			a[al++] = s[i];
		if (isdigit(s[i])) 
			d[di++] = s[i];
		if (ispunct(s[i]))
			p[pu++] = s[i];
		if (isspace(s[i]))
			w[wh++]= s[i];
		i++;
	}
	a[i] = '\0';
}