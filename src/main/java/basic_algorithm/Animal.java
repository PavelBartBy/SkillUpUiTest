package basic_algorithm;

public class Animal {
    String name;
    String color;
    String animalSize = "small";
    boolean animalActive = true;
    public Animal(){}
    public Animal(String name, String color){
        this.name = name;
        this.color = color;
    }
    public void toEat(){

    }
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
        this.animalSize = "Big";
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