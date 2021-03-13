package entity;

public class Member {
  private MemberCard memberCard;
  private String name;
  private String rollNumber;
  private String email; // for notification purpose

  public Member(String name, String rollNumber, String email) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.email = email;
  }
}
