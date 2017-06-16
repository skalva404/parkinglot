package kalva.testing;

import kalva.parking.commands.CreateCommand;
import kalva.parking.entities.ParkingLot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommandsTest {

  @Test
  public void testCreate() {
    CreateCommand command = new CreateCommand();

    Exception exception = null;
    try {
      command.runCommand(null);
    } catch (Exception iae) {
      exception = iae;
    }
    Assert.assertNotNull(exception);
    exception = null;

    try {
      command.runCommand(new String[0]);
    } catch (Exception iae) {
      exception = iae;
    }
    Assert.assertNotNull(exception);
    exception = null;

    try {
      ParkingLot parkingLot = command.runCommand("2");
      Assert.assertNotNull(parkingLot);
    } catch (Exception iae) {
      exception = iae;
    }
    Assert.assertNull(exception);
  }

  @Test
  public void testPark() {

  }

  @Test
  public void testLeave() {

  }

  @Test
  public void testStatus() {

  }

}
