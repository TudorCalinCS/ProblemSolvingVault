package training.OOP.zoo;

public class Cat extends Animal {

    Cat() {
        System.out.println("Cat constructor");
    }

    @Override
    void breed() {
        System.out.println("Cat");
    }

}