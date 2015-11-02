#ifndef _TABLE_HPP_
#define _TABLE_HPP_
#include <bits/stdc++.h>
#include "Cell.hpp"
using namespace std;
typedef pair<int,int> pii;

class Table {
  map<pii, Cell*> cells;
  map<pii, Value*> vals;
public:

  void calc() {
    //TODO: calcula a topological sort das cells com base nas references (not actually pois acho que nao importa para PO)
    //Tudo o que nao obtiver indice na toposort e invalido (ciclo de referencias)
    //De resto, calcula as celulas validas:
    vals.clear();
    for(map<pii, Cell*>::iterator it = cells.begin(); it != cells.end(); ++it) {
      vals[it->first] = it->second->getValue();
    }
  }

  void addCell(pii coord, Cell * c) {
    if (cells.count(coord)) delete cells[coord];
    cells[coord] = c;
  }

  friend ostream& operator<<(ostream& os, Table& c) {
    c.calc();
    for(map<pii, Cell*>::iterator it = c.cells.begin(); it != c.cells.end(); ++it) {
      os << "(" << it->first.first << ", " << it->first.second << "): " << c.vals[it->first] << endl;
    }
    return os;
  }

};

#endif
