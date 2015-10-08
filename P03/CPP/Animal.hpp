#ifndef _ANIMAL_HPP_
#define _ANIMAL_HPP_
#include <iostream>
#include <string>

class Animal {
  int _idade;
  std::string _nome;
public:
  Animal(int idade, std::string nome) : _idade(idade), _nome(nome) {};
  int getIdade() {return _idade;}
  void setIdade(int idade) {_idade = idade;}
  std::string getNome() {return _nome;}
  void setNome(std::string nome) {_nome = nome;}
  void dormir(int hours) {
    std::cout << *this << " dorme " << hours << " horas." << std::endl;
  }
  friend std::ostream &operator<<(std::ostream &o, const Animal &animal) {
    return o << animal._nome << " (" << animal._idade << " ano" << (animal._idade == 1 ? "" : "s") << ")";
  }
  bool operator==(const Animal &rhs) {
    return _idade == rhs._idade && _nome == rhs._nome;
  }
};




#endif
