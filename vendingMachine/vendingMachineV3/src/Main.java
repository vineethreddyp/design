import entity.Admin;
import entity.Coin;
import entity.DisplayPanel;
import entity.Product;
import entity.User;
import impl.CoinManagementImpl;
import impl.ProductManagementImpl;
import impl.VendingMachineImpl;
import entity.InventoryManagement;

public class Main {

    public static void main(String[] args) {
        System.out.println("Vending Machine Up!");
        VendingMachineImpl vendingMachine = generateVendingMachine();
        Admin vineethAdmin = new Admin(vendingMachine,"temporary admin");
        User customer = new User(vendingMachine);
        DisplayPanel displayPanel = new DisplayPanel(vendingMachine);

        while (true){
            vineethAdmin.printCoinsInMachine(); // this line for debug purpose only. this can be commented
            displayPanel.display();
            customer.selectProduct();
            customer.insertCoinForPayment();
        }
    }


    private static VendingMachineImpl generateVendingMachine() {
        ProductManagementImpl productManagement = new ProductManagementImpl();
        CoinManagementImpl coinInventoryManagement = new CoinManagementImpl();
        VendingMachineImpl vendingMachine = new VendingMachineImpl("Vineeth's vending machine",productManagement, coinInventoryManagement);
        Admin vineeth = new Admin(vendingMachine,"vineeth");
        vineeth.addQuantityForAProduct(Product.Coke, 10);
        vineeth.addQuantityForAProduct(Product.Soda, 20);
        vineeth.addQuantityForAProduct(Product.Pepsi, 10);
        vineeth.addChangeInsideMachine(Coin.TwentyFive, 2);
        vineeth.addChangeInsideMachine(Coin.Five, 1);
        vineeth.addChangeInsideMachine(Coin.One, 1);
        vineeth.addChangeInsideMachine(Coin.Ten, 2);
        return vendingMachine;
    }
}
