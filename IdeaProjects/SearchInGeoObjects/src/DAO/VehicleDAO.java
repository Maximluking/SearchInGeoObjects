package DAO;

import Model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    private Connection connection;

    public VehicleDAO() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://212.109.44.46:1433\\\\SQLEXPRESS;databaseName=Tracker", "client251", "250787Qaz");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Vehicle> showStopedInGeoObjects() {
        try (PreparedStatement ps = connection.prepareStatement("SELECT id, unit, dt, x, y, speed FROM Tracker.dbo.tracking25 WHERE \n" +
                "   x between 26.279050 AND 26.281360\n" +
                "  AND y between 50.601350 AND 50.603380 AND \n" +
                "   speed = 0 AND dt between '2017-01-01 00:00:00.000' AND '2017-01-01 00:00:00.000' ORDER BY dt;")) {
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