package kalva.parking.entities;

import java.util.stream.LongStream;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ParkingLot {

  private long MAX = 10;
  IndexedCollection<ParkingSlot> parkingSlots;

  public ParkingLot() {
    this(10);
  }

  public ParkingLot(long capacity) {
    this.MAX = capacity;
    parkingSlots = new ConcurrentIndexedCollection<>();
    LongStream.rangeClosed(1, MAX).forEach(id -> parkingSlots.add(new ParkingSlot(id)));
  }

  public ParkingSlot getParkingSlot(Long id) {
    ResultSet<ParkingSlot> retrieve = parkingSlots.retrieve(
        QueryFactory.equal(
            new SimpleAttribute<ParkingSlot, Long>("slotId") {
              public Long getValue(ParkingSlot parkingSlot, QueryOptions queryOptions) {
                return parkingSlot.id();
              }
            },
            id));
    if (!retrieve.iterator().hasNext()) {
      return null;
    }
    return retrieve.iterator().next();
  }
}
