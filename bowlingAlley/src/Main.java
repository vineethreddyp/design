import entity.BowlingAlley;
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
        System.out.println("Bowling Alley!");
        BowlingAlley bowlingAlley = generateBowlingAlley();
        Lane lane = bowlingAlley.getLaneList().get(0);
        addPlayersToLane(lane);
        addDisplayToLane(lane);
        lane.startGame();
        while (!lane.completed()){
            lane.bowl();
        }
        lane.reset();
        System.out.println("Bowling Alley Done");
    }

    private static void addDisplayToLane(Lane lane) {
        Diplay diplay = new DisplayImpl();
        lane.registerDisplay(diplay);
    }

    private static void addPlayersToLane(Lane lane) {
        Player player1 = new PlayerImpl("vineeth",generateSetList(lane.getMaxPins()));
        Player player2 = new PlayerImpl("avinash",generateSetList(lane.getMaxPins()));
        lane.addPlayer(player1);
        lane.addPlayer(player2);
    }

    private static BowlingAlley generateBowlingAlley(){
        BowlingAlley bowlingAlley = new BowlingAlley();
        Lane lane = new Lane(10);
        bowlingAlley.addLane(lane);
        return bowlingAlley;
    }

    private static List<Set> generateSetList(Integer maxPins) {
        int i;
        List<Set> setList = new ArrayList<>();
        for(i=0;i<9;i++){
            setList.add(new NormalSet(maxPins));
        }
        setList.add(new FinalSet(maxPins));
        return setList;
    }
}
