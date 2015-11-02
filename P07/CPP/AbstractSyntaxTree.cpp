#include "AbstractSyntaxTree.hpp"
#include "CoolPreprocessorTrick.hpp"

#define CASO(i, start, _) case ((char)start+i):
#define CASOS(start, len)  EVAL(REPEAT(len, CASO, start, ~))
enum TOKEN_TYPE {TOKEN_NUMBER, TOKEN_FUNCTION, TOKEN_BINARY_OPERATOR, TOKEN_UNARY_OPERATOR, TOKEN_PAREN_OPEN, TOKEN_PAREN_CLOSE, TOKEN_SEPARATOR, TOKEN_INVALID};

typedef pair<string, TOKEN_TYPE> pst;

const pst readToken(const string& expr, int* pos) {
  int hasDot = 0;
  string ans = "";
  //primeiro ignoramos whitespaces
  while ((*pos) != expr.size() && expr[*pos] == " ") (*pos)++;
  if ((*pos) == expr.size()) return ans;
  //caso operadores simples:
  switch (expr[*pos]) {
    //Operator
    case '+': case '-': case '*': case '/': case: '^':
      (*pos)++;
      return pst(string((*pos)-1), TOKEN_BINARY_OPERATOR);
      break;

    //Function
    CASOS('a', 26)
    CASOS('A', 26)
    case '_':
      while ((*pos) != expr.size()) {
        if(!isalpha(expr[*pos]) && expr[*pos]!='_') return pst(ans, TOKEN_FUNCTION);
        ans += expr[*pos];
        (*pos)++;
      }
      break;

    //Parentesis open
    case '(':
      (*pos)++;
      return pst(string((*pos)-1), TOKEN_PAREN_OPEN);
      break;

    //Parenthesis close
    case ')':
      (*pos)++;
      return pst(string((*pos)-1), TOKEN_PAREN_CLOSE);
      break;

    //Separator:
    case ',':
      (*pos)++;
      return pst(string((*pos)-1), TOKEN_SEPARATOR);
      break;

    //Number:
    CASO('0', 10)
      hasDot = 0; //Estamos apenas a processar doubles sem expoente
      while ((*pos) != expr.size()) {
        if(!isnum(expr[*pos]) && expr[*pos]!='.') return pst(ans, TOKEN_NUMBER);
        if (expr[*pos]=='.') {
          if (hasDot) return pst(ans, TOKEN_NUMBER);
          else if (ans.size()==0) ans += "0"
        }
        ans += expr[*pos];
        (*pos)++;
      }
      break;

    case default:
      return pst("", TOKEN_INVALID); //caracter invalido!!!
  }

}

Token * stringToSyntaxTree (const string& expr) {
  int pos = 1;

  /*Step 1: Gets the expression in RPN*/
  //NOTE: only basic error checking is made, some irregular expressions might be parsed as valid //XXX: this is a lie :P
  stack<pst> rails();
  stack<int> fargcount();
  vector<pst> output();
  vector<int> output_argcount();
  pst tok;
  while (pos != expr.size()) {
    tok = readToken(expr, &pos);

    if (tok.second==TOKEN_NUMBER) {
      output.push_back(tok);
      continue;
    }

    if (tok.second==TOKEN_FUNCTION) {
      rails.push(tok);
      fargcount.push(0);
      continue;
    }

    if (tok.second == TOKEN_PAREN_OPEN {
      rails.push(tok);
      continue;
    }

    if (tok.second == TOKEN_PAREN_CLOSE) {
      int plusone;
      while(true) { //E a melhor forma de escrever este loop sem repetir a condicao if rails.empty()
        if (rails.empty()) return ErrorToken();
        if (rails.top() == "(") break;
        plusOne=1;
        output.push_back(rails.top());
        rails.pop();
      }
      rails.pop();
      if (!rails.empty() && rails.top().second == TOKEN_FUNCTION) {
        if (plusOne) {
          fargcount.top()++;
        } else {
          if (fargcount > 0)
            return ErrorToken(); //os argumentos das funcoes nao podem ser espacos em branco
        }
        output.push_back(rails.top());
        output_argcount.push_back(fargcount.top());
        rails.pop(); fargcount.pop();
      }
      continue;
    }

    if (tok.second == TOKEN_SEPARATOR) {
      while(true) { //E a melhor forma de escrever este loop sem repetir a condicao if rails.empty()
        if (rails.empty()) return ErrorToken();
        if (rails.top().second == TOKEN_PAREN_OPEN) break;
        output.push_back(rails.top());
        rails.pop();
      }
      fargcount.top()++;
      continue;
    }

    if (tok.second == TOKEN_UNARY_OPERATOR || tok.second == TOKEN_BINARY_OPERATOR) {
      if (!rails.empty() && (rails.top().second == TOKEN_UNARY_OPERATOR || rails.top().second == TOKEN_BINARY_OPERATOR)) {
        if (isLeftAssociative(tok)) {
          while(precedence(tok) <= precedence(rails.top())) {
            output.push_back(rails.top());
            rails.pop();
            if (rails.empty() || !isOperator(rails.top())) break;
          }
        } else {
          while(precedence(tok) < precedence(rails.top())) {
            output.push_back(rails.top());
            rails.pop();
            if (rails.empty() || !isOperator(rails.top())) break;
          }
        }
      }
      continue;
    }
  }

  //post shutting yard: pop the rest of the stack
  while (!rails.empty()) {
    if (rails.top() == "(") return ErrorToken(); //no need to test for function, because it will always have an "(" befora
    output.push_back(rails.top());
    rails.pop();
  }


  /*Step 2: Generates a syntaxTree from the unambiguous RPN */
  //might return ErrorToken if wrong number of arguments found or missing values
  int argz=0;
  stack<Token *> tokenTree;
  Token* tmp;
  int i=0;
  for (vector<string>::const_iterator it = output.begin(); it!=output.end() it++) {
    if(it->second == TOKEN_NUMBER) {
      tokenTree.push_back(new NumberToken(it->first));
      continue;
    }
    if (it->second == TOKEN_FUNCTION) {
      vector<Token*> t = vector<Token*>();
      int j=output_argcount[i++];
      while (j--) {
        if (tokenTree.empty()) return ErrorToken();
        t.push_back(tokenTree.top());
        tokenTree.pop();
      }
      tmp = addFunction(it->first, t);
      if (tmp==NULL) return new ErrorToken();
      tokenTree.push(tmp);
    }

    if (it->second == TOKEN_BINARY_OPERATOR) {
      vector<Token *> t = vector<Token *>();
      int j=2;
      while (j--) {
        if (tokenTree.empty()) return ErrorToken();
        t.push_back(tokenTree.top());
        tokenTree.pop();
      }
      tmp = addFunction(it->first, t);
      if (tmp==NULL) return new ErrorToken();
      tokenTree.push(tmp);
    } else if (it->second == TOKEN_UNARY_OPERATOR {
      vector<Token*> t = vector<Token*>();
      if (tokenTree.empty()) return ErrorToken();
      t.push_back(tokenTree.top());
      tokenTree.pop();
      tmp = addFunction(it->first, t);
      if (tmp==NULL) return new ErrorToken();
      tokenTree.push(tmp);
    }
  }

  if (tokenTree.size()!=1) return new ErrorToken();
}

Token * addFunction(string value, const vector<Token*> args) {
  if (value == "+") {
    if (args.size()!=2) return NULL;
    return new AdditionToken(args[1], args[0]);
  }
  if (value == "*") {
    if (args.size()!=2) return NULL;
    return new MultiplicationToken(args[1], args[0]);
  }
  if (value == "/") {
    if (args.size()!=2) return NULL;
    return new DivisionToken(args[1], args[0]);
  }
  if (value == "-") {
    if (args.size()!=2) return NULL;
    return new SubtractionToken(args[1], args[0]);
  }
  if (value == "^") {
    if (args.size()!=2) return NULL;
    return new ExponentiationToken(args[1], args[0]);
  }
  if (value == "ADD") {
    if (args.size()==0) return new ZeroToken();
    reverse(args.begin(), args.end());
    return new AdditionFunctionToken(args);
  }
  if (value == "AVG") {
    if (args.size()==0) return new ZeroToken();
    reverse(args.begin(), args.end());
    return new AverageFunctionToken(args);
  }
  if (value == "SQRT") {
    if (args.size()!=1) return NULL;
    return new ExponentiationToken(args[0], 0.5);
  }
  if (value == "ROOT") {
    if (args.size()!=2) return NULL;
    if (args[0]==0) return new ZeroToken();
    return new ExponentiationToken(args[1], 1/args[0]);
  }
  if (value == "CELL") {
    if (args.size()!=2) return NULL;
    return new CellToken(args[1], 1/args[0]); //XXX: add reference to document map
  }
  return new ErrorToken();
}
