package gj.interview.parking.service;

import static gj.interview.parking.ErrorConstants.*;

import java.io.File;

import gj.interview.parking.ParkingError;
import gj.interview.parking.Service;
import gj.interview.parking.client.FileCommandsExecutor;
import gj.interview.parking.client.InteractiveCommandsParser;

public class ParkingApp implements Service {

  private Service parser = null;
  private String[] args;

  private ParkingApp(String[] args) {
    this.args = args;
  }

  public static void main(String[] args) throws Exception {
    ParkingApp service = new ParkingApp(args);
    service.start();
    service.close();
  }

  @Override
  public ParkingApp start() throws Exception {
    if (0 == args.length) {
      System.out.println("Running in interactive mode");
      parser = new InteractiveCommandsParser();
    } else {
      String file = args[0];
      System.out.println("Running commands from " + file);
      File commands = new File(file);
      if (!commands.exists()) {
        throw new ParkingError(FNF.message() + file);
      }
      parser = new FileCommandsExecutor(commands.getAbsolutePath());
    }
    parser.start();
    return this;
  }

  @Override
  public void close() throws Exception {
    parser.close();
  }
}
