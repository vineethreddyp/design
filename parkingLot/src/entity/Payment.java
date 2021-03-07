package entity;

import java.time.LocalDateTime;

public class Payment {
  private Double amount;
  private LocalDateTime createdAt;

  public Payment(Double amount){
    this.amount = amount;
    this.createdAt = LocalDateTime.now();
  }

}
