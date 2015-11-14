#!/bin/bash
#ficheiro que corre todos os testes automaticamente no pc
#este ficheiro encontra-se em project/tests/tests-ei-daily-201511091433

JAVADIR=/usr/share/java
CURR=`pwd`

#corre os testes:

#tests-ei-daily-201511091433:
tput sgr0
echo -e "\e[34m"
echo "Running tests"
tput sgr0
for i in $( ls | grep ".in" );
        do
                TEST=${i%.in}
                cd $CURR/../../edt-textui/src;
                echo $TEST;
                if [ -e $CURR/$TEST.import ]
                        then
                                java -Dimport=$CURR/$TEST.import -cp $JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:../../edt-core/edt-core.jar:../../edt-textui/edt-textui.jar -Dout=../../tests/tests-ei-daily-201511091433/out/$TEST.out -Din=../../tests/tests-ei-daily-201511091433/$TEST.in edt.textui.TextEditor
                        else
                                java -cp $JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:../../edt-core/edt-core.jar:../../edt-textui/edt-textui.jar -Din=../../tests/tests-ei-daily-201511091433/$TEST.in -Dout=../../tests/tests-ei-daily-201511091433/out/$TEST.out edt.textui.TextEditor
                fi
        done

#faz os diffs:
tput sgr0
echo -e "\e[34m"
echo "Diffing stuff"
tput sgr0
cd $CURR
for i in $( ls | grep ".in" );
        do
                TEST=${i%.in}
                tput sgr0
                echo -ne "\e[34m"
                echo $TEST
                tput sgr0
                diff ./expected/$TEST.out ./out/$TEST.out | colordiff
                tput sgr0
        done

tput sgr0
