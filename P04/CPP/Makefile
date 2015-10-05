deps = Motor.o Car.o main.o

all: $(deps)
		g++ -std=c++11 -Wall $(deps)

%.o: %.cpp
		g++ -std=c++11 -Wall -g -c $< -o $@

clean:
		rm *.o a.out
