package basicAlgorithm;

/**
 * Create abstract class of Animal
 */
public abstract class Animal {
    private String name;
    private String color;
    private byte animalSize = 0;
    private boolean animalActive = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte getAnimalSize() {
        return animalSize;
    }

    public void setAnimalSize(byte animalSize) {
        this.animalSize = animalSize;
    }

    public abstract void toEat();

    public void toSleep(){
        this.animalActive=false;
    }

    public void toMove(){
        if (!this.animalActive){
            this.animalActive=true;
        }
    }

    public abstract void makeSound();

    public abstract void growUp();
}

class Dog extends Animal{

    @Override
    public void toEat() {}

    @Override
    public void makeSound() {
        System.out.println("Gau");
    }

    @Override
    public void growUp() {}
}

class Cat extends Animal{
    @Override
    public void toEat() {}

    @Override
    public void makeSound(){
        System.out.println("Mau");
    }

    @Override
    public void growUp() {}
}