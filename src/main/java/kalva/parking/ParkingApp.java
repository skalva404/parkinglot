package kalva.parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import kalva.parking.client.FileCommandsParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParkingApp {

  public static void main(String[] args) throws IOException {
    log.info("Starting ParkingApp ....! ");
    if (0 == args.length) {
      log.info("Running in interactive mode");
    } else {
      String file = args[0];
      log.info("Running commands from " + file);
      File commands = new File(file);
      if (!commands.exists()) {
        throw new FileNotFoundException(file);
      }
      CommandsParser parser = new FileCommandsParser(commands.getAbsolutePath());
      parser.start();
    }
  }
}
