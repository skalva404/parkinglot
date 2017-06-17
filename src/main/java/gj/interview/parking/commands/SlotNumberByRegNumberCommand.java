package gj.interview.parking.commands;

import static gj.interview.parking.ErrorConstants.*;

import java.util.List;

import gj.interview.parking.ParkingError;
import gj.interview.parking.model.ParkingSlot;

public class SlotNumberByRegNumberCommand extends AbstractCommand<ParkingSlot> {

  private String regNum;
  private ParkingSlot slot;

  public SlotNumberByRegNumberCommand(List<String> args) throws ParkingError {
    if (null == args || 1 != args.size()) {
      throw new ParkingError(INVALID_ARGS.message());
    }
    regNum = args.get(0);
  }

  @Override
  public void execute() throws ParkingError {
    if (null != slot) {
      return;
    }
    synchronized (parkingSlotEntity()) {
      slot = parkingSlotEntity().regNumToSlotIndex().get(regNum);
    }
  }

  @Override
  public String format() {
    if (null == slot) {
      return DATA_NOT_FOUND.message();
    }
    return slot.id().toString();
  }

  @Override
  public ParkingSlot result() {
    return slot;
  }
}
