package kalva.testing;

import static java.util.Collections.*;

import java.util.Set;

import com.google.common.collect.Sets;
import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;

import kalva.parking.entities.Car;
import kalva.parking.entities.ParkingSlot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotTest {

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
    for (ParkingSlot id : parkingSlots.retrieve(
        QueryFactory.equal(
            new SimpleAttribute<ParkingSlot, Car>("car") {
              public Car getValue(ParkingSlot parkingSlot, QueryOptions queryOptions) {
                return parkingSlot.car();
              }
            },
            new Car("1", "1")))) {
//      System.out.println(id.car());
    }
    System.out.println("===========");

    for (ParkingSlot id : parkingSlots.retrieve(
        QueryFactory.equal(
            new MultiValueAttribute<ParkingSlot, String>() {
              @Override
              public Iterable<String> getValues(ParkingSlot parkingSlot, QueryOptions queryOptions) {
                return singletonList(parkingSlot.car().color());
              }
            }, "1"
        ))) {
//      System.out.println(id.car());
    }
    System.out.println("===========");


    System.out.println("===========");
  }
}
