#!/bin/bash
#ficheiro que corre todos os testes automaticamente no pc
PROJDIR=`pwd`/../project
TESTDIR=`pwd`

set -e

if [ $# -eq 0 ]; #we should probably use getopt here, but duck it
  then
    echo "Not compiling!";
  else
    echo "Cleaning and compiling..."
    cd "$PROJDIR"
    make clean
    make
  fi

set +e

#corre os testes:
tput sgr0
echo -e "\e[36m"
echo "Running all the tests:"
tput sgr0

cd "$TESTDIR"

for i in `echo */`;
        do
                echo -ne "\e[0;33m"
                echo "Running test $i:"
                tput sgr0
                cd "$TESTDIR"
                cp ./run-test.sh.proto $i/run.sh
                chmod +x $i/run.sh
                cd $i;
                ./run.sh;
                echo;
        done
