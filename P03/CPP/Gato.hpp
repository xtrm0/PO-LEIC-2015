#ifndef _GATO_HPP_
#define _GATO_HPP_

#include "Animal.hpp"

class Gato : public Animal {
  int _vidas;
public:
  Gato(int idade, std::string nome, int vidas);
  int getVidas();
  void setVidas(int vidas);
  void trepar();
  friend std::ostream &operator<<(std::ostream &o, const Gato &gato);
  bool operator==(const Gato &rhs);
};

#endif
