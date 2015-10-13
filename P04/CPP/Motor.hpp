#ifndef _MOTOR_HPP_
#define _MOTOR_HPP_
#include <iostream>

class Motor {
  bool ligado;
public:
  Motor();
  virtual ~Motor();
  void Ligar();
  void Desligar();
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
