#ifndef _CAO_HPP_
#define _CAO_HPP_

#include "Animal.hpp"

class Cao : public Animal {
  double _peso;
public:
  Cao(int idade, std::string nome, double peso);
  double getPeso();
  void setPeso(double peso);
  void ladrar();
  friend std::ostream &operator<<(std::ostream &o, const Cao &Cao);
  bool operator==(const Cao &rhs);
};

#endif
