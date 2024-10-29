package training.OOP.payment;
/*
// Interface for Payment
public interface Payment {

   void makePayment(Double amount);

   void makePayment(Double amount, String description);

}
*/

// Abstract class for Payment
public abstract class Payment {

   // Abstract method to be implemented by subclasses
   public abstract void makePayment(Double amount);

   public abstract void makePayment(Double amount, String description);

}
