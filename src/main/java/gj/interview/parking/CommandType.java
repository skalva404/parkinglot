package gj.interview.parking;

import gj.interview.parking.commands.CreateCommand;
import gj.interview.parking.commands.LeaveCommand;
import gj.interview.parking.commands.ParkCommand;
import gj.interview.parking.commands.RegNumbersByColorCommand;
import gj.interview.parking.commands.SlotNumberByRegNumberCommand;
import gj.interview.parking.commands.SlotNumbersByColourCommand;
import gj.interview.parking.commands.StatusCommand;

public enum CommandType {
  create_parking_lot(CreateCommand.class),
  park(ParkCommand.class),
  leave(LeaveCommand.class),
  status(StatusCommand.class),
  slot_numbers_for_cars_with_colour(SlotNumbersByColourCommand.class),
  registration_numbers_for_cars_with_colour(RegNumbersByColorCommand.class),
  slot_number_for_registration_number(SlotNumberByRegNumberCommand.class);

  private Class implementation;

  CommandType(Class implementation) {
    this.implementation = implementation;
  }

  public Class getImplementation() {
    return implementation;
  }
}
