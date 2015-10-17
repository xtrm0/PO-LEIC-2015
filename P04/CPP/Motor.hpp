#ifndef _MOTOR_HPP_
#define _MOTOR_HPP_
#include <iostream>

class Motor {
  bool ligado;
public:
  Motor();
  virtual ~Motor();
  void ligar();
  void desligar();
  bool getLigado();
  virtual void makeNoise()=0;
};

class MotorEconomy : public Motor {
public:
  void makeNoise();
};

class MotorExtreme : public Motor {
public:
  void makeNoise();
};

#endif
