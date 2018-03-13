package Services;

import DAO.TrackingPointDAO;
import Model.TrackingPoint;

import java.io.*;
import java.util.List;

public class FileApp {
    private BufferedWriter bw;
    private BufferedReader br;

    public void saveResultToFile(List<TrackingPoint> arrayList) throws IOException {
        if (arrayList.isEmpty()) {
            System.out.println("on " + TrackingPointDAO.tempDate + " day there is no tracking point with speed 0 km/h and x, y in searching geoObject");
        } else {
            File tempFile = new File("VehicleBase.txt");
            bw = new BufferedWriter(new FileWriter(tempFile));
            for (TrackingPoint trackingPoint : arrayList) {
                bw.write(trackingPoint.toString() + "\r\n");
            }
            bw.close();
            System.out.printf("BASE is saved successfully to file: %s\n", tempFile.getAbsolutePath());
        }
    }

    public void loadResultFromFile(List<TrackingPoint> arrayList) throws IOException {
        File tempFile = new File("VehicleBase.txt");
        br = new BufferedReader(new FileReader(tempFile));
        String line;
        while ((line = br.readLine())!=null){
            long id = Long.parseLong(line);
            int unit = Integer.parseInt(br.readLine());
            String dt = br.readLine();
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            int speed = Integer.parseInt(br.readLine());
            int event = Integer.parseInt(br.readLine());
            String location = br.readLine();
            arrayList.add(new TrackingPoint(id, unit, dt, x, y, speed, event, location));
        }
        br.close();
        System.out.println("File is load successfully!\n");
    }
}