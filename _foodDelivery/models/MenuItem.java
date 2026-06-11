package models;

public class MenuItem{
    private String code;
    private String name;
    private double price;
    public MenuItem(String code,String name,double price){
        this.code=code;
        this.name=name;
        this.price=price;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String c){
        code=c;
    }
        public String getname(){
        return name;
    }
    public void setname(String n){
        name=n;
    }
    public double getprice(){
        return price;
    }
    public void setprice(double p){
        price=p;
    }
    
    

}
