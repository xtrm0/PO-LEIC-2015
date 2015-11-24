#!/bin/sh
JAVADIR=/usr/share/java
PROJDIR=/home/xtrm0/poproj/project/
TESTDIR=/home/xtrm0/poproj/project/tests/tests-ef-daily-201511231748
TEST=A-016-002-M-ok
cd $TESTDIR/out
pwd
java -Dimport="$TESTDIR/$TEST.import" -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar"  -Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out" edt.textui.TextEditor
cat $TESTDIR/out/$TEST.out
