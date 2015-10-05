#include "Car.hpp"
#include "Motor.hpp"

int main() {
  Car *c = new Car();
  c->andar();
  delete c;
  c = new Car(*new MotorEconomy());
  c->andar();
  delete c;
  c = new Car(*new MotorExtreme());
  c->andar();
  delete c;
  return 0;
}
