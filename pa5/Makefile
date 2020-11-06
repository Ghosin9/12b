#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12B
# 5/30/19
# Makefile for Dictionary.c that runs the program and submits the files
# Makefile
#------------------------------------------------------------------------------


ADT     = Dictionary
EXEBIN  = $(ADT)Client
SOURCES = $(ADT).c $(EXEBIN).c
OBJECTS = $(ADT).o $(EXEBIN).o
HEADERS = $(ADT).h

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

submit:
	submit cmps012b-pt.s19 pa5 $(SOURCES) $(HEADERS) README Makefile DictionaryTest.c

check_submit:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/pa5/lynphung

check:
	valgrind --leak-check=full $(EXEBIN) 