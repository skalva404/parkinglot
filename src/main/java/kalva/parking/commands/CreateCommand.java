package kalva.parking.commands;

import com.google.common.base.Preconditions;

import kalva.parking.service.ParkingLotService;

public class CreateCommand extends AbstractCommand<Long, ParkingLotService> {

  @Override
  public ParkingLotService runCommand(Long size) {
    Preconditions.checkArgument(size != null, "ParkingLot size can not be empty ...");
    return (ParkingLotService) new ParkingLotService(size).start();
  }
}
