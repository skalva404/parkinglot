package kalva.testing;

import java.util.Set;

import com.google.common.collect.Sets;
import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import kalva.parking.model.Car;
import kalva.parking.model.ParkingSlot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotServiceTest {

  @Test
  public void testParkingId() {
    Set<ParkingSlot> ids = Sets.newHashSet();
    ids.add(new ParkingSlot(1l));
    ids.add(new ParkingSlot(2l));
    ids.add(new ParkingSlot(1l));
    ids.add(new ParkingSlot(2l));
    ids.add(new ParkingSlot(3l));
    Assert.assertEquals(ids.size(), 3);

    ConcurrentIndexedCollection<ParkingSlot> parkingSlots = new ConcurrentIndexedCollection<>();

    int i = 1;
    for (ParkingSlot next : ids) {
      next.setCar(new Car(String.valueOf(i++), String.valueOf(1)));
      parkingSlots.add(next);
    }
    parkingSlots.add(new ParkingSlot(5l));
    parkingSlots.add(new ParkingSlot(4l));

    SimpleAttribute<ParkingSlot, Long> SLOT_ID = new SimpleAttribute<ParkingSlot, Long>("slotId") {
      public Long getValue(ParkingSlot slot, QueryOptions queryOptions) {
        return slot.id();
      }
    };

//    for (ParkingSlot id :)) {
//      System.out.println(id);
//    }
    System.out.println("===========");
  }
}
