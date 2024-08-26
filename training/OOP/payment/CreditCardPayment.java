package training.OOP.payment;

// Class implementing Payment as an abstract class
public class CreditCardPayment extends Payment {
    // If Payment is an interface, we are using "implements" keyword insead of the
    // "extends" keyword used for abstract class

    private String cardNumber;

    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    // Polymorphism: overriding method from interface
    @Override
    public void makePayment(Double amount) {
        System.out.println("Payment of " + String.format("%.02f", amount) + " by " + this.cardHolderName
                + " with card number " + this.cardNumber + "\n");
    }

    @Override
    public void makePayment(Double amount, String description) {
        System.out.println("Payment of " + String.format("%.02f", amount) + " by " + this.cardHolderName
                + " with card number " + this.cardNumber + "\n");
        System.out.println(description + "\n");
    }
}