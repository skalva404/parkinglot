package kalva.parking.commands;

import com.google.common.base.Preconditions;
import com.googlecode.cqengine.IndexedCollection;

import kalva.parking.Command;
import kalva.parking.entities.ParkingLot;
import kalva.parking.entities.ParkingSlot;

public class CreateCommand implements Command<ParkingLot> {


  @Override
  public ParkingLot runCommand(String... args) {
    Preconditions.checkArgument(args != null && null != args[0],
        "ParkingLot size can not be empty ...");
    return new ParkingLot(Long.parseLong(args[0]));
  }

  @Override
  public void setParkingSlots(final IndexedCollection<ParkingSlot> parkingSlots) {

  }
}
