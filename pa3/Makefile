#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12B
# 4/27/19
# Makefile that creates the jar file for DictionaryClient.java
# Makefile
#------------------------------------------------------------------------------

JAVAC      = javac 
MAINCLASS  = DictionaryClient
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS)
SUBMIT     = submit cmps012b-pt.s19 pa3


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)
	
submit:
	$(SUBMIT) $(SOURCES)

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/pa3/lynphung