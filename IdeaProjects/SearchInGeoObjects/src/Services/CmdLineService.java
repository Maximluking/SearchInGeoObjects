package Services;

import Model.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineService {

    private final BufferedReader reader;
    private final VehicleService vehicleService;

    public CmdLineService(VehicleService vehicleService) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.vehicleService = vehicleService;
    }

    private static void showMainMenu(){
        System.out.println("1. Vehicles");
        System.out.println("0. Exit");
    }

    private static void showVehiclesMenu(){
        System.out.println("1. Show all vehicles");
        System.out.println("2. Find vehicle");
        System.out.println("0. Go back");
    }

    public void mainMenu() throws IOException {
        boolean isWork = true;
        do {
            showMainMenu();
            String s = reader.readLine();
            switch (s){
                case "1":
                    VehicleMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }
        while (isWork);
    }

    private void VehicleMenu() throws IOException {
        boolean isWork = true;
        do {
            showVehiclesMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    for (Vehicle vehicle : vehicleService.showStopedInGeoObjects()) {
                        System.out.println(vehicle);
                    }
                    System.out.println();
                    break;
                case "2":
                    vehicleService.findVehicle();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }
        while (isWork);
    }
}