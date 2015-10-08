#ifndef _CAO_HPP_
#define _CAO_HPP_

#include "Animal.hpp"

class Cao : public Animal {
  double _peso;
public:
  Cao(int idade, std::string nome, double peso) : Animal(idade, nome), _peso(peso) {};
  double getPeso() {return _peso;}
  void setPeso(double peso) {_peso = peso;}
  void ladrar() {
    std::cout << *this << ": bark bark ruf ruf" << std::endl;
  }
  friend std::ostream &operator<<(std::ostream &o, const Cao &cao) {
    return o << (Animal) cao << " (um cão com " << cao._peso << " kilos)";
  }
  bool operator==(const Cao &rhs) {
    return (Animal)*this == (Animal)rhs && _peso == rhs._peso;
  }
};

#endif
