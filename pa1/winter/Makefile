#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 1/18/19
# Makefile that created the jar file for Search.java
# Makefile
#------------------------------------------------------------------------------

JAVA 		= Search.java
SOURCES 	= README Makefile $(JAVA)
MAINCLASS 	= Search
CLASSES 	= Search.class
JAR 		= Search
SUBMIT 		= submit cmps012b-pt.w19 pa1

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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.w19/pa1/lynphung