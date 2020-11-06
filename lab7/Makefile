#------------------------------------------------------------------------------
# Ly Phung 
# lynphung
# 12M
# 5/28/19
# Makefile that creates the jar file for Dictionary.java
# Makefile
#------------------------------------------------------------------------------


JAVAC      = javac 
MAINCLASS  = DictionaryClient
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS) 


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm *.class $(JARFILE)

submit: 
	submit cmps012b-pt.s19 lab7 $(SOURCES)

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab7/lynphung