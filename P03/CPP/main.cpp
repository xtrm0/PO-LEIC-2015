#include "Gato.hpp"
#include "Cao.hpp"


int main() {
  /*
    Neste primeiro C++ e importante que evitema o maximo instanciacoes desnecessarias.
    Dito por outras palavras, sempre que possivel devem passar os argumentos por referencia (usando &) ou como ponteiros (usando *)
  */
  Gato g1(1, "Fonfon", 7);
  Gato g2(1, "Fonfon", 7);
  std::cout << g1 << std::endl;
  std::cout << g2 << std::endl;
  std::cout << (g1==g2) << std::endl; //true
  Cao c1(2, "Max", 40.333);
  Cao c2(2, "Rex", 41.333);
  Cao c3(2, "Max", 40.333);
  std::cout << c1 << std::endl;
  std::cout << c2 << std::endl;
  std::cout << c3 << std::endl;
  std::cout << (c1==c2) << std::endl; //false
  std::cout << (c1==c3) << std::endl; //true

  //std::cout << (c1==g1) << std::endl; //undefined because we cant compare Gato with Cao (we havent define such a comparrision function)
  std::cout << ((Animal)c1 == (Animal)g1) << std::endl; //false
  Cao c4(1, "Fonfon", 40.333);
  std::cout << ((Animal)c4 == (Animal)g1) << std::endl; //true, we are using animal comparators

  g1.trepar();
  c4.ladrar();
  g1.Gato::trepar();
  g1.dormir(3);
  //std::cout << (g1.Animal == c4.Animal) << std::endl; //invalid, typecasts cant be done this way

}
