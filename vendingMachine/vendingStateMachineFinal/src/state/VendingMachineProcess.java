package state;

import entity.DispersionType;
import datastore.StateMachineStore;
import entity.Coin;
import entity.Product;
import interfaces.VendingMachine;
import java.util.Objects;

public class VendingMachineProcess implements VendingMachine {

  private StateMachineStore stateMachineStore;

  public VendingMachineProcess(StateMachineStore stateMachineStore){
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void selectProduct(Product product) {
    System.out.println("Invalid call. Product cannot be selected now. Abort and reselect");
  }


  @Override
  public void insertCoinForPayment(Integer integer) {
    stateMachineStore.setValueInserted(integer);
    System.out.println("Inserted amount : " + integer);
    processAmount();
  }

  @Override
  public void action() {
    System.out.println("State changed to Process State");
    display();
  }

  private void processAmount() {

    Integer valueEntered = stateMachineStore.getValueInserted();
    if(valueEntered == -1){
      // this is for abort in the middle
      stateMachineStore.setDispersionType(DispersionType.ABORT);
      stateMachineStore.setChangeDisperseState();
      return;
    }
    stateMachineStore.setPaidAmount( stateMachineStore.getPaidAmount() + valueEntered);
    Coin paidCoin = Coin.findByValue(valueEntered);
    if(Objects.isNull(paidCoin)){
      stateMachineStore.getDisplayPanel().setDisplayString("Not accepted coin. Valid are " + Coin.getValidCoins());
      return;
    }

    Integer finalVal = stateMachineStore.getAmountToBePaid() - paidCoin.getValue();
    stateMachineStore.getCoinInventoryManagement().addQuantity(paidCoin,1);
    if(finalVal == 0){
      stateMachineStore.setAmountToBePaid(0);
      stateMachineStore.setProductDisperseState();
    }
    else if(finalVal > 0){
      stateMachineStore.setAmountToBePaid(finalVal);
      display();
    }
    else {
      stateMachineStore.setDispersionType(DispersionType.EXCESS_CHANGE);
      stateMachineStore.setChangeDisperseState();
    }
  }

  private void display(){
    stateMachineStore.getDisplayPanel().setDisplayString("Amount to be paid :" + stateMachineStore.getAmountToBePaid());

  }
}
