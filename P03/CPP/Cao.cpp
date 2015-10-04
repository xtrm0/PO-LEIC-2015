#include "Cao.hpp"
Cao::Cao(int idade, std::string nome, double peso) : Animal(idade, nome), _peso(peso) {};
double Cao::getPeso() {return _peso;}
void Cao::setPeso(double peso) {_peso = peso;}
void Cao::ladrar() {
  std::cout << *this << ": bark bark ruf ruf" << std::endl;
}
bool Cao::operator==(const Cao &rhs) {
  return (Animal)*this == (Animal)rhs && _peso == rhs._peso;
}
std::ostream &operator<<(std::ostream &o, const Cao &cao) {
  return o << (Animal) cao << " (um cão com " << cao._peso << " kilos)";
}
