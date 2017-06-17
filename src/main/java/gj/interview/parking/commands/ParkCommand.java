package gj.interview.parking.commands;

import static gj.interview.parking.ErrorConstants.*;
import static gj.interview.parking.commands.CommandConstants.*;

import java.util.List;

import gj.interview.parking.ParkingError;
import gj.interview.parking.model.Car;
import gj.interview.parking.model.ParkingSlot;

public class ParkCommand extends AbstractCommand<ParkingSlot> {

  private Car car;
  private ParkingSlot parkingSlot;

  public ParkCommand(List<String> args) throws ParkingError {
    if (null == args || 2 != args.size()) {
      throw new ParkingError(INVALID_ARGS.message());
    }

    try {
      this.car = new Car(args.get(0), args.get(1));
    } catch (Exception e) {
      throw new ParkingError(INVALID_ARGS.message());
    }
  }

  @Override
  public void execute() throws ParkingError {
    if (null != parkingSlot) {
      return;
    }
    synchronized (parkingSlotEntity()) {
      parkingSlot = parkingSlotEntity().park(car);
    }
  }

  @Override
  public String format() {
    if (null == this.parkingSlot) {
      return DATA_NOT_FOUND.message();
    }
    return String.format(PARK.message(), parkingSlot.id());
  }

  @Override
  public ParkingSlot result() {
    return parkingSlot;
  }
}
