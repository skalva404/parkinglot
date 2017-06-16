package kalva.parking.commands;

import java.util.List;

import com.google.common.collect.Lists;

import kalva.parking.ParkingError;
import kalva.parking.model.ParkingSlot;

public class StatusCommand extends AbstractCommand<Void, List<ParkingSlot>> {

  @Override
  public List<ParkingSlot> runCommand(Void voidD) throws ParkingError {
    List<ParkingSlot> slots = Lists.newArrayList();
    parkingSlots().iterator().forEachRemaining(slots::add);
    return slots;
  }
}
