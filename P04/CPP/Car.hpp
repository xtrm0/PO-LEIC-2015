#ifndef _CAR_HPP_
#define _CAR_HPP_
#include <iostream>
#include "Motor.hpp"
class Car {
  bool moving;
  Motor &motor;
public:
  Car();
  Car(Motor&);
  ~Car();
  void andar();
  void parar();
};

#endif
