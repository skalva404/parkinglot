package gj.interview.parking.service;

import gj.interview.parking.Service;
import gj.interview.parking.db.ParkingSlotCarMapping;

public class ParkingLotService implements Service {

  private long size = 10;
  private ParkingSlotCarMapping slotCarTable;

  public ParkingLotService(long capacity) {
    this.size = capacity;
  }

  public ParkingSlotCarMapping parkingSlotTable() {
    return slotCarTable;
  }

  public long size() {
    return size;
  }

  @Override
  public ParkingLotService start() {
    slotCarTable = new ParkingSlotCarMapping(size).createTable();
    return this;
  }

  @Override
  public void close() throws Exception {

  }
}
