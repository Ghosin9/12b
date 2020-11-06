#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 5/11/19
# Makefile for Dictionary.c that runs the program and submits the files
# Makefile
#------------------------------------------------------------------------------

ADT_NAME  = Dictionary
SOURCES   = $(ADT_NAME).c $(ADT_NAME)Client.c
OBJECTS   = $(ADT_NAME).o $(ADT_NAME)Client.o
HEADERS   = $(ADT_NAME).h
EXEBIN    = $(ADT_NAME)Client
FLAGS     = -std=c99 -Wall

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 

submit:
	submit cmps012b-pt.s19 lab5 $(SOURCES) $(HEADERS) README Makefile DictionaryTest.c

check_submit:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab5/lynphung