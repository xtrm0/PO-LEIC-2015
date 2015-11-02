#ifndef _CELL_HPP_
#define _CELL_HPP_
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
class Cell {
  double value;
  boolean literal;
  string expression;
  Token * syntaxTree;
public:
  double calcValue(map<pii, double> vals) {
    value = syntaxTree.getValue();
    return value;
  }
  double getValue() {
    return value;
  }
  void setExpression(const string& expression) {
    this.expression = expression;
    if (expression.size()<0 || expression[0] != '=') { //Caso string ou celula vazia
      syntaxTree = new ZeroToken();
      literal = true;
    } else {
      literal = false;
      syntaxTree = stringToSyntaxTree(expression);
    }
  }
  ~Cell() {
    delete syntaxTree;
  }
  friend ostream& operator<<(ostream& os, const Cell& c) {
    if (literal) {
      os << c.expression;
    } else {
      os << c.getValue();
    }
    return os;
  }
}

#endif
