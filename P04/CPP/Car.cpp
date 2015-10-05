#include "Car.hpp"

Car::Car() : moving(false), motor(*new MotorEconomy()) {

}
Car::Car(Motor &m) : moving(false), motor(m) {

}
Car::~Car() {
  delete &motor;
}
void Car::andar() {
  motor.Ligar();
  motor.makeNoise();
  moving = true;
}
void Car::parar() {
  motor.Desligar();
  moving = false;
}
