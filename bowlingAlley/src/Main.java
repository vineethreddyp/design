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
        Lane lane1 = bowlingAlley.getLaneList().get(0);
        addPlayersToLane(lane1);
        addDisplayToLane(lane1);
        lane1.startGame();
        while (!lane1.completed()){
            lane1.bowl();
        }
        lane1.reset();

        Lane lane2 = bowlingAlley.getLaneList().get(1);
        addPlayersToLane(lane2);
        addDisplayToLane(lane2);
        lane2.startGame();
        while (!lane2.completed()){
            lane2.bowl();
        }
        lane2.reset();
        addPlayersToLane(lane2);
        lane2.startGame();
        while (!lane2.completed()){
            lane2.bowl();
        }
        lane2.reset();

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
        Lane lane = new Lane("1",10);
        bowlingAlley.addLane(lane);
        bowlingAlley.addLane(new Lane("2",10));
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
