package Services;

import Model.TrackingPoint;

import java.sql.SQLException;
import java.util.List;

public interface VehicleService {

    void findVehicle();

    List<TrackingPoint> showStopedInGeoObjects() throws SQLException;
}
