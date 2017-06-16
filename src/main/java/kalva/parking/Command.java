package kalva.parking;

import com.googlecode.cqengine.IndexedCollection;

import kalva.parking.entities.ParkingSlot;

public interface Command<T> {

  T runCommand(String... args);

  void setParkingSlots(final IndexedCollection<ParkingSlot> parkingSlots);
}
