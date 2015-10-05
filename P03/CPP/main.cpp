#include "Gato.hpp"
#include "Cao.hpp"

using namespace std;
int main() {
  Gato g1(1, "Fonfon", 7);
  Gato g2(1, "Fonfon", 7);
  cout << g1 << endl;
  cout << g2 << endl;
  cout << (g1==g2) << endl; //true
  Cao c1(2, "Max", 40.333);
  Cao c2(2, "Rex", 41.333);
  Cao c3(2, "Max", 40.333);
  cout << c1 << endl;
  cout << c2 << endl;
  cout << c3 << endl;
  cout << (c1==c2) << endl; //false
  cout << (c1==c3) << endl; //true

  //cout << (c1==g1) << endl; //undefined because we cant compare Gato with Cao (we havent define such a comparrision function)
  cout << ((Animal)c1 == (Animal)g1) << endl; //false
  Cao c4(1, "Fonfon", 40.333);
  cout << ((Animal)c4 == (Animal)g1) << endl; //true, we are using animal comparators

  g1.trepar();
  c4.ladrar();
  g1.Gato::trepar();
  g1.dormir(3);
  //cout << (g1.Animal == c4.Animal) << endl; //invalid, typecasts cant be done this way

}
