package kalva.parking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandExecutor implements AutoCloseable {

  private ParkingLotStore store;

  public void execute(CommandType type, String... args) {
  }

  @Override
  public void close() throws Exception {
    if (null != store) {
      log.info("Closing ParkingLot store");
      store.close();
    }
  }
}
