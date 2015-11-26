#!/bin/sh
JAVADIR=/usr/share/java
PROJDIR=/home/xtrm0/poproj/project/
TESTDIR=/home/xtrm0/poproj/project/tests/x0tests
TEST=X0-002-01
cd $TESTDIR/out
pwd
java -Dimport="$TESTDIR/$TEST.import" -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar"  edt.textui.TextEditor
#-Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out"
cat $TESTDIR/out/$TEST.out
