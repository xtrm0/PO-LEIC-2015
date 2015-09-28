#ifndef _ANIMAL_HPP_
#define _ANIMAL_HPP_
#include <iostream>
#include <string>

class Animal {
  int _idade;
  std::string _nome;
public:
  Animal(int idade, std::string nome) : _idade(idade), _nome(nome) {};
  int getIdade();
  void setIdade(int idade);
  std::string getNome();
  void setNome(std::string nome);
  friend std::ostream &operator<<(std::ostream &o, const Animal &animal);
  bool operator==(const Animal &rhs);
};




#endif
