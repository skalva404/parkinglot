package kalva.parking;

public class Result<T> {

  private T result;
  private Status status;

  public Result(Result.Status status, T result) {
    this.status = status;
    this.result = result;
  }

  public Result.Status getStatus() {
    return status;
  }

  public T getResult() {
    return result;
  }

  public static enum Status {
    SUCCESS, FAILED
  }
}
