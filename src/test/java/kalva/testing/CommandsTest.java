package kalva.testing;

import kalva.parking.ParkingError;
import kalva.parking.commands.CreateCommand;
import kalva.parking.commands.ParkCommand;
import kalva.parking.model.Car;
import kalva.parking.service.ParkingLotService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommandsTest {

  private ParkingLotService parkingLotService;

  @BeforeMethod
  public void setUp() throws Exception {
    CreateCommand command = new CreateCommand();
    parkingLotService = command.runCommand(5l);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    parkingLotService = null;
  }

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
      ParkingLotService parkingLotService = command.runCommand(2l);
      Assert.assertNotNull(parkingLotService);
      Assert.assertEquals(parkingLotService.size(), 2l);
    } catch (Exception iae) {
      exception = iae;
    }
    Assert.assertNull(exception);
  }

  @Test
  public void testPark() throws ParkingError {

    ParkCommand parkCommand = new ParkCommand();
    parkCommand.setParkingSlots(parkingLotService.parkingSlots());
    for (int i = 1; i <= 5; i++) {
      parkCommand.runCommand(new Car(String.valueOf(i), String.valueOf(i)));
    }
    Assert.assertEquals(parkingLotService.freeSlots().size(), 0);
    Assert.assertEquals(parkingLotService.occupiedSlots().size(), 5);
    Assert.assertEquals(parkingLotService.totalSlots().size(), 5);

    Exception exception = null;
    try {
      parkCommand.runCommand(new Car(String.valueOf(6), String.valueOf(6)));
    } catch (Exception e) {
      exception = e;
    }
    Assert.assertNotNull(exception);
  }

  @Test
  public void testLeave() {

  }

  @Test
  public void testStatus() {

  }
}
