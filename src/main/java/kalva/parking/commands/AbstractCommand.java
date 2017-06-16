package kalva.parking.commands;

import com.googlecode.cqengine.IndexedCollection;

import kalva.parking.Command;
import kalva.parking.model.ParkingSlot;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
abstract class AbstractCommand<I, O> implements Command<I, O> {

  private IndexedCollection<ParkingSlot> parkingSlots;

  @Override
  public void setParkingSlots(IndexedCollection<ParkingSlot> parkingSlots) {
    this.parkingSlots = parkingSlots;
  }
}
