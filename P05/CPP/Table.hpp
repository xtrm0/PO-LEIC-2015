#ifndef _TABLE_H_
#define _TABLE_H_
#include <iostream>
#include <string>
#include <vector>
#include "Printer.hpp"

class Table {
  std::vector<int> values;
public:
  Table(int n) : values(n,0) {}
  Table(std::initializer_list<int> l) : values(l) {}
  void setValue(size_t index, int val) {
    if (index<0 || index>=values.size())
      throw std::out_of_range("Index out of range");
    values[index] = val; //std::vector::operator[] has no-throw guarantee
    //std::vector::at throws std::out_of_range if we try to write to an element with index >= values.size(), with strong guarantee
    //therefore nothing is need to do here
  }
  void print(Printer& printer) {
    for (uint i=0; i<values.size(); i++) {
      std::cout << printer.format(values[i]) << std::endl;
    }
  }
};


#endif
