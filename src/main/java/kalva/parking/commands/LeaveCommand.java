package kalva.parking.commands;

import kalva.parking.ParkingError;
import kalva.parking.model.ParkingSlot;

public class LeaveCommand extends AbstractCommand<Long, ParkingSlot> {

  @Override
  //TODO validations for input params
  public ParkingSlot runCommand(Long slotId) throws ParkingError {
    final ParkingSlot[] parkingSlot = {null};
    parkingSlots().iterator().forEachRemaining(slot -> {
      if (!slotId.equals(slot.id())) {
        return;
      }
      parkingSlot[0] = slot;
    });
    if (null == parkingSlot[0]) {
      throw new ParkingError(String.format("Slot %s is not a valid number", slotId));
    }
    return parkingSlot[0];
  }
}
