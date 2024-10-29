package training.OOP.zoo;

public class Dog extends Animal {

    String dogAtribute;

    Dog() {
        System.out.println("Dog constructor");
    }

    @Override
    void breed() {
        System.out.println("Dog");
    }

}
