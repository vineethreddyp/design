import entity.FinalSet;
import impl.DisplayImpl;
import impl.Lane;
import entity.NormalSet;
import impl.PlayerImpl;
import interfaces.Diplay;
import interfaces.Player;
import interfaces.Set;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Player player1 = new PlayerImpl("vineeth",generateSetList());
        Player player2 = new PlayerImpl("avinash",generateSetList());
        Lane lane = new Lane();
        lane.addPlayer(player1);
        lane.addPlayer(player2);
        Diplay diplay = new DisplayImpl();
        lane.registerDisplay(diplay);
        lane.startGame();
        while (!lane.completed()){
            lane.bowl();
        }
        System.out.println("Bowling complete");


    }

    private static List<Set> generateSetList() {
        int i;
        List<Set> setList = new ArrayList<>();
        for(i=0;i<9;i++){
            setList.add(new NormalSet());
        }
        setList.add(new FinalSet());
        return setList;
    }
}
