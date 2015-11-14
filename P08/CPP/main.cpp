#include "Cat.hpp"

int main() {
  //1) cria dois gatos (“Tareco” com 2 anos e “Pantufa” com 6 meses);
  Cat *g1, *g2;
  g1 = new Cat(24, "Tareco");
  g2 = new Cat(6, "Pantufas");

  //2) escreve os gatos para um std::stringstream
  stringstream ss;
  ss << *g1 << *g2;

  //3) cria dois gatos não inicializados;
  Cat *g3, *g4;
  g3 = new Cat;
  g4 = new Cat;

  //4) recupera os dois primeiros gatos do stream para os objectos recém criados (que não estavam inicializados)
  ss >> *g3 >> *g4;

  //6) apresenta-os na saída (std::cout)
  cout << *g3;
  cout << *g4;

  //free memory:
  delete g1;
  delete g2;
  delete g3;
  delete g4;
}
