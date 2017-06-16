package kalva.parking.model;

import static kalva.parking.model.ParkingSlot.SlotStatus.*;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ParkingSlot {

  public static final SimpleAttribute<ParkingSlot, Car> CAR = new SimpleAttribute<ParkingSlot, Car>("car") {
    public Car getValue(ParkingSlot parkingSlot, QueryOptions queryOptions) {
      return parkingSlot.car;
    }
  };

  private Long id;
  private Car car;
  private SlotStatus status = FREE;

  private ParkingSlot() {
  }

  public ParkingSlot(Long id) {
    this.id = id;
  }

  public void setCar(Car car) {
    this.car = car;
    this.status = SlotStatus.OCCUPIED;
  }

  public void unSetCar() {
    this.car = null;
    this.status = SlotStatus.FREE;
  }

  public static enum SlotStatus {
    OCCUPIED, FREE
  }
}
