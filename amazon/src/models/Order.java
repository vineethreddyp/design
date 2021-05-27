package models;

import enums.PaymentType;
import java.util.List;

public class Order {
  private String orderNumber;
  private List<Item> itemList;
  private Double totalCost;
  private ShippingAddress shippingAddress;
  private String memberId;
  private PaymentType paymentType;
  private Payment payment;
  private Review review;
}
