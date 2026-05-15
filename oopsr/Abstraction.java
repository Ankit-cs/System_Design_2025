package SystemDesign2026.oopsr;
import java.util.*;

/*
Car Interface --> Act as an interface for Outsiude world to operate the car.
This interface tells 'WHAT' all it can do rather then 'HOW' it does that.
Since this is an interface we cannot directly create Objects of this. We
need to implement it first and then that child class will have the responsibility to
provide implementation details of all the methods in the interface.

In our real world example of Car, imagine you sitting in the car and able to operate
the car (startEngine, accelerate, brake, turn) just by pressing or moving some
pedals/buttons/stearing wheel etc. You dont need to know how these things work, and
also they are hidden under thre hood.
This Interface 'Car' denotes that (pedals/buttons/stearing wheel etc).
*/
interface Car{
    void startEngine();
    void shiftGear(int gear);
    void accelerate();
    void breakEngine();
    void stopEngine();
}


/*
This is a Concrete class (A class that provide implementation details of an interface/abstract class).
Now anyone can make an Object of 'SportsCar' and can assign it to 'Car' reference.
(See main method for this)

In our real world example of Car, as you cannot have a real car by just having its body only
(all these buttons or pedals). You need to have the actual implementation of 'What' happens
when we press these buttons. 'SportsCar' class denotes that actual implementation.

Hence we can concude, to denote a real world car in programming we created 2 classes.
One to deonte all the user-interface like pedals, buttons, stearing wheels etc ('Car' interface).
And another one to denote the actual car with all the implementations of these buttons (SportsCar' class).
 */

class mySportsCar implements Car{
     String brand;
     String model;
     boolean isStarted=false;
     int currentGear=0;
     int currentSpeed=0;

     public mySportsCar(String brand, String model){
         this.brand=brand;
         this.model=model;
     }

     @Override
     public void startEngine(){
         isStarted=true;
         System.out.println(brand+" "+model+":Engine Started with Roar");
     }

    @Override
    public void shiftGear(int gear){
    if(!isStarted){
        System.out.println(brand+" "+model+":Engine is not Started!!!");
        return;
    }
    this.currentGear=gear;
        System.out.println(brand+" "+model+":Shifted to Gear"+currentGear);
    }

    @Override
    public void accelerate(){
    if(!isStarted){
        System.out.println(brand+" "+model+":Engine is not Started cannot accelerate");
        return;
    }
    currentSpeed+=20;
        System.out.println(brand+" "+model+":Accelerated to speed "+currentSpeed);
    }

    @Override
    public void breakEngine(){
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    @Override
    public void stopEngine(){
        isStarted=false;
        currentGear=0;
       currentSpeed=0;
        System.out.println(brand+" "+model+":Engine stopped with Meow as Low petrol ");
    }
}
public class Abstraction {
    static void main() {
        Car mycar=new mySportsCar("Ford","Mustang");
        mycar.startEngine();
        mycar.shiftGear(1);
        mycar.accelerate();
        mycar.shiftGear(2);
        mycar.accelerate();
        mycar.accelerate();
        mycar.shiftGear(3);
        mycar.accelerate();
        mycar.accelerate();
        mycar.accelerate();
        mycar.shiftGear(4);
        mycar.accelerate();
        mycar.accelerate();
        mycar.accelerate();
        mycar.accelerate();
        mycar.accelerate();
        mycar.accelerate();
        mycar.breakEngine();
        mycar.breakEngine();
        mycar.breakEngine();
        mycar.breakEngine();
        mycar.breakEngine();
        mycar.stopEngine();
    }
}
