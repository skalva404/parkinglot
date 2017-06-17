package gj.interview.parking.commands;

import gj.interview.parking.Command;
import gj.interview.parking.db.ParkingSlotCarMapping;

abstract class AbstractCommand<T> implements Command<T> {

  private ParkingSlotCarMapping slotCarMapping;

  AbstractCommand() {
  }

  public void setSlotCarMapping(ParkingSlotCarMapping slotCarMapping) {
    this.slotCarMapping = slotCarMapping;
  }

  ParkingSlotCarMapping parkingSlotEntity() {
    return this.slotCarMapping;
  }
}
