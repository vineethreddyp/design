import entity.Admin;
import entity.Coin;
import entity.Product;
import entity.VendingMachine;

public class Main {

    public static void main(String[] args) {
        System.out.println("Vending Machine Up!");
        VendingMachine vendingMachine = generateVendingMachine();
        Admin vineeth = new Admin();
        while (true){
            vendingMachine.display();
            vineeth.printCoinState(vendingMachine); // this line for debug purpose only. this can be commented
        }

    }


    private static VendingMachine generateVendingMachine() {

        VendingMachine vendingMachine = new VendingMachine("Vineeth's vending machine");
        Admin vineeth = new Admin();
        vineeth.addQuantityForAProduct(vendingMachine, Product.Coke, 10);
        vineeth.addQuantityForAProduct(vendingMachine, Product.Soda, 20);
        vineeth.addQuantityForAProduct(vendingMachine, Product.Pepsi, 10);
        vineeth.addChangeInsideMachine(vendingMachine, Coin.TwentyFive, 2);
        vineeth.addChangeInsideMachine(vendingMachine, Coin.Five, 5);
        vineeth.addChangeInsideMachine(vendingMachine, Coin.One, 1);
        vineeth.addChangeInsideMachine(vendingMachine, Coin.Ten, 2);
        return vendingMachine;
    }
}
