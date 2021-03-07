package entity;

import java.time.LocalDateTime;

public class ExitPoint {

  private String name;

  // payment func

  public void processPayment(ParkingTicket parkingTicket, Double amount){
    // add payment object here
    Payment payment = new CashPayment(amount);
    parkingTicket.setPayment(payment);
    System.out.println("Payment done for ticket : " + parkingTicket.getTicketNumber());
  }
  public Double scanTicket(ParkingTicket parkingTicket){
    Double amount = 100.0;
    parkingTicket.setOutTime(LocalDateTime.now());
    System.out.println("Ticket Scanned: Amount to be paid: " + amount + " for ticket : " + parkingTicket.getTicketNumber() );
    return amount;
  }
}
