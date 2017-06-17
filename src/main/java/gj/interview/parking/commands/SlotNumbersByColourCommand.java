package gj.interview.parking.commands;

import static gj.interview.parking.ErrorConstants.*;

import java.util.List;

import gj.interview.parking.ParkingError;
import gj.interview.parking.model.ParkingSlot;

public class SlotNumbersByColourCommand extends AbstractCommand<List<ParkingSlot>> {

  private String color;
  private List<ParkingSlot> slots;

  public SlotNumbersByColourCommand(List<String> args) throws ParkingError {
    if (null == args || 1 != args.size()) {
      throw new ParkingError(EMPTY_LOT_SIZE.message());
    }
    color = args.get(0);
  }

  @Override
  public void execute() throws ParkingError {
    if (null != slots) {
      return;
    }
    synchronized (parkingSlotEntity()) {
      slots = parkingSlotEntity().colorToCarIndex().get(color);
    }
  }

  @Override
  public String format() {
    if (null == slots) {
      return DATA_NOT_FOUND.message();
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < slots.size(); i++) {
      builder.append(slots.get(i).id());
      if (i != slots.size() - 1) {
        builder.append(", ");
      }
    }
    return builder.toString();
  }

  @Override
  public List<ParkingSlot> result() {
    return slots;
  }
}
