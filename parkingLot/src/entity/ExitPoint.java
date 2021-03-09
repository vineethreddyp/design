package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExitPoint {

  private String name;

  public ExitPoint(String name){
    this.name = name;
  }

  // payment func
  public void processPayment(ParkingTicket parkingTicket, Double amount){
    // add payment object here
    if(amount == 0) return;
    Payment payment = new CashPayment(amount);
    parkingTicket.setPayment(payment);
    System.out.println("Cash Payment done for ticket : " + parkingTicket.getTicketNumber());
  }
  public Double scanTicket(ParkingTicket parkingTicket){
    System.out.println("Scanning ticket at exit point :" + this.name + ". Scanned ticket : " + parkingTicket.getTicketNumber());
    Double totalAmount = 100.0;
    parkingTicket.setOutTime(LocalDateTime.now());
    Payment payment = parkingTicket.getPayment();
    Double amountToBePaid;
    if(Objects.isNull(payment)){
      System.out.println("Ticket Scanned: Amount to be paid: " + totalAmount + " for ticket : " + parkingTicket.getTicketNumber() );
      amountToBePaid = totalAmount;
    }
    else {
      Double amountPaid = payment.getAmount();
      if(totalAmount- amountPaid > 0){
        amountToBePaid = totalAmount-amountPaid;
        System.out.println("Ticket Scanned: Amount to be paid: " + amountToBePaid + " for ticket : " + parkingTicket.getTicketNumber() );
      }
      else{
        amountToBePaid = 0.0;
        System.out.println("Amount already payed for ticket: " + parkingTicket.getTicketNumber());
      }

    }

    return amountToBePaid;
  }
}
