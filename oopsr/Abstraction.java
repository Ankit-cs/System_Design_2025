package SystemDesign2026.oopsr;
import java.util.*;
interface Car{
    void startEngine();
    void shiftGear(int gear);
    void accelerate();
    void breakEngine();
    void stopEngine();
}

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
