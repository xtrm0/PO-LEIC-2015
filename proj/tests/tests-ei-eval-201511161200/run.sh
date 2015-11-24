#!/bin/bash
#ficheiro que corre todos os testes automaticamente no pc

JAVADIR=/usr/share/java
PROJDIR=`pwd`/../../project
TESTDIR=`pwd`

set -e

#corre os testes:


tput sgr0
echo -ne "\e[34m"
echo "Running tests"
tput sgr0

rm -rf "$TESTDIR/out" #this always looks scary
mkdir -p "$TESTDIR/out"
cd "$TESTDIR"

for i in *.in;
        do
                TEST=${i%.in}
                cd "$TESTDIR/out";
                echo "$TEST";
                if [ -e "$TESTDIR/$TEST.import" ]
                        then
                                java -Dimport="$TESTDIR/$TEST.import" -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar"  -Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out" edt.textui.TextEditor
                        else
                                java -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar" -Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out" edt.textui.TextEditor
                fi
        done

#faz os diffs:
tput sgr0
echo -e "\e[34m"
echo "Diffing stuff"
tput sgr0
cd "$TESTDIR"
for i in *.in;
        do
                TEST=${i%.in}
                tput sgr0
                echo -ne "\e[34m"
                echo "$TEST"
                tput sgr0
                diff "./expected/$TEST.out" "./out/$TEST.out" | colordiff
                tput sgr0
        done


tput sgr0
