#------------------------------------------------------------------------------
# My Makefile
# Ly Phung 
# lynphung
# 12M
# 4/4/19
# This is my makefile for the first lab that implements both class files and uses clean and submit
# Makefile
#------------------------------------------------------------------------------

JAVA 		= HelloUser.java HelloUser2.java
SOURCES 	= README Makefile $(JAVA)
MAINCLASS 	= HelloUser2
CLASSES 	= HelloUser.class HelloUser2.class
JAR 		= Hello
SUBMIT 		= submit cmps012b-pt.s19 lab1

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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab1/lynphung