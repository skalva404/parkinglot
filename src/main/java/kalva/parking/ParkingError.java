package kalva.parking;

public class ParkingError extends Exception {
  private String message;
  private Throwable throwable;

  public ParkingError(String message) {
    super(message);
    this.message = message;
  }

  public ParkingError(String message, Throwable throwable) {
    super(throwable);
    this.message = message;
    this.throwable = throwable;
  }
}
