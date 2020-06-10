package OOPDesign.ParkingSructure;

import java.util.Date;
import java.util.Map;

enum ParkingStatus {
    ACTIVE, PAID;
}

public class ParkingTicket {
    Date issuedAt;
    int id;
    ParkingStatus parkingStatus;
    Map<Integer, Double> rateMap;
}
