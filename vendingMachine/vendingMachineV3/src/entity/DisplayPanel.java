package entity;

import interfaces.DisplayPanelInterface;
import interfaces.VendingMachine;

public class DisplayPanel implements DisplayPanelInterface {

  private VendingMachine vendingMachine;

  public DisplayPanel(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void display(){
    vendingMachine.display();
  }



}
