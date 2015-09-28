all: Gato.o Animal.o Cao.o main.o
		g++ -std=c++11 -Wall Animal.o Gato.o main.o Cao.o

%.o: %.c
		$(CC) $(FLAGS) $< -o $@

clean:
		rm *.o a.out
