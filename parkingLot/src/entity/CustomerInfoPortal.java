package entity;

import java.time.LocalDateTime;

public class CustomerInfoPortal {

  private String name;

  public CustomerInfoPortal(String s) {
    this.name = s;
  }

  public void processPayment(ParkingTicket parkingTicket, Double amount){
    // add payment object here
    Payment payment = new CreditCardPayment(amount, "1234567890");
    parkingTicket.setPayment(payment);
    System.out.println("Credit card Payment done for ticket : " + parkingTicket.getTicketNumber());
  }
  public Double scanTicket(ParkingTicket parkingTicket){
    Double amount = 100.0;
    parkingTicket.setOutTime(LocalDateTime.now());
    System.out.println("Ticket Scanned: Amount to be paid: " + amount + " for ticket : " + parkingTicket.getTicketNumber() );
    return amount;
  }
}
