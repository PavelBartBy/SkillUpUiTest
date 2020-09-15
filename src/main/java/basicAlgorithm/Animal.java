package basicAlgorithm;

public class Animal {
    String name;
    String color;
    byte animalSize = 0;
    boolean animalActive = true;

    public Animal(){}

    public Animal(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void toEat(){}

    public void toSleep(){
        this.animalActive=false;
    }

    public void toMove(){
        if (!this.animalActive){
            this.animalActive=true;
        }
    }

    public void makeSound(){
        System.out.println("Don't know my sound");
    }

    public void growUp(){
        this.animalSize = 1;
    }
}

class Dog extends Animal{

    @Override
    public void makeSound() {
        System.out.println("Gau");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Mau");
    }
}