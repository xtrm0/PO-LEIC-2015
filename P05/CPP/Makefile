a.out: main.o
		g++ -std=c++11 -Wall main.o

main.o: main.cpp Table.hpp Printer.hpp
		g++ -std=c++11 -Wall -g -c main.cpp -o main.o

clean:
		rm *.o a.out
