package kalva.parking;

import java.io.IOException;

public interface CommandsParser extends AutoCloseable {
  void start() throws IOException;
}
