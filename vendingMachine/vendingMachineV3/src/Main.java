import impl.AdminImpl;
import entity.Coin;
import impl.DisplayPanelImpl;
import entity.Product;
import impl.UserImpl;
import impl.CoinManagementImpl;
import impl.ProductManagementImpl;
import impl.VendingMachineImpl;
import interfaces.Admin;
import interfaces.CoinManagement;
import interfaces.DisplayPanel;
import interfaces.ProductManagment;

public class Main {

    public static void main(String[] args) {
        System.out.println("Vending Machine Up!");

        ProductManagment productManagement = new ProductManagementImpl();
        CoinManagement coinInventoryManagement = new CoinManagementImpl();
        DisplayPanel displayPanel = new DisplayPanelImpl();
        Admin vineethAdmin = new AdminImpl("vineeth",productManagement, coinInventoryManagement);
        VendingMachineImpl vendingMachine = new VendingMachineImpl("Vineeth's vending machine",productManagement, coinInventoryManagement, displayPanel);
        vineethAdmin.addQuantityForAProduct(Product.Coke, 10);
        vineethAdmin.addQuantityForAProduct(Product.Soda, 20);
        vineethAdmin.addQuantityForAProduct(Product.Pepsi, 10);
        vineethAdmin.addChangeInsideMachine(Coin.TwentyFive, 2);
        vineethAdmin.addChangeInsideMachine(Coin.Five, 1);
        vineethAdmin.addChangeInsideMachine(Coin.One, 1);
        vineethAdmin.addChangeInsideMachine(Coin.Ten, 2);
        UserImpl customer = new UserImpl(vendingMachine);
        vendingMachine.startMachine();
        while (true){
            vineethAdmin.printCoinsInMachine(); // this line for debug purpose only. this can be commented
            customer.selectProduct();
            customer.insertCoinForPayment();
        }
    }


}
