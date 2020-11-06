#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 4/27/19
# Makefile for FileReverse.c that runs the program and submits the files
# Makefile
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
OBJECTS = FileReverse.o
EXEBIN = FileReverse

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean:
	rm -f $(EXEBIN) $(OBJECTS)

submit:
	submit cmps012b-pt.s19 lab3 $(SOURCES) README Makefile

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab3/lynphung