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
  We considered implementing some derived classes as singletons, as we'll never need
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
    return "[" + std::to_string(i) + "]";
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
  //Non C++11 way:
  std::string format(int i) {
    std::ostringstream ss;
    ss << i << " " << i;
    return ss.str();
  }
private:
  /*DoublePrinter (DoublePrinter const&);
  void operator=  (DoublePrinter const&) = delete;*/
};

class NthPrinter : public Printer {
  int N;
public:
  NthPrinter(int n) : N(n) {};
  std::string format(int i) {
    int n = N;
    std::ostringstream ss;
    if (n--)
      ss << i;
    while (n--)
      ss << " " << i;
    return ss.str();
  }
};
#endif
