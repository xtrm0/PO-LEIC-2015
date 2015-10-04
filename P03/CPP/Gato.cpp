#include "Gato.hpp"
Gato::Gato(int idade, std::string nome, int vidas) : Animal(idade, nome), _vidas(vidas) {};
int Gato::getVidas() {return _vidas;}
void Gato::setVidas(int vidas) {_vidas = vidas;}
void Gato::trepar() {
  std::cout << *this << " trepou" << std::endl;
}
bool Gato::operator==(const Gato &rhs) {
  return (Animal)*this == (Animal)rhs && _vidas == rhs._vidas;
}
std::ostream &operator<<(std::ostream &o, const Gato &gato) {
  return o << (Animal) gato << " (um gato com " << gato._vidas << " vidas)";
}
