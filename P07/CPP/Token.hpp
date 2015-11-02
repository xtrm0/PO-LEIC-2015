#ifndef _TOKEN_HPP_
#define _TOKEN_HPP_
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef pair<int,int> pii;

class Value {
public:
  virtual string getStringValue()=0;
  virtual double getNumberValue()=0;
  friend bool operator<(Value& a, Value& b) {
    return a.getNumberValue() < b.getNumberValue();
  }
};

class StringValue {
  string value;
public:
  StringValue(string s){
    value = s;
  }
  virtual string getStringValue() {
    return value;
  }
  virtual double getNumberValue() {
    return stod(value);
  }
};

class NumberValue {
  double value;
public:
  NumberValue(double d){
    value = d;
  }
  virtual string getStringValue() {
    return to_string(value);
  }
  virtual double getNumberValue() {
    return value;
  }
};

class Token {
public:
  virtual Value* getValue()=0;
  virtual ~Token() {}
  friend bool operator<(Token& a, Token& b) {
    return *(a.getValue()) < *(b.getValue());
  }
};

class FunctionToken : public Token {
protected:
  vector<Token *> args;
public:
  virtual ~FunctionToken() {
    for (vector<Token *>::iterator it=args.begin(); it!=args.end(); it++) {
      delete (*it);
    }
  }
};

class ReferenceToken : public Token {
  map<pii, Value*>* table;
  pii coord;
public:
  ReferenceToken(map<pii, Value*>* table, pii& coord)  {
    this->table = table;
    this->coord = coord;
  }
  virtual Value* getValue() {
    if (table->count(coord))
      return table->at(coord);
    else
      return NULL;
  }
};

class LiteralToken : public Token {
  Value* value;
public:
  virtual Value* getValue() {
    return value;
  }
};


#endif
