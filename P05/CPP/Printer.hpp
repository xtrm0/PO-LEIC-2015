#ifndef _PRINTER_H_
#define _PRINTER_H_
#include <string>
#include <vector>
#include <sstream>
#include "Printer.hpp"

class Printer {
public:
  virtual std::string format(int)=0;
};

/*
  We considered implementing this derived classes as singletons, as we'll never need
  more than one instance of the same class ever. The perfect way would be to use
  a static class, but there is no such thing in C++. Another way would be a global
  static object, but we wanted to avoid writing another .cpp file.
  The best way would be to use just function pointers, but that is not OOP.
*/
class BracketsPrinter : public Printer {
public:
  /*
  static BracketsPrinter& getInstance() {
    static BracketsPrinter instance;
    return instance;
  }*/
  std::string format(int i) {
    std::string s;
    std::stringstream ss;
    ss << "[" << i << "]";
    ss >> s;
    return s;
  }
private:
  /*BracketsPrinter (BracketsPrinter const&);
  void operator=  (BracketsPrinter const&) = delete;*/
};

class DoublePrinter : public Printer {
public:
  /*
  static DoublePrinter& getInstance() {
    static DoublePrinter instance;
    return instance;
  }*/
  std::string format(int i) {
    std::string s;
    std::stringstream ss;
    ss << i << " " << i;
    ss >> s;
    return s;
  }
private:
  /*DoublePrinter (DoublePrinter const&);
  void operator=  (DoublePrinter const&) = delete;*/
};
#endif
