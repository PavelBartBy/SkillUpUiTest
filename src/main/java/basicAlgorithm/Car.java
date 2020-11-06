package basicAlgorithm;

/**
 * Create of training class of Car
 */
public class Car {
    String manufacture;
    String model;
    String color;
    int maxSpeed = 200;
    int age = 0;
    int weight = 1;
    int currentSpeed =0;
    boolean engineStatus = false;

    public Car(String manufacture, String model, String color){
        this.manufacture = manufacture;
        this.model = model;
        this.color = color;
    }

    public void engineOn(){
        engineStatus = true;
    }

    public void engineOff(){
        engineStatus= false;
    }

    public void toMove(){
        if (engineStatus & currentSpeed!=maxSpeed){
            currentSpeed++;
        }
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setWeight(int weight){
        this.weight= weight;
    }
}

class passengerCar extends Car{

    int maxSpeed = 250;

    public passengerCar(String manufacture, String model, String color) {
        super(manufacture, model, color);
    }

    public void toMove() {
        if (engineStatus & currentSpeed != maxSpeed) {
            currentSpeed++;
        }
    }
}

class Track extends Car{

    int maxSpeed = 100;

    public Track(String manufacture, String model, String color) {
        super(manufacture, model, color);
    }

    public void toMove(){
        if (engineStatus & currentSpeed!=maxSpeed){
            currentSpeed++;
        }
    }
}