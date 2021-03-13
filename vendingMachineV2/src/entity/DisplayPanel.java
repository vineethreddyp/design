package entity;

import interfaces.DisplayPanelInterface;
import interfaces.UserVendingMachine;

public class DisplayPanel implements DisplayPanelInterface {

  private UserVendingMachine vendingMachine;

  public DisplayPanel(UserVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void display(){
    vendingMachine.display();
  }



}
