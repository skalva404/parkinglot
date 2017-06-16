package kalva.parking.commands;

import static com.googlecode.cqengine.query.QueryFactory.*;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;

import kalva.parking.ParkingError;
import kalva.parking.model.Car;
import kalva.parking.model.ParkingSlot;

public class ParkCommand extends AbstractCommand<Car, ParkingSlot> {

  @Override
  public ParkingSlot runCommand(Car car) throws ParkingError {
    ResultSet<ParkingSlot> resultSet = parkingSlots().retrieve(
        QueryFactory.equal(
            new SimpleAttribute<ParkingSlot, ParkingSlot.SlotStatus>("slotStatus") {
              public ParkingSlot.SlotStatus getValue(ParkingSlot parkingSlot, QueryOptions queryOptions) {
                return parkingSlot.status();
              }
            }, ParkingSlot.SlotStatus.FREE)
        , queryOptions(orderBy(ascending(new SimpleAttribute<ParkingSlot, Long>("slotId") {
          public Long getValue(ParkingSlot slot, QueryOptions queryOptions) {
            return slot.id();
          }
        }))));
    if (!resultSet.iterator().hasNext()) {
      throw new ParkingError("All parking slots are full, please try later...");
    }
    ParkingSlot slot = resultSet.iterator().next();
    slot.setCar(car);
    return slot;
  }
}
