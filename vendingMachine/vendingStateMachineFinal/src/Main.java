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
        VendingMachine vendingMachine = new VendingMachineImpl("Vineeth's vending machine",productManagement, coinInventoryManagement,
            displayPanel);
        VendingMachineIdle vendingMachineIdle = new VendingMachineIdle(vendingMachine);
        VendingMachineProcess vendingMachineProcess = new VendingMachineProcess(vendingMachine);
        User customer = new UserImpl();
        testHappyFlow(customer, vendingMachineIdle, vendingMachineProcess, displayPanel);
        testChangeDisperseFlow(customer, vendingMachineIdle, vendingMachineProcess, displayPanel);
        testAbortFlow(customer, vendingMachineIdle, vendingMachineProcess, displayPanel);
        testInvalidFlow(customer, vendingMachineIdle, vendingMachineProcess, displayPanel);
    }

    private static void testChangeDisperseFlow(User customer, VendingMachineIdle vendingMachineIdle,
        VendingMachineProcess vendingMachineProcess, DisplayPanel displayPanel) {
        System.out.println("\nStarted: Change Disperse Flow ");
        displayPanel.display();
        customer.selectProduct(vendingMachineIdle,Product.Pepsi);//  select soda
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,25);
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,25);
        System.out.println("Completed: Change Disperse Flow\n");
    }


    private static void testAbortFlow(User customer, VendingMachineIdle vendingMachineIdle,
        VendingMachineProcess vendingMachineProcess, DisplayPanel displayPanel) {
        System.out.println("\nStarted: Abort Flow");
        displayPanel.display();
        customer.selectProduct(vendingMachineIdle,Product.Coke);//  select soda
        customer.insertCoinForPayment(vendingMachineProcess,10);
        customer.insertCoinForPayment(vendingMachineProcess,5);
        customer.insertCoinForPayment(vendingMachineProcess,-1);
        System.out.println("Completed: Abort Flow\n");

    }

    private static void testHappyFlow(User customer, VendingMachineIdle vendingMachineIdle,
        VendingMachineProcess vendingMachineProcess, DisplayPanel displayPanel) {
        System.out.println("\nStarted: Happy Flow");
        displayPanel.display();
        customer.selectProduct(vendingMachineIdle,Product.Soda);//  select soda
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,25);
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,10);
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,10);
        System.out.println("Completed: Happy Flow\n");
    }

    private static void testInvalidFlow(User customer, VendingMachineIdle vendingMachineIdle,
        VendingMachineProcess vendingMachineProcess, DisplayPanel displayPanel) {
        System.out.println("\nStarted: Invalid Flow");
        displayPanel.display();
        customer.selectProduct(vendingMachineIdle,Product.Soda);//  select soda
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,25);
        displayPanel.display();
        customer.selectProduct(vendingMachineProcess,Product.Coke);
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,10);
        displayPanel.display();
        customer.insertCoinForPayment(vendingMachineProcess,25);
        System.out.println("Completed: Invalid Flow\n");
    }
}
