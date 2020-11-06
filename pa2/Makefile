#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12B
# 4/17/19
# Makefile that creates the jar file for Queens.java
# Makefile
#------------------------------------------------------------------------------

JAVA 		= Queens.java
SOURCES 	= README Makefile $(JAVA)
MAINCLASS 	= Queens
CLASSES 	= Queens.class
JAR 		= Queens
SUBMIT 		= submit cmps012b-pt.s19 pa2

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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/pa2/lynphung