public class Main {

    public static void main(String[] args) throws InterruptedException {

        Environment environment = new Environment(20,20);
        GameController gameController = new GameController(300L, "vineeth",environment);
        gameController.start();
    }
}
