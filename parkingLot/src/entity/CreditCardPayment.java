package entity;

public class CreditCardPayment extends Payment {

  private String creditCardNumber;

  public CreditCardPayment(Double amount, String creditCardNumber) {
    super(amount);
    this.creditCardNumber = creditCardNumber;
  }
}
