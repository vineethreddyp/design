package entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookItem {

  private Book book;
  private UUID barCode;
  private Member assignedTo;
  private LocalDateTime chekinDate;
  private Fine fine;
  private Rack rack;

  public BookItem(Book book, UUID barCode, Rack rack){
    this.book = book;
    this.barCode = barCode;
    this.rack = rack;
  }

  public void assignToMember(Member member){
    assignedTo = member;
    chekinDate = LocalDateTime.now();
  }

  public void checkInLibrary(Rack rack){
    this.rack = rack;
    this.assignedTo = null;
    this.fine = null;
    this.chekinDate = null;
  }

}
