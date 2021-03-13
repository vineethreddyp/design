package entity;

import enums.BookCategory;
import java.time.LocalDate;

public class Book {

  private String UIN;
  private String title;
  private String author;
  private BookCategory bookCategory;
  private LocalDate publicatonDate;

  public Book(String UIN, String title, String author, BookCategory bookCategory,
      LocalDate publicatonDate) {
    this.UIN = UIN;
    this.title = title;
    this.author = author;
    this.bookCategory = bookCategory;
    this.publicatonDate = publicatonDate;
  }
}
