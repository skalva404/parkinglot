package gj.interview.parking.commands;

import static gj.interview.parking.ErrorConstants.*;
import static gj.interview.parking.commands.CommandConstants.*;

import java.util.List;

import gj.interview.parking.ParkingError;
import gj.interview.parking.service.ParkingLotService;

public class CreateCommand extends AbstractCommand<ParkingLotService> {

  private Long size;
  private ParkingLotService plService;

  public CreateCommand(List<String> args) throws ParkingError {
    if (null == args || 1 != args.size()) {
      throw new ParkingError(INVALID_ARGS.message());
    }
    try {
      size = Long.parseLong(args.get(0));
    } catch (Exception e) {
      throw new ParkingError(INVALID_ARGS.message() + args.get(0));
    }
  }

  @Override
  public void execute() throws ParkingError {
    if (null != plService) {
      return;
    }
    plService = new ParkingLotService(size).start();
  }

  @Override
  public String format() {
    if (null == plService) {
      return DATA_NOT_FOUND.message();
    }
    return String.format(CREATE.message(),
        plService.parkingSlotTable().totalSlots().size());
  }

  @Override
  public ParkingLotService result() {
    return plService;
  }
}
