package gj.interview.parking;

public interface Service extends AutoCloseable {

  Service start() throws Exception;

}
