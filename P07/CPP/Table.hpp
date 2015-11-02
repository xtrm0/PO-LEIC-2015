#ifndef _TABLE_HPP_
#define _TABLE_HPP_
#include <bits/stdc++.h>
#include "Cell.hpp"
using namespace std;
typedef pair<int,int> pii;

class Table {
  int valid; //indica se a mesa esta validada ou se tem de ser recalculada
  map<pii, Cell> cells; //Usamos um mapa pois assumimos que as mesas tem muito poucas celulas preenchidas
  map<pii, int> rank; //valores retornados pelo topoSort nas celulas
  map<pii, vector<pii> > topoReq; //grafo para o topoSort
  map<pii, double> calcdValues; //valores ja calculados para ir passando para as celulas calcularem
  //XXX: ha uma forma de fazer sem termos de estar sempre a recaluar a mesa quando uma celula e alterada,
  //como e facil passar para essa forma desde a formula que invalida tudo, vamos comecar por invalidar tudo

public:
  void calcTable() {
    //limpa tudo antes de comecar a fazer coisas

    int maxRank=0;
    //TODO:calc topoReq:

    //TODO:toposort:
    //maxRank = toposort();


    //calcula por ordem: (ID (iterative depth) para ser mais facil de implementar, isto e, nao tem sort previo)
    for (int i=0; i<=maxRank; i++) {
      for (map<pii, int>::iterator it = rank.begin(); it!=rank.end(); it++) {
        if (it->second==i) {
          calcdValues[it->first] = cells[it->first]->calcValue();
        }
      };
    }

    //escreve NAN nas nao calculaveis;
    for (map<pii, Cell>::iterator it = cells.begin(); it!=cells.end(); it++) {
      if (!rank.contains(it->first)) {
        calcdValues[it->first] = nan;
      }
    };
  }

  void updateCell(int i, int j, const string& val) {
    cells[pii(i,j)] = Cell(val);
    calcTable();
  }

  //TODO:para enviarmos a tabela para uma stream, usamos o formato .cs
};



#endif
