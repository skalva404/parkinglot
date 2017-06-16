package kalva.parking.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import kalva.parking.CommandsParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileCommandsParser implements CommandsParser {

  private String commandsFile;

  public FileCommandsParser(String commandsFile) {
    this.commandsFile = commandsFile;
  }

  @Override
  public void start() throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get(commandsFile))) {
      stream.forEach(command -> {
        System.out.println(command);

      });
    }
  }

  @Override
  public void close() throws Exception {

  }
}
