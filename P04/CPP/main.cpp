#include "Car.hpp"
#include "Motor.hpp"
using namespace std;
int main() {
  TopCar * tc;
  MediumCar * mc;
  Car *c;

  /*Car testing*/
  cout << "\033[1;31m" << "Car:" << "\033[0m" << endl;
  c = new Car();
  c->andar();
  delete c;
  c = new Car(*new MotorEconomy());
  c->andar();
  delete c;

  /*MediumCar testing*/
  cout << endl << "\033[1;31m" << "MediumCar:" << "\033[0m" << endl;
  mc = new MediumCar();
  mc->andar();
  delete mc->switchMotor(*new MotorEconomy());
  mc->andar();
  mc->parar();
  delete mc;

  /*TopCar testing*/
  cout << endl << "\033[1;31m" << "TopCar:" << "\033[0m" << endl;
  cout << "Motor 1:" << endl;
  tc = new TopCar();
  tc->andar();
  tc->parar();

  cout << "Motor 2:" << endl;
  tc->switchSecondMotor(*new MotorExtreme());
  tc->andar();
  tc->parar();

  cout << "Motor 3:" << endl;
  delete tc->switchSecondMotor(*new MotorExtreme());
  tc->andar();
  tc->parar();
  delete tc;
  return 0;
}
