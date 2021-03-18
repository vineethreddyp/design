package impl;

import interfaces.State;
import interfaces.VendingMachine;

public class VendingMachineProcess implements State {

  @Override
  public void handle(VendingMachine vendingMachine) {
    vendingMachine.processAmount();
  }
}
