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
        testHappyFlow(vendingMachine, customer);
        testChangeDisperseFlow(vendingMachine, customer);
        testAbortFlow(vendingMachine,customer);

    }

    private static void testChangeDisperseFlow(VendingMachine vendingMachine, User customer) {
        System.out.println("\nStarted: Change Disperse");
        vendingMachine.handle();
        customer.selectProduct(Product.Pepsi);//  select pepsi cost 35
        customer.insertCoinForPayment(25);
        vendingMachine.handle();
        customer.insertCoinForPayment(25);
        vendingMachine.handle();
        System.out.println("Completed: Change Disperse\n");
    }


    private static void testAbortFlow(VendingMachine vendingMachine, User customer) {
        System.out.println("\nStarted: Abort Flow");
        vendingMachine.handle();
        vendingMachine.handle();
        customer.selectProduct(Product.Coke);//  select soda
        customer.insertCoinForPayment(10);
        vendingMachine.handle();
        customer.insertCoinForPayment(-1);
        vendingMachine.handle();
        System.out.println("Completed: Abort Flow\n");

    }

    private static void testHappyFlow(VendingMachine vendingMachine, User customer) {
        System.out.println("\nStarted: Happy Flow");
        vendingMachine.handle();
        customer.selectProduct(Product.Soda);//  select soda
        customer.insertCoinForPayment(25);
        vendingMachine.handle();
        customer.insertCoinForPayment(10);
        vendingMachine.handle();
        customer.insertCoinForPayment(10);
        vendingMachine.handle();
        System.out.println("Completed: Happy Flow\n");
    }
}
