import entity.Admin;
import entity.CompactSpot;
import entity.ElectricSpot;
import entity.EntryPoint;
import entity.ExitPoint;
import entity.MotorCycleSpot;
import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;
import functions.Procedures;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ParkingLot!");
        ParkingLot parkingLot  = generateParkingLot();
        Vehicle vehicle1 = new Vehicle("TS36F8109");
        Vehicle vehicle2 = new Vehicle("AP2345678");

        Procedures.sendAVehicleIntoParkingLot(parkingLot, vehicle1);
        Procedures.sendAVehicleIntoParkingLot(parkingLot, vehicle2 );
        System.out.println("Completed parking Lot");
    }



    private static ParkingLot generateParkingLot() {
        Admin vineeth = new Admin();
        ParkingLot parkingLot = new ParkingLot("Vineeth's parking lot", "Hyderabad");
        addParkingFloor(vineeth,parkingLot);
        addEntryAndExitPoints(vineeth,parkingLot);
        return parkingLot;
    }

    private static void addParkingFloor(Admin vineeth, ParkingLot parkingLot) {
        ParkingFloor parkingFloor1 = new ParkingFloor("1st floor");
        addParkingSpots(vineeth,parkingFloor1);
        vineeth.addParkingFloor(parkingLot, parkingFloor1);
    }

    private static void addParkingSpots(Admin vineeth, ParkingFloor parkingFloor1) {
        ParkingSpot electricSpot1, compactSpot1, motorCycleSpot1;
        electricSpot1 = new ElectricSpot();
        compactSpot1 = new CompactSpot();
        motorCycleSpot1 = new MotorCycleSpot();
        List<ParkingSpot> parkingSpotList = Arrays.asList(electricSpot1, compactSpot1, motorCycleSpot1);
        for(ParkingSpot parkingSpot : parkingSpotList){
            vineeth.addParkingSpot(parkingFloor1, parkingSpot);
        }
    }

    private static void addEntryAndExitPoints(Admin vineeth, ParkingLot parkingLot) {
        EntryPoint entryPoint1 = new EntryPoint();
        ExitPoint exitPoint1 = new ExitPoint();
        vineeth.addEntryPoint(parkingLot,entryPoint1);
        vineeth.addExitPoint(parkingLot, exitPoint1);
    }

}
