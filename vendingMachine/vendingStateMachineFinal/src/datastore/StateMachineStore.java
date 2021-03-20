package datastore;

import entity.DispersionType;
import entity.Product;
import interfaces.CoinManagement;
import interfaces.DisplayPanel;
import interfaces.ProductManagment;
import interfaces.VendingMachine;

public class StateMachineStore {

  private VendingMachine vendingMachineIdle;
  private VendingMachine vendingMachineProcess;
  private VendingMachine vendingMachineChangeDisperse;
  private VendingMachine vendingMachineProductDisperse;
  private VendingMachine vendingMachineAdministrator;
  private ProductManagment productInventoryManagement;
  private CoinManagement coinInventoryManagement;
  private DisplayPanel displayPanel;
  private Integer amountToBePaid;
  private Integer paidAmount;
  private Product selectedProduct;
  private Integer valueInserted;
  private VendingMachine currentVendingMachineState;
  private DispersionType dispersionType;


  public StateMachineStore(ProductManagment productManagment, CoinManagement coinManagement) {
    this.productInventoryManagement = productManagment;
    this.coinInventoryManagement  = coinManagement;
  }

  public ProductManagment getProductInventoryManagement() {
    return productInventoryManagement;
  }

  public CoinManagement getCoinInventoryManagement() {
    return coinInventoryManagement;
  }

  public void setDisplayPanel(DisplayPanel displayPanel) {
    this.displayPanel = displayPanel;
  }

  public void setVendingMachineIdle(VendingMachine vendingMachineIdle) {
    this.vendingMachineIdle = vendingMachineIdle;
  }

  public void setVendingMachineProcess(VendingMachine vendingMachineProcess) {
    this.vendingMachineProcess = vendingMachineProcess;
  }

  public void setVendingMachineChangeDisperse(VendingMachine vendingMachineChangeDisperse) {
    this.vendingMachineChangeDisperse = vendingMachineChangeDisperse;
  }

  public void setVendingMachineProductDisperse(VendingMachine vendingMachineProductDisperse) {
    this.vendingMachineProductDisperse = vendingMachineProductDisperse;
  }

  public void setVendingMachineAdministrator(VendingMachine vendingMachineAdministrator) {
    this.vendingMachineAdministrator = vendingMachineAdministrator;
  }

  public VendingMachine getCurrentVendingMachineState() {
    return currentVendingMachineState;
  }

  public Integer getPaidAmount() {
    return paidAmount;
  }

  public void setPaidAmount(Integer paidAmount) {
    this.paidAmount = paidAmount;
  }


  public DispersionType getDispersionType() {
    return dispersionType;
  }

  public void setDispersionType(DispersionType dispersionType) {
    this.dispersionType = dispersionType;
  }

  public DisplayPanel getDisplayPanel() {
    return displayPanel;
  }


  public Integer getAmountToBePaid() {
    return amountToBePaid;
  }

  public void setAmountToBePaid(Integer amountToBePaid) {
    this.amountToBePaid = amountToBePaid;
  }

  public Product getSelectedProduct() {
    return selectedProduct;
  }

  public void setSelectedProduct(Product selectedProduct) {
    this.selectedProduct = selectedProduct;
  }

  public Integer getValueInserted() {
    return valueInserted;
  }

  public void setValueInserted(Integer valueInserted) {
    this.valueInserted = valueInserted;
  }

  public void setAdminState(){
    currentVendingMachineState = vendingMachineAdministrator;
    currentVendingMachineState.action();
  }


  public void setProcessState() {
    currentVendingMachineState = vendingMachineProcess;
    currentVendingMachineState.action();
  }

  public void setChangeDisperseState() {
    currentVendingMachineState = vendingMachineChangeDisperse;
    currentVendingMachineState.action();
  }

  public void setProductDisperseState() {
    currentVendingMachineState = vendingMachineProductDisperse;
    currentVendingMachineState.action();
  }

  public void setIdleState() {
    currentVendingMachineState = vendingMachineIdle;
    currentVendingMachineState.action();
  }
  public void clear(){
    amountToBePaid = 0;
    paidAmount = 0;
    selectedProduct = null;
    valueInserted = 0;
  }
}
