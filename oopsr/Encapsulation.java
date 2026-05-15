package SystemDesign2026.oopsr;
import java.util.*;

class mySports{

    private String brand;
    private String model;
    private int currentGear;
    private int currentSpeed;
    private boolean isEngineOn;
    private String tyreCompany;

    public mySports(String brand,String model){
        this.brand=brand;
        this.model=model;
    }
    public int getSpeed(){
        return currentSpeed;
    }
    public String getTyre(){
     return tyreCompany;
    }
    public void setTyre(String tyre){
        this.tyreCompany=tyre;
    }
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }


}
public class Encapsulation {
    static void main() {


        mySports mySportsCar = new mySports("Ford", "Mustang");

        mySportsCar.startEngine();
        mySportsCar.shiftGear(1);
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.shiftGear(2);
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.accelerate();
        mySportsCar.brake();
        mySportsCar.stopEngine();

        //Setting arbitrary value to speed.
        //mySportsCar.currentSpeed = 500;

        // System.out.println("Current Speed of My Sports Car is set to " + mySportsCar.currentSpeed);

        System.out.println("Current Speed of My Sports Car is " + mySportsCar.getSpeed());
    }
}
