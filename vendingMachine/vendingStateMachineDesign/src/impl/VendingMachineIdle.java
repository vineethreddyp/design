package impl;

import interfaces.State;
import interfaces.VendingMachine;

public class VendingMachineIdle implements State {

  @Override
  public void handle(VendingMachine vendingMachine) {
    vendingMachine.setDisplay();
  }
}
