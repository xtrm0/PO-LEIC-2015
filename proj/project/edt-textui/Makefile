JAVADIR=/usr/share/java
JARNAME=edt-textui

all:
	(cd src; javac -encoding UTF-8 -cp $(JAVADIR)/po-uilib.jar:$(JAVADIR)/edt-support.jar:../../edt-core/edt-core.jar `find . -name \*.java`)
	(cd src; jar cvf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java`)

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`

install:
	/bin/cp $(JARNAME).jar $(JAVADIR)

run: all
	(cd src; java -cp $(JAVADIR)/po-uilib.jar:$(JAVADIR)/edt-support.jar:../../edt-core/edt-core.jar:../../edt-textui/edt-textui.jar edt.textui.TextEditor)

testrun: all
		(cd src; java -cp $(JAVADIR)/po-uilib.jar:$(JAVADIR)/edt-support.jar:../../edt-core/edt-core.jar:../../edt-textui/edt-textui.jar edt.textui.TextEditor < ../../tests/test.in.1)

runwithimport:
	(cd src; java -Dimport=test.import -cp $(JAVADIR)/po-uilib.jar:$(JAVADIR)/edt-support.jar:../../edt-core/edt-core.jar:../../edt-textui/edt-textui.jar edt.textui.TextEditor)
