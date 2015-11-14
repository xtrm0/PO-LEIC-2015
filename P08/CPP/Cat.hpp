#ifndef _CAT_HPP_
#define _CAT_HPP_
#include <bits/stdc++.h>
using namespace std;
class Cat {
  int age;
  string name;
public:
  Cat() {
    age = 0;
    name = string("anónimo");
  }
  Cat(int age, const string& name) {
    if ([](const string&x) -> bool {for (auto i: x) if (isblank(i)) return true; return false;}(name))
    throw invalid_argument("A cat name has no spaces!!!");
    this->age = age;
    this->name = name;
  }
  int getAge() {return age;}
  string getName() {return name;}
  void setAge(int age) {this->age = age;}
  void setName(string name) {this->name = name;}
  friend ostream& operator<<(ostream& os, const Cat &c){
    os << c.age << " " << c.name << endl;
    return os;
  }
  friend istream& operator>>(istream& os, Cat &c){
    os >> c.age;
    os >> c.name; //estamos a assumir que o name nao tem espacos
    return os;
  }
};

#endif
