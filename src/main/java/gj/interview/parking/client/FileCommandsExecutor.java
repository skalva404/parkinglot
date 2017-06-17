package gj.interview.parking.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gj.interview.parking.Service;
import gj.interview.parking.Utils;
import gj.interview.parking.db.ParkingSlotCarMapping;

public class FileCommandsExecutor implements Service {

  private String commandsFile;

  public FileCommandsExecutor(String commandsFile) {
    this.commandsFile = commandsFile;
  }

  @Override
  public FileCommandsExecutor start() throws IOException {
    final ParkingSlotCarMapping[] table = {null};
    try (Stream<String> stream = Files.lines(Paths.get(commandsFile))) {
      stream.forEach(cmd -> table[0] = Utils.runCommand(cmd, table[0]));
    }
    return this;
  }

  @Override
  public void close() throws Exception {

  }
}
