#include "Table.hpp"
#include "Printer.hpp"
int main() {
  BracketsPrinter bPInstance;
  DoublePrinter dPInstance;
  NthPrinter nPInstance(10);
  //Initializes a table with 10 default elements(0)
  Table t(10);
  t.print(bPInstance);
  t.print(dPInstance);

  //Initializes a table with an std::argument_list
  Table t2({0,1,2,3,4,5,6,7,8,9});
  t2.print(bPInstance);
  t2.print(dPInstance);
  t2.print(nPInstance);

  //Example on std::vector calling the Table constructor on std::vector::push_back
  std::vector<Table> Tn;
  Tn.push_back(t);
  t.setValue(0,10);
  Tn[0].print(bPInstance);
  t.print(bPInstance);


  /*
  Same code using singletons:
  //Initializes a table with 10 default elements(0)
  Table t(10);
  t.print(BracketsPrinter::getInstance());
  t.print(DoublePrinter::getInstance());

  //Initializes a table with an std::argument_list
  Table t2({1,2,3,4,5,6,7,8,9,10});
  t2.print(BracketsPrinter::getInstance());
  t2.print(DoublePrinter::getInstance());

  //Example on std::vector calling the Table constructor on std::vector::push_back
  std::vector<Table> Tn;
  Tn.push_back(t);
  t.setValue(0,10);
  Tn[0].print(BracketsPrinter::getInstance());
  t.print(BracketsPrinter::getInstance());
  */
}
