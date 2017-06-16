package kalva.parking.service;

import static com.googlecode.cqengine.query.QueryFactory.*;

import java.util.List;
import java.util.stream.LongStream;

import com.google.common.collect.Lists;
import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;

import kalva.parking.ParkingService;
import kalva.parking.model.ParkingSlot;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ParkingLotService implements ParkingService {

  private long size = 10;
  IndexedCollection<ParkingSlot> parkingSlots;

  public ParkingLotService() {
    this(10);
  }

  public ParkingLotService(long capacity) {
    this.size = capacity;
  }

  public List<ParkingSlot> freeSlots() {
    return parkingSlots(ParkingSlot.SlotStatus.FREE);
  }

  public List<ParkingSlot> occupiedSlots() {
    return parkingSlots(ParkingSlot.SlotStatus.OCCUPIED);
  }

  public List<ParkingSlot> totalSlots() {
    List<ParkingSlot> slots = Lists.newArrayList();
    parkingSlots.iterator().forEachRemaining(slots::add);
    return slots;
  }

  private List<ParkingSlot> parkingSlots(ParkingSlot.SlotStatus status) {
    List<ParkingSlot> slots = Lists.newArrayList();
    parkingSlots.retrieve(
        QueryFactory.equal(
            new SimpleAttribute<ParkingSlot, ParkingSlot.SlotStatus>("slotStatus") {
              public ParkingSlot.SlotStatus getValue(ParkingSlot parkingSlot, QueryOptions queryOptions) {
                return parkingSlot.status();
              }
            }, status)
        , queryOptions(orderBy(ascending(new SimpleAttribute<ParkingSlot, Long>("slotId") {
          public Long getValue(ParkingSlot slot, QueryOptions queryOptions) {
            return slot.id();
          }
        })))).iterator().forEachRemaining(slots::add);
    return slots;
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

  @Override
  public ParkingService start() {
    parkingSlots = new ConcurrentIndexedCollection<>();
    LongStream.rangeClosed(1, size).forEach(id -> parkingSlots.add(new ParkingSlot(id)));
    return this;
  }

  @Override
  public void close() throws Exception {

  }
}
