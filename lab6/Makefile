#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 5/19/19
# Makefile that creates the jar file for List.java
# Makefile
#------------------------------------------------------------------------------

# Variables
JARFILE    = ListClient
MAINCLASS  = ListClient
SOURCES    = ListInterface.java ListIndexOutOfBoundsException.java List.java \
             ListClient.java
CLASSES    = ListInterface.class ListIndexOutOfBoundsException.class \
             List.class List\$$Node.class ListClient.class

# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm -f Manifest $(CLASSES)
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)

# Phony Targets
clean:
	rm -f $(JARFILE) $(CLASSES) ListTest.class

run:
	java -jar $(JARFILE) > my-out

diff:
	diff my-out model-out

submit:
	submit cmps012b-pt.s19 lab6 $(SOURCES) Makefile README ListTest.java

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab6/lynphung