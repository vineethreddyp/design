package impl;

import interfaces.DisplayPanel;

public class DisplayPanelImpl implements DisplayPanel {

  private String displayString;

  public void setDisplayString(String displayString) {
//    System.out.println(displayString);
    this.displayString = displayString;
  }

  @Override
  public void display(){
    System.out.println(displayString);
  }


}
