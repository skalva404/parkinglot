package kalva.parking;

import kalva.parking.commands.CreateCommand;

public enum CommandType {
  create_parking_lot(CreateCommand.class, CommandMode.WRITE);
//  , park, leave, status,
//  registration_numbers_for_cars_with_colour,
//  slot_numbers_for_cars_with_colour,
//  slot_number_for_registration_number;

  private Class implementation;
  private CommandMode mode;

  CommandType(Class implementation, CommandMode mode) {
    this.mode = mode;
    this.implementation = implementation;
  }

  public Class getImplementation() {
    return implementation;
  }

  public CommandMode getMode() {
    return mode;
  }

  public enum CommandMode {
    READ, WRITE, READ_WRITE
  }
}
