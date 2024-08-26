package training.OOP.payment;

public class Main {
    public static void main(String[] args) {

        Payment creditCard = new CreditCardPayment("1234-1234-1234-1234", "John Texter");
        Payment payPal = new PaypalPayment("john.texter@example.com");

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(creditCard, 740.51);
        processor.processPayment(payPal, 222.33);

        processor.processPayment(creditCard, 139.99, "Annual subscription");
        processor.processPayment(payPal, 320.00, "Gift purchase");

    }
}