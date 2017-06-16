package kalva.parking.entities;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
public class Car {

  public static final SimpleAttribute<Car, String> CAR_ID = new SimpleAttribute<Car, String>("regNumber") {
    public String getValue(Car car, QueryOptions queryOptions) {
      return car.regNumber;
    }
  };

  public static final SimpleAttribute<Car, String> CAR_COLOR = new SimpleAttribute<Car, String>("color") {
    public String getValue(Car car, QueryOptions queryOptions) {
      return car.color;
    }
  };

  @Accessors(fluent = true)
  private String regNumber;
  @Accessors(fluent = true)
  private String color;

  private Car() {
  }
}
