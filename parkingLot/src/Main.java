import entity.Admin;
import entity.CompactSpot;
import entity.CustomerInfoPortal;
import entity.ElectricSpot;
import entity.EntryPoint;
import entity.ExitPoint;
import entity.MotorCycleSpot;
import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;
import enums.ParkingSpotType;
import functions.Procedures;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ParkingLot!");
        ParkingLot parkingLot  = generateParkingLot();
        Vehicle compactVehicle = new Vehicle("TS36F9999", ParkingSpotType.Compact);
        Vehicle motorCycle = new Vehicle("AP23F5678", ParkingSpotType.Motorcycle);
        Vehicle electricVehicle = new Vehicle("TS12G3456", ParkingSpotType.Electric);
        Procedures.sendAVehicleIntoParkingLot(parkingLot, compactVehicle);
        addNewParkingFloor(parkingLot);
        Procedures.sendAVehicleIntoParkingLot(parkingLot, motorCycle);
        Procedures.sendAVehicleIntoParkingLot(parkingLot, electricVehicle);
        floorWiseDisplay(parkingLot);
        Procedures.sendAVehicleOutOfParkingLot(parkingLot,motorCycle);
        Procedures.sendAVehicleOutOfParkingLotUsingCustomerPotal(parkingLot,compactVehicle);
        Procedures.sendAVehicleOutOfParkingLot(parkingLot, electricVehicle);
        System.out.println("Completed parking Lot program");
    }

    private static void floorWiseDisplay(ParkingLot parkingLot) {
        System.out.println("Floor wise display start");
        parkingLot.getParkingFloorList().forEach(ParkingFloor::printDisplayBoard);
        System.out.println("Floor wise display end");

    }

    private static void addNewParkingFloor(ParkingLot parkingLot) {
        Admin vineeth = new Admin();
        ParkingFloor parkingFloor2 = new ParkingFloor("2nd floor");
        CustomerInfoPortal customerInfoPortal2 = new CustomerInfoPortal("customer portal 2");
        addParkingSpots(vineeth,parkingFloor2);
        vineeth.addParkingFloor(parkingLot,parkingFloor2);
        vineeth.addCustomerPotal(parkingFloor2,customerInfoPortal2);
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
        CustomerInfoPortal customerInfoPortal = new CustomerInfoPortal("customer portal 1");
        addParkingSpots(vineeth,parkingFloor1);
        vineeth.addParkingFloor(parkingLot, parkingFloor1);
        vineeth.addCustomerPotal(parkingFloor1, customerInfoPortal);
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
        EntryPoint entryPoint1 = new EntryPoint("1st entry point");
        ExitPoint exitPoint1 = new ExitPoint("1st exit point");
        vineeth.addEntryPoint(parkingLot,entryPoint1);
        vineeth.addExitPoint(parkingLot, exitPoint1);
    }

}
