all: Gato.o Animal.o Cao.o main.o
		g++ -std=c++11 -Wall Animal.o Gato.o main.o Cao.o

%.o: %.cpp
		g++ -std=c++11 -Wall -g -c $< -o $@

clean:
		rm *.o a.out
