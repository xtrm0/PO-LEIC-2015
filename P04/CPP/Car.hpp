#ifndef _CAR_HPP_
#define _CAR_HPP_
#include <iostream>
#include "Motor.hpp"
class Car {
  bool moving;
protected:
  MotorEconomy* motor;
public:
  Car();
  Car(MotorEconomy&);
  virtual ~Car();
  virtual void andar();
  virtual void parar();
};

class MediumCar : public Car {
public:
  Motor* switchMotor(MotorEconomy&);
};

class TopCar : public MediumCar {
  MotorExtreme* secondMotor;
public:
  virtual ~TopCar();
  TopCar();
  Motor* switchSecondMotor(MotorExtreme&);
  virtual void andar();
  virtual void parar();
};

#endif
