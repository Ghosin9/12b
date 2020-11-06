#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 4/17/19
# Makefile for file reverse make file that creates the jar
# Makefile
#------------------------------------------------------------------------------

JAVA 		= FileReverse.java
SOURCES 	= README Makefile $(JAVA)
MAINCLASS 	= FileReverse
CLASSES 	= FileReverse.class
JAR 		= FileReverse
SUBMIT 		= submit cmps012b-pt.s19 lab2

#all: calls for all files after the colon to be called:
all: $(JAR)

$(JAR): $(CLASSES)
	echo Main-Class: $(MAINCLASS) > Manifest
	jar cvfm $(JAR) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JAR)

$(CLASSES): $(JAVA)
	javac -Xlint $(JAVA)

clean: 
	rm $(CLASSES) $(JAR)

submit:
	$(SUBMIT) $(SOURCES)

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab2/lynphung