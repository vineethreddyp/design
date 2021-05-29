import enums.Color;
import models.Display;
import models.Game;
import models.Player;

public class Main {

    public static void main(String[] args) {
        Display displayPanel = new Display();
        Player player1 = new Player("whitePlayer", Color.WHITE);
        Player player2 = new Player("blackPlayer", Color.BLACK);
        Game game = new Game(player1, player2, displayPanel);
        game.startGame();
    }
}
