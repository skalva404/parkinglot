package kalva.testing;

import java.util.Set;

import com.google.common.collect.Sets;

import kalva.parking.entities.ParkingLot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotTest {

  @Test
  public void testParkingId() {
    Set<ParkingLot.ParkingId> ids = Sets.newHashSet();
    ids.add(new ParkingLot.ParkingId(1));
    ids.add(new ParkingLot.ParkingId(2));
    ids.add(new ParkingLot.ParkingId(1));
    ids.add(new ParkingLot.ParkingId(2));
    ids.add(new ParkingLot.ParkingId(3));
    Assert.assertEquals(ids.size(), 3);
  }
}
