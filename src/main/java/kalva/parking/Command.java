package kalva.parking;

import com.googlecode.cqengine.IndexedCollection;

import kalva.parking.model.ParkingSlot;

public interface Command<I, O> {

  O runCommand(I i) throws ParkingError;

  void setParkingSlots(final IndexedCollection<ParkingSlot> parkingSlots);
}
