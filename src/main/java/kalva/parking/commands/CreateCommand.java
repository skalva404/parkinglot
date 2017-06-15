package kalva.parking.commands;

import kalva.parking.Command;
import kalva.parking.ParkingLotStore;

public class CreateCommand implements Command<ParkingLotStore> {

  private ParkingLotStore parkingLotStore;

  public ParkingLotStore runCommand(String... args) {
    return null;
  }

  public void setParkingLotStore(ParkingLotStore parkingLotStore) {
    this.parkingLotStore = parkingLotStore;
  }
}
