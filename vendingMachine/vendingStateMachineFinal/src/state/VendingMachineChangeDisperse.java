package state;

import entity.DispersionType;
import datastore.StateMachineStore;
import entity.Product;
import exception.InvalidOperationException;
import interfaces.VendingMachine;

public class VendingMachineChangeDisperse implements VendingMachine {

  private StateMachineStore stateMachineStore;

  public VendingMachineChangeDisperse(StateMachineStore stateMachineStore) {
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void selectProduct(Product product) {
    throw new InvalidOperationException("Product cannot be selected while change dispersion");
  }

  @Override
  public void insertCoinForPayment(Integer integer) {
    throw new InvalidOperationException("Coin cannot be inserted while change dispersion");
  }

  @Override
  public void action() {
    System.out.println("State changed to Change Disperse State");
    disperseChange();
  }


  private void disperseChange(){
    DispersionType dispersionType = stateMachineStore.getDispersionType();
    switch (dispersionType){
      case ABORT:
        stateMachineStore.getCoinInventoryManagement().disperseChange(stateMachineStore.getPaidAmount());
        stateMachineStore.setIdleState();
        break;
      case EXCESS_CHANGE:
        boolean dispersionSuccess = stateMachineStore.getCoinInventoryManagement().
            disperseChange(stateMachineStore.getPaidAmount() - stateMachineStore.getSelectedProduct().getCost());
        // return original amount
        if(!dispersionSuccess){
          System.out.println("Dispersing change failed. Returning original amount");
          stateMachineStore.setDispersionType(DispersionType.ABORT);
          disperseChange();
        }
        else{
          stateMachineStore.setIdleState();
        }

    }
  }
}
