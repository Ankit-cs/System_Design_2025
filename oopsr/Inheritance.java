package SystemDesign2026.oopsr;

class Caar{
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Caar(String brand,String model){
        this.brand=brand;
        this.model=model;
        this.isEngineOn=false;
        this.currentSpeed=0;
    }
    public void startEngine(){
        isEngineOn=true;
        System.out.println(brand+" "+model+ ":Engine Started");
    }
    public void stopEngine(){
        isEngineOn=false;
        currentSpeed=0;
        System.out.println(brand+" "+model+ ":Engine Stopped");
    }
    public void accelerate(){
        if(!isEngineOn) {
            System.out.println(brand + " " + model + ":Cannot accelerate! Engine is off");
            return;
        }
        currentSpeed+=20;
        System.out.println(brand+" "+model+ ":Accelerating to "+currentSpeed);
    }
    public void brake(){
        currentSpeed-=20;
        if(currentSpeed<0) {currentSpeed=0;}
        System.out.println(brand+" "+model+ ":Braking! Speed is now "+currentSpeed);
    }

}
class ManualCar extends Caar{
    private int  currentGear;
    public ManualCar(String brand,String model){
        super(brand,model);
        this.currentGear=0;
    }
    public void shiftGear(int gear){
        this.currentGear=gear;
        System.out.println(brand+" "+model+ ":Shifted to Gear"+currentGear);

    }
}
class ElectricCar extends Caar{
    private int batterylevel;
    public ElectricCar(String brand,String model){
        super(brand,model);
        this.batterylevel=100;
    }
    public void chargBattery(){
        batterylevel=100;
        System.out.println(brand+" "+model+":Battery Fully Charged!");
    }
}

public class Inheritance {
    static void main() {
        ManualCar myManualCar=new ManualCar("Ford","GT Mustang");
        myManualCar.startEngine();
        myManualCar.shiftGear(1);
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.shiftGear(2);
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        ElectricCar myManualCar1=new ElectricCar("Tesla","CyberTruck");
        myManualCar1.chargBattery();
        myManualCar1.startEngine();
        //myManualCar1.shiftGear(1);
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        //myManualCar1.shiftGear(2);
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.accelerate();
        myManualCar1.brake();
        myManualCar1.stopEngine();


    }
}
