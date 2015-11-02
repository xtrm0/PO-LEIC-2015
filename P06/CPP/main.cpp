#include <bits/stdc++.h>
#include "Benefit.hpp"
using namespace std;

int main() {
  DonationManager m;
  Individual *i1 = new Individual("a");
  Individual *i2 = new Individual("b");
  Individual *i3 = new Individual("c");
  Individual *i4 = new Individual("d");
  Individual *i5 = new Individual("e");
  Individual *i6 = new Individual("f");
  Individual *i7 = new Individual("g");
  Population *p1 = new Population("p1");
  Population *p2 = new Population("p2");
  Population *p3 = new Population("p3");
  Region     *r1 = new Region("r1");
  Region     *r2 = new Region("r2");
  //regista os benificiarios no registo, fazemos isto para nao termos de tratar
  //de memoria dentro do DonationManager
  m.registerBeneficiary(*i1);
  m.registerBeneficiary(*i2);
  m.registerBeneficiary(*i3);
  m.registerBeneficiary(*i4);
  m.registerBeneficiary(*i5);
  m.registerBeneficiary(*i6);
  m.registerBeneficiary(*i7);
  m.registerBeneficiary(*p1);
  m.registerBeneficiary(*p2);
  m.registerBeneficiary(*p3);
  m.registerBeneficiary(*r1);
  m.registerBeneficiary(*r2);

  //regiao 1:
  p1->addBeneficiary(*i1);
  p1->addBeneficiary(*i2);
  p2->addBeneficiary(*i3);
  r1->addBeneficiary(*p1);
  r1->addBeneficiary(*p2);

  //regiao 2:
  p2->addBeneficiary(*i4);
  p3->addBeneficiary(*i5);
  p3->addBeneficiary(*i6);
  r2->addBeneficiary(*p3);
  r2->addBeneficiary(*i7);

  //doacoes ao calhas:
  m.giveDonation(*i1, 10.0);
  m.giveDonation(*i3, 10.0);
  m.giveDonation(*r1, 10000.0);
  m.giveDonation(*r2, 10.0);
  m.giveDonation(*p1, 50.0);

  //imprrimir os resultados
  cout << (const Beneficiary &) *i1 << endl; //[3761328176]  a:  2535
  cout << (const Beneficiary &) *i2 << endl; //[814609577]   b:  2525
  cout << (const Beneficiary &) *i3 << endl; //[280156718]   c:  2510
  cout << (const Beneficiary &) *i4 << endl; //[137697743]   d:  2500
  cout << (const Beneficiary &) *i5 << endl; //[831733596]   e:  2.5
  cout << (const Beneficiary &) *i6 << endl; //[1445474917]  f:  2.5
  cout << (const Beneficiary &) *i7 << endl; //[227961658]   g:  5
  cout << (const Beneficiary &) *p1 << endl; //[1184072683]  p1: 5060
  cout << (const Beneficiary &) *p2 << endl; //[834860360]   p2: 5010
  cout << (const Beneficiary &) *p3 << endl; //[342790113]   p3: 5
  cout << (const Beneficiary &) *r1 << endl; //[1274020102]  r1: 10070
  cout << (const Beneficiary &) *r2 << endl; //[1176794055]  r2: 10

}
