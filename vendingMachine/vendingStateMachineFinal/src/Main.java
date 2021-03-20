import datastore.StateMachineStore;
import entity.Coin;
import entity.Product;
import impl.AdminImpl;
import impl.CoinManagementImpl;
import impl.DisplayPanelImpl;
import impl.ProductManagementImpl;
import impl.UserImpl;
import state.VendingMachineAdministrator;
import state.VendingMachineChangeDisperse;
import state.VendingMachineIdle;
import impl.VendingMachineImpl;
import state.VendingMachineProcess;
import state.VendingMachineProductDisperse;
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

        StateMachineStore stateMachineStore = generateStateMachine(productManagement, coinInventoryManagement);
        Admin vineethAdmin = new AdminImpl("vineeth",  stateMachineStore);

        VendingMachine vendingMachine = new VendingMachineImpl("Vineeth's vending machine", stateMachineStore);
        // machine starts in user mode.
        // set in admin mode and insert coins, product
        vineethAdmin.setInAdminMode();
        populateTheMachine(vineethAdmin);
        User customer = new UserImpl(vendingMachine);
        vineethAdmin.makeMachineAvailableForUsers();
        testHappyFlow(customer, vendingMachine);
        testChangeDisperseFlow(customer, vendingMachine);
        testAbortFlow(customer, vendingMachine);
        testInvalidFlow(customer, vendingMachine);
    }

    private static void populateTheMachine(Admin vineethAdmin) {
        System.out.println("Started: Adding coins and products");
        vineethAdmin.addQuantityForAProduct(Product.Coke, 10);
        vineethAdmin.addQuantityForAProduct(Product.Soda, 20);
        vineethAdmin.addQuantityForAProduct(Product.Pepsi, 10);
        vineethAdmin.addChangeInsideMachine(Coin.TwentyFive, 2);
        vineethAdmin.addChangeInsideMachine(Coin.Five, 1);
        vineethAdmin.addChangeInsideMachine(Coin.One, 1);
        vineethAdmin.addChangeInsideMachine(Coin.Ten, 2);
        System.out.println("Completed: Adding coins and products");
    }

    private static StateMachineStore generateStateMachine(ProductManagment productManagment, CoinManagement coinManagement) {
        StateMachineStore stateMachineStore = new StateMachineStore(productManagment, coinManagement);
        VendingMachine vendingMachineIdle = new VendingMachineIdle(stateMachineStore);
        VendingMachine vendingMachineProcess = new VendingMachineProcess(stateMachineStore);
        VendingMachine vendingMachineChangeDisperse = new VendingMachineChangeDisperse(stateMachineStore);
        VendingMachine vendingMachineProductDisperse = new VendingMachineProductDisperse(stateMachineStore);
        VendingMachine vendingMachineAdminstrator = new VendingMachineAdministrator(stateMachineStore);
        stateMachineStore.setVendingMachineIdle(vendingMachineIdle);
        stateMachineStore.setVendingMachineProcess(vendingMachineProcess);
        stateMachineStore.setVendingMachineChangeDisperse(vendingMachineChangeDisperse);
        stateMachineStore.setVendingMachineProductDisperse(vendingMachineProductDisperse);
        stateMachineStore.setVendingMachineAdministrator(vendingMachineAdminstrator);
        DisplayPanel displayPanel = new DisplayPanelImpl();
        stateMachineStore.setDisplayPanel(displayPanel);
        stateMachineStore.setIdleState();
        return stateMachineStore;
    }

    private static void testChangeDisperseFlow(User customer, VendingMachine vendingMachine) {
        System.out.println("\nStarted: Change Disperse Flow ");
        customer.selectProduct(Product.Pepsi);//  select soda
        customer.insertCoinForPayment(25);
        customer.selectProduct(Product.Soda);
        customer.insertCoinForPayment(25);
        System.out.println("Completed: Change Disperse Flow\n");
    }


    private static void testAbortFlow(User customer, VendingMachine vendingMachine) {
        System.out.println("\nStarted: Abort Flow");
        customer.insertCoinForPayment(10);
        customer.selectProduct(Product.Coke);//  select soda
        customer.insertCoinForPayment(10);
        customer.insertCoinForPayment(5);
        customer.insertCoinForPayment(-1);
        System.out.println("Completed: Abort Flow\n");

    }

    private static void testHappyFlow(User customer, VendingMachine vendingMachine) {
        System.out.println("\nStarted: Happy Flow");
        customer.selectProduct(Product.Soda);//  select soda
        customer.insertCoinForPayment(25);
        customer.insertCoinForPayment(10);
        customer.insertCoinForPayment(10);
        System.out.println("Completed: Happy Flow\n");
    }

    private static void testInvalidFlow(User customer, VendingMachine vendingMachine) {
        System.out.println("\nStarted: Invalid Flow");
        customer.selectProduct(Product.Soda);//  select soda
        customer.insertCoinForPayment(25);
        customer.selectProduct(Product.Coke);
        customer.insertCoinForPayment(10);
        customer.insertCoinForPayment(25);
        System.out.println("Completed: Invalid Flow\n");
    }
}
