import DAO.TrackingPointDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, ParseException {
        TrackingPointDAO trackingPointDAO = new TrackingPointDAO();
        try {
            trackingPointDAO.findResultFromDB();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
