package enums;

public enum Color {

  WHITE("\u001B[37m"), BLACK("\u001B[30m");
  public String colorCode;

  Color(String colorCode){
    this.colorCode = colorCode;
  }
}
