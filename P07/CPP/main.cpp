#include "Table.hpp"

//Quando acabar PO, vou saber programar o IST-Office-6.0 :P sqn
int main() {
  Table t1;
  t1.updateCell(1,1,"Nome");
  t1.updateCell(1,2,"Idade");
  t1.updateCell(1,3,"Formula magica sobre a idade");
  t1.updateCell(2,1,"Afonso");
  t1.updateCell(2,2,"=19");
  t1.updateCell(2,3,"= T(2,2)* 4342.1^(1/8) - 32 + 45/ 17 ^3");
}
