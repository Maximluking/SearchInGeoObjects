package Services.impl;

import DAO.VehicleDAO;
import Model.Vehicle;
import Services.VehicleService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class VehicleServiceDB implements VehicleService{

    private VehicleDAO vehicleDAO;
    private BufferedReader bufferedReader;

    public VehicleServiceDB(VehicleDAO vehicleDAO, BufferedReader bufferedReader) {
        this.vehicleDAO = new VehicleDAO();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void findVehicle() {

    }

    @Override
    public List<Vehicle> showStopedInGeoObjects() {
        return null;
    }
}
