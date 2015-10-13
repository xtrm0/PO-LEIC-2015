#include "Car.hpp"
template<typename Base, typename T>
inline bool instanceof(const T *ptr) {
    return dynamic_cast<const Base*>(ptr) != nullptr;
}

Car::Car() : moving(false), motor(new MotorEconomy()) {};
Car::Car(MotorEconomy &m) : moving(false), motor(&m) {};

Car::~Car() {
  delete motor;
}

void Car::andar() {
  motor->Ligar();
  motor->makeNoise();
  moving = true;
}

void Car::parar() {
  motor->Desligar();
  moving = false;
}

Motor* MediumCar::switchMotor(MotorEconomy& motor) {
  Motor* old = this->motor;
  this->motor = &motor;
  return old;
}

TopCar::TopCar() : MediumCar(), secondMotor(NULL) {};

Motor* TopCar::switchSecondMotor(MotorExtreme& secondMotor) {
  Motor* old = this->secondMotor;
  this->secondMotor = &secondMotor;
  return old;
}

void TopCar::andar() {
  MediumCar::andar();
  if (secondMotor!=NULL) {
    secondMotor->Ligar();
    secondMotor->makeNoise();
  }
}

void TopCar::parar() {
  MediumCar::parar();
  if (secondMotor!=NULL) {
    secondMotor->Desligar();
  }
}

TopCar::~TopCar() {
  if (secondMotor)
    delete secondMotor;
}
