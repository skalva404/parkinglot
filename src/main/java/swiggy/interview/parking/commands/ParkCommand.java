package swiggy.interview.parking.commands;

import swiggy.interview.parking.ErrorConstants;
import swiggy.interview.parking.ParkingError;
import swiggy.interview.parking.model.Car;
import swiggy.interview.parking.model.ParkingSlot;

import java.util.List;

public class ParkCommand extends AbstractCommand<ParkingSlot> {

    private Car car;
    private ParkingSlot parkingSlot;

    public ParkCommand(List<String> args) throws ParkingError {
        if (null == args || 2 != args.size()) {
            throw new ParkingError(ErrorConstants.INVALID_ARGS.message());
        }

        try {
            this.car = new Car(args.get(0), args.get(1));
        } catch (Exception e) {
            throw new ParkingError(ErrorConstants.INVALID_ARGS.message());
        }
    }

    @Override
    public void execute() throws ParkingError {
        if (null != parkingSlot) {
            return;
        }
        synchronized (parkingSlotEntity()) {
            parkingSlot = parkingSlotEntity().park(car);
        }
    }

    @Override
    public String format() {
        if (null == this.parkingSlot) {
            return ErrorConstants.DATA_NOT_FOUND.message();
        }
        return String.format(CommandConstants.PARK.message(), parkingSlot.id());
    }

    @Override
    public ParkingSlot result() {
        return parkingSlot;
    }
}
