import entity.Coin;
import entity.Product;
import impl.AdminImpl;
import impl.CoinManagementImpl;
import impl.DisplayPanelImpl;
import impl.ProductManagementImpl;
import impl.UserImpl;
import impl.VendingMachineIdle;
import impl.VendingMachineImpl;
import impl.VendingMachineProcess;
import interfaces.Admin;
import interfaces.CoinManagement;
import interfaces.DisplayPanel;
import interfaces.ProductManagment;
import interfaces.State;
import interfaces.User;
import interfaces.VendingMachine;

public class Main {

    public static void main(String[] args) {
        System.out.println("Vending Machine Up!");

        ProductManagment productManagement = new ProductManagementImpl();
        CoinManagement coinInventoryManagement = new CoinManagementImpl();
        DisplayPanel displayPanel = new DisplayPanelImpl();
        Admin vineethAdmin = new AdminImpl("vineeth",productManagement, coinInventoryManagement);
        vineethAdmin.addQuantityForAProduct(Product.Coke, 10);
        vineethAdmin.addQuantityForAProduct(Product.Soda, 20);
        vineethAdmin.addQuantityForAProduct(Product.Pepsi, 10);
        vineethAdmin.addChangeInsideMachine(Coin.TwentyFive, 2);
        vineethAdmin.addChangeInsideMachine(Coin.Five, 1);
        vineethAdmin.addChangeInsideMachine(Coin.One, 1);
        vineethAdmin.addChangeInsideMachine(Coin.Ten, 2);
        State vendingMachineIdleState = new VendingMachineIdle();
        State vendingMachineProcessState = new VendingMachineProcess();
        VendingMachine vendingMachine = new VendingMachineImpl("Vineeth's vending machine",productManagement, coinInventoryManagement,
            displayPanel, vendingMachineIdleState, vendingMachineProcessState);


        User customer = new UserImpl(vendingMachine);


        while (true){
            vineethAdmin.printCoinsInMachine(); // this line for debug purpose only. this can be commented
            vendingMachine.handle();
        }
    }
}
