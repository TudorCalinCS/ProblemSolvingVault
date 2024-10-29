package training.OOP.payment;

// Class implementing Payment as an abstract class
public class PaypalPayment extends Payment {
    // If Payment is an interface, we are using "implements" keyword insead of the
    // "extends" keyword used for abstract class

    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    // Polymorphism: overriding method from interface
    @Override
    public void makePayment(Double amount) {
        System.out.println("Payment of " + String.format("%.02f", amount) + " by " + this.email + "\n");

    }

    @Override
    public void makePayment(Double amount, String description) {
        System.out.println("Payment of " + String.format("%.02f", amount) + " by " + this.email + "\n");
        System.out.println(description + "\n");
    }
}