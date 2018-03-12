package DAO;

import Model.TrackingPoint;
import Services.DateForServices;
import Services.FileApp;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackingPointDAO {

    final static String UrlDB = "jdbc:sqlserver://localhost:1433";
    final static String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String DBname = "Tracker.dbo.tracking251";
    final static String userDB = "client251";
    final static String passwordDB = "250787Qaz";
    public final static String startPoint = "2017-01-01 00:00:00.000";
    public final static String endPoint = "2018-02-01 00:00:00.000";
    public static String tempDate = "" + startPoint;
    ;


    private Connection connection;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private FileApp fileApp;
    private DateForServices dateForServices;
    private List<TrackingPoint> trackingPoints;

    public TrackingPointDAO() {
        this.connection = connection;
        this.ps = ps;
        this.resultSet = resultSet;
        this.fileApp = fileApp;
        this.dateForServices = dateForServices;
        this.trackingPoints = new ArrayList<>();

    }

    public void showResultFromDB() throws SQLException, IOException {

        try {

            Class.forName(DriverName);
            Connection connection = DriverManager.getConnection(UrlDB + ";databaseName=" + DBname + ";user=" + userDB + ";password=" + passwordDB + ";");
            PreparedStatement ps = connection.prepareStatement("SELECT id, unit, dt, x, y, speed, event, lcation FROM Tracker.dbo.tracking251 WHERE x between 26.279050 AND 26.281360\n" +
                    "  AND y between 50.601350 AND 50.603380 AND \n" +
                    "   speed = 0 AND dt between " + "'" + tempDate + "'" + " AND " + "'" + dateForServices.nextDay(tempDate) + "'" + " ORDER BY dt");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                int unit = resultSet.getInt("unit");
                String dt = resultSet.getString("dt");
                float x = resultSet.getFloat("x");
                float y = resultSet.getFloat("y");
                int speed = resultSet.getInt("speed");
                int event = resultSet.getInt("event");
                String location = resultSet.getString("location");
                trackingPoints.add(new TrackingPoint(id, unit, dt, x, y, speed, event, location));
            }
            for (TrackingPoint trackingPoint : trackingPoints) {
                System.out.println(trackingPoint.toString());
            }
            ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            resultSet.close();
            connection.close();
            fileApp.saveResultToFile(trackingPoints);
            showResultFromDB();
        }
    }
}