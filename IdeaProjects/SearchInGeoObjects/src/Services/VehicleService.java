package Services;

import Model.Vehicle;
import java.util.List;

public interface VehicleService {

    void findVehicle();

    List<Vehicle> showStopedInGeoObjects();
}
