package gj.interview.parking.commands;

import static gj.interview.parking.ErrorConstants.*;

import java.util.List;

import gj.interview.parking.ParkingError;
import gj.interview.parking.model.ParkingSlot;

public class RegNumbersByColorCommand extends AbstractCommand<List<ParkingSlot>> {

  private String color;
  private List<ParkingSlot> parkedCars;

  public RegNumbersByColorCommand(List<String> args) throws ParkingError {
    if (null == args || 1 != args.size()) {
      throw new ParkingError(INVALID_ARGS.message());
    }
    color = args.get(0);
  }

  @Override
  public void execute() throws ParkingError {
    if (null != parkedCars) {
      return;
    }
    synchronized (parkingSlotEntity()) {
      parkedCars = parkingSlotEntity().colorToCarIndex().get(color);
    }
  }

  @Override
  public String format() {
    if (null == parkedCars) {
      return DATA_NOT_FOUND.message();
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < parkedCars.size(); i++) {
      builder.append(parkedCars.get(i).car().regNumber());
      if (i != parkedCars.size() - 1) {
        builder.append(", ");
      }
    }
    return builder.toString();
  }

  @Override
  public List<ParkingSlot> result() {
    return parkedCars;
  }
}
