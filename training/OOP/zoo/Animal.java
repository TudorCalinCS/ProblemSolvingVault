package training.OOP.zoo;

public abstract class Animal {

    String animalAtribute;

    Animal() {
        hello();
        breed();
    }

    void hello() {
        System.out.println("hello Animal");
    }

    abstract void breed();
}
