package kalva.parking;

public interface Command<T> {

  T runCommand();

  void setParkingLot(ParkingLot parkingLot);
}
