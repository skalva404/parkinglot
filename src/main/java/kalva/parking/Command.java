package kalva.parking;

public interface Command<T> {

  T runCommand(String... args);

  void setParkingLotStore(ParkingLotStore parkingLotStore);
}
