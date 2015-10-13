#ifndef _GATO_HPP_
#define _GATO_HPP_

#include "Animal.hpp"

class Gato : public Animal {
  int _vidas;
public:
  Gato(int idade, std::string nome, int vidas) : Animal(idade, nome), _vidas(vidas) {};
  int getVidas() {return _vidas;}
  void setVidas(int vidas) {_vidas = vidas;}
  void trepar() {
    std::cout << *this << " trepou" << std::endl;
  }
  friend std::ostream &operator<<(std::ostream &o, const Gato &gato) {
    return o << (Animal&) gato << " (um gato com " << gato._vidas << " vidas)";
  }
  bool operator==(const Gato &rhs) {
    return (Animal&)*this == rhs && _vidas == rhs._vidas;
  }
};

#endif
