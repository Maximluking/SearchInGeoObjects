package Services;

import Model.Vehicle;
import java.io.*;
import java.util.List;

public class FileApp {
    private BufferedWriter bw;
    private BufferedReader br;

    public void saveVehicleBase(List<Vehicle> arrayList) throws IOException {
        if (arrayList.isEmpty()) {
            System.out.println("Base empty!");
        } else {
            File tempFile = new File("VehicleBase.txt");
            bw = new BufferedWriter(new FileWriter(tempFile));
            for (Vehicle vehicle : arrayList) {
                bw.write(baseConvertToFile(vehicle));
            }
            bw.close();
            System.out.printf("BASE is saved successfully to file: %s\n", tempFile.getAbsolutePath());
        }
    }

    public void loadVehicleBase(List<Vehicle> arrayList) throws IOException {
        File tempFile = new File("VehicleBase.txt");
        br = new BufferedReader(new FileReader(tempFile));
        String line;
        while ((line = br.readLine())!=null){
            int id = Integer.parseInt(line);
            int unit = Integer.parseInt(br.readLine());
            String dt = br.readLine();
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            int speed = Integer.parseInt(br.readLine());
            arrayList.add(new Vehicle(id, unit, dt, x, y, speed));
        }
        br.close();
        System.out.println("File is load successfully!\n");
    }

    private String baseConvertToFile(Vehicle vehicle){
        return vehicle.getId() + "\r\n"
                + vehicle.getUnit() + "\r\n"
                + vehicle.getDt() + "\r\n"
                + vehicle.getX() + "\r\n"
                + vehicle.getY() + "\r\n"
                + vehicle.getSpeed() + "\r\n";
    }


}