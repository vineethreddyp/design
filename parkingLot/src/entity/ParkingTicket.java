package entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
  private String ticketNumber;
  private LocalDateTime inTime;
  private LocalDateTime outTime;
  private Payment payment;

  public ParkingTicket(){
    this.ticketNumber = UUID.randomUUID().toString();
    this.inTime = LocalDateTime.now();
  }

  public void setOutTime(LocalDateTime outTime) {
    this.outTime = outTime;
  }

  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
