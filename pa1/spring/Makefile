#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12B
# 4/5/19
# Makefile that created the jar file for Subset.java
# Makefile
#------------------------------------------------------------------------------

JAVA 		= Subset.java
SOURCES 	= README Makefile $(JAVA)
MAINCLASS 	= Subset
CLASSES 	= Subset.class
JAR 		= Subset
SUBMIT 		= submit cmps012b-pt.s19 pa1

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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/pa1/lynphung