package kalva.parking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ParkingLot {

  private long MAX = -1;


  public ParkingLot(long capacity) {
    this.MAX = capacity;
  }

  @Data
  @AllArgsConstructor
  @Accessors(fluent = true)
  public static class ParkingId {
    private long id;

    private ParkingId() {
    }
  }
}
