package DAO;

import Model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    private Connection connection;

    public VehicleDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;\" +  \n" +
                    "   \"databaseName=Tracker.dbo.tracking251;user=client251;password=250787Qaz;");
            Statement statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Vehicle> showStopedInGeoObjects() {
        try (PreparedStatement ps = connection.prepareStatement("SELECT id, unit, dt, x, y, speed FROM Tracker.dbo.tracking251 WHERE \n" +

                "   unit = 251273 and dt between '2017-01-01 00:00:00.000' AND '2017-01-02 00:00:00.000' ORDER BY dt;")) {
            ResultSet resultSet = ps.executeQuery();
            List<Vehicle> vehicles = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int unit = resultSet.getInt("unit");
                String dt = resultSet.getString("dt");
                float x = resultSet.getFloat("x");
                float y = resultSet.getFloat("y");
                int speed = resultSet.getInt("speed");
                vehicles.add(new Vehicle(id, unit, dt, x, y, speed));
            }
            return vehicles;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void findVehicle() {
    }
}