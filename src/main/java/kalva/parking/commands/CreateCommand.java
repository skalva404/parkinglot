package kalva.parking.commands;

import kalva.parking.Command;
import kalva.parking.ParkingLot;

public class CreateCommand implements Command<ParkingLot> {

  private ParkingLot parkingLot;

  public ParkingLot runCommand() {
    return null;
  }

  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
}
