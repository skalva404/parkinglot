package kalva.parking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class Car {
  private String regNumber;
  private String color;

  private Car() {
  }
}
