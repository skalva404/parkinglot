package kalva.parking;

public interface CommandExecutor extends AutoCloseable {

  void execute(CommandType type, String... args);

}
