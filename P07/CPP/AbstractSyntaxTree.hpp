#ifndef _ABSTRACT_SYNTAX_TREE_HPP_
#define _ABSTRACT_SYNTAX_TREE_HPP_
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef pair<int, int> pii;
//vamos usar sempre doubles para simplificar as contas, mas podiamos usar um
//value_type, para representar tipos diferentes de valores
//mas isso apenas ia tornar o codigo mais diferente

//TODO Adicionar funcoes de libertar memoria
extern static ull counter;
//para avaliar uma folha, vamos ter de criar uma ordenacao topologica das celulas
//e avalialas por essa ordem O(n), havera certamente celulas que nao cumprem os
//requisitos do toposort, e portanto ficam com o valor NAN

class Token {
public:
  virtual double getValue()=0;
}
class ErrorToken : public token {
public: virtual double getValue() {
    return nan;
  }
}
class ZeroToken : public token {
public: virtual double getValue() {
    return 0;
  }
}

class NumberToken : public Token {
  double value;
public:
  NumberToken(string s) {
    try {
      value = stod(s);
    } catch (const exception& e) {
      value = nan;
    }
  }
  virtual double getValue() {
    return value;
  }
}

class AdditionToken : public Token {
  Token *a, *b;
public:
  AdditionToken(Token *a, Token *b) {
    this.a = a;
    this.b = b;
  }
  virtual double getValue() {
    return a.getValue() + b.getValue();
  }
};
class SubtractionToken : public Token {
  Token *a, *b;
public:
  SubtractionToken(Token *a, Token *b) {
    this.a = a;
    this.b = b;
  }
  virtual double getValue() {
    return a.getValue() - b.getValue();
  }
};
class MultiplicationToken : public Token {
  Token *a, *b;
public:
  MultiplicationToken(Token *a, Token *b) {
    this.a = a;
    this.b = b;
  }
  virtual double getValue() {
    return a.getValue() * b.getValue();
  }
};
class DivisionToken : public Token {
  Token *a, *b;
public:
  DivisionToken(Token *a, Token *b) {
    this.a = a;
    this.b = b;
  }
  virtual double getValue() {
    return a.getValue() / b.getValue();
  }
};
class ExponentiationToken : public Token {
  Token *a, *b;
public:
  ExponentiationToken(Token *a, Token *b) {
    this.a = a;
    this.b = b;
  }
  virtual double getValue() {
    return math.pow(a.getValue(), b.getValue());
  }
}

class FunctionToken : public Token {
protected:
  vector<Token *> arguments;
public:
  FunctionToken(const vector<Token *>& arguments) {
    this.arguments = arguments;
  }
};

class AdditionFunctionToken : public FunctionToken {
public:
  AdditionFunctionToken(const vector<Token *>& arguments) : FunctionToken(arguments) {}
  virtual double getValue() {
    double ans = 0;
    for (vector<Token *>::iterator it = arguments.begin(); it != arguments.end(); it++) {
      ans += (*it)->getValue();
    }
    return ans;
  }
};

class AverageFunctionToken : public FunctionToken {
public:
  AverageFunctionToken(const vector<Token *>& arguments) : FunctionToken(arguments) {}
  virtual double getValue() {
    double ans = 0;
    for (vector<Token *>::iterator it = arguments.begin(); it != arguments.end(); it++) {
      ans += (*it)->getValue();
    }
    return ans / arguments.size();
  }
};

class CellToken : public Token {
protected:
  map<pii, double>* mapper;
  pii coordinate;
public:
  CellToken(int x, int y, map<pii, double>* mapper) {
    this.mapper = mapper;
    coordinate.first = x;
    coordinate.seconds = y;
  }
  virtual double getValue() {
    return mapper[coordinate];
  }
}

/*
  Transforma uma string numa syntax tree, se for valida a conversao
*/
const pst readToken(const string& expr, int* pos);
Token * stringToSyntaxTree (const string& expr);
Token * addFunction(string value, const vector<Token*> args)
#endif
