#include "Motor.hpp"
Motor::Motor() : ligado(false) {};
void Motor::Ligar() {
  ligado = true;
}
void Motor::Desligar() {
  ligado = false;
}
bool Motor::getLigado() {
  return ligado;
}

void MotorEconomy::makeNoise() {
  std::cout << "vroomzito" << std::endl;
}

void MotorExtreme::makeNoise() {
  std::cout << "VROOO0OOOOM" << std::endl;
}

Motor::~Motor() {
}
