package DAO;

import Model.TrackingPoint;
import Services.DateForServices;
import Services.FileApp;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TrackingPointDAO {

    final static String UrlDB = "jdbc:sqlserver://localhost:1433";
    final static String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String DBname = "Tracker.dbo.tracking251";
    final static String userDB = "client251";
    final static String passwordDB = "250787Qaz";
    public final static String startPoint = "2017-05-03 18:00:00.000";
    public final static String endPoint = "2018-02-01 00:00:00.000";
    public static String tempDate = startPoint;

    private FileApp fileApp;
    private DateForServices dateForServices;
    private List<TrackingPoint> trackingPoints;

    public TrackingPointDAO() {
        this.fileApp = new FileApp();
        this.dateForServices = new DateForServices();
        this.trackingPoints = new ArrayList<>();

    }

    public void findResultFromDB() throws SQLException, IOException, ParseException, ClassNotFoundException {

        if (dateForServices.ifEndOfSearch(tempDate)) {

            Class.forName(DriverName);
            try (
                    Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;\" +  \n" +
                            "   \"databaseName=Tracker.dbo.tracking251;user=client251;password=250787Qaz;");
                    PreparedStatement ps = connection.prepareStatement("SELECT id, unit, dt, x, y, speed, event, location FROM Tracker.dbo.tracking251 WITH(NOLOCK) WHERE" +
                            " x between 26.279050 AND 26.281360\n" +
                            "  AND y between 50.601350 AND 50.603380 AND \n" +
                            "  speed = 0 AND dt between " + "'" + tempDate + "'" + " AND " + "'" + dateForServices.nextDay(tempDate) + "'" + " ORDER BY dt");
                    ResultSet resultSet = ps.executeQuery();) {
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

            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                try {
//                    Thread.sleep(30000); // this pause for main thread need for normal work geokoders on localhost
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                fileApp.saveResultToFile(trackingPoints);
                findResultFromDB();
            }
        } else System.out.println("Search results in DB is stoped by endDate flag");
    }
}