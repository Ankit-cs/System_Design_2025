#include<iostream>
#include<string>
using namespace std;

// Interface for car
class Car {
public:
    virtual void startEngine() = 0;// virtual keyword is used for creating teh method wjhich is not doing anything just doing rest ite chil cass which interith it will be make this mthod working
    virtual void shiftGear(int gear) = 0;
    virtual void stopEngine() = 0;
    virtual void accelerate() = 0;
    virtual void brake() = 0;
    virtual ~Car() {} // Destructor
};

class SportCar : public Car {
public:
    string brand;
    string model;
    bool isEngineOn;
    int currentSpeed;
    int currentGear;

    SportCar(string b, string m) {
        brand = b;
        model = m;
        isEngineOn = false;
        currentSpeed = 0;
        currentGear = 0;
    }

    void startEngine() override {
        isEngineOn = true;
        cout << brand << " " << model << ": Engine starts with a roar!" << endl;
    }

    void shiftGear(int gear) override {
        if (!isEngineOn) {
            cout << brand << " " << model << ": Engine is off. Cannot shift gear." << endl;
            return;
        }
        currentGear = gear;
        cout << brand << " " << model << ": Shifted to gear " << currentGear << endl;
    }

    void accelerate() override {
        if (!isEngineOn) {
            cout << brand << " " << model << ": Engine is off. Cannot accelerate." << endl;
            return;
        }
        currentSpeed += 20;
        cout << brand << " " << model << ": Current speed is " << currentSpeed << " km/h" << endl;
    }

    void brake() override {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        cout << brand << " " << model << ": Current speed is " << currentSpeed << " km/h" << endl;
    }

    void stopEngine() override {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        cout << brand << " " << model << ": Engine turned off." << endl;
    }
};

int main() {
  Car* mycar=new SportCar("Ford","Mustang");
  mycar->startEngine();
  mycar->shiftGear(1);
  mycar->accelerate();
  mycar->shiftGear(2);
  mycar->accelerate();
  mycar->brake();
  mycar->stopEngine();
  delete mycar;
  return 0;
}
