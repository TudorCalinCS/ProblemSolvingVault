package training.OOP.payment;

public class PaymentProcessor {

    // Polymorphism: method overloading with different parameters
    public void processPayment(Payment paymentMethod, Double amount) {
        paymentMethod.makePayment(amount);
    }

    public void processPayment(Payment payment, Double amount, String description) {
        payment.makePayment(amount, description);
    }
}
