#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 5/2/19
# Makefile for charType.c that runs the program and submits the files
# Makefile
#------------------------------------------------------------------------------

PROGRAM_NAME = charType
FLAGS = -std=c99 -Wall
SOURCES = $(PROGRAM_NAME).c
OBJECTS = $(PROGRAM_NAME).o
EXEBIN = $(PROGRAM_NAME)

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean:
	rm -f $(EXEBIN) $(OBJECTS)

submit:
	submit cmps012b-pt.s19 lab4 $(SOURCES) README Makefile

check:
	valgrind --leak-check=full charType charType.c outfile

check_submit:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab4/lynphung