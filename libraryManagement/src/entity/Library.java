package entity;

import java.util.List;

public class Library {
  private String name;
  private Integer maxNBooksPerUser;
  private Integer maxDaysPerBook;
  private List<Rack> rackList;

  public Library(String name, Integer maxNBooksPerUser, Integer maxDaysPerBook,
      List<Rack> rackList) {
    this.name = name;
    this.maxNBooksPerUser = maxNBooksPerUser;
    this.maxDaysPerBook = maxDaysPerBook;
    this.rackList = rackList;
  }

  public Integer getMaxNBooksPerUser() {
    return maxNBooksPerUser;
  }

  public void setMaxNBooksPerUser(Integer maxNBooksPerUser) {
    this.maxNBooksPerUser = maxNBooksPerUser;
  }

  public Integer getMaxDaysPerBook() {
    return maxDaysPerBook;
  }

  public void setMaxDaysPerBook(Integer maxDaysPerBook) {
    this.maxDaysPerBook = maxDaysPerBook;
  }

  public List<Rack> getRackList() {
    return rackList;
  }

  public void setRackList(List<Rack> rackList) {
    this.rackList = rackList;
  }
}
