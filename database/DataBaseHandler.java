package lostontrelokiv.database;

//  'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.*;

import lostontrelokiv.userinterface.Pr;

public class DataBaseHandler {

    private String dbPathString;
    private Connection connection; // the database connection handle to be passed
    private boolean localDebugOn = false;

    public DataBaseHandler() {
        this.dbPathString = DataBasePath.DATABASE_PATH;
    }

    /*
     * ***************************** * OPEN / CLOSE DATABASE METHODS *
     * *****************************
     */
    public Connection openConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPathString);
            Pr.debug(localDebugOn, "openConnection()", "Connection to SQLite has been established.");

        } catch (SQLException e) {
            Pr.error(e.getMessage());
        }

        return connection;
    }

    public void closeConnection(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            Pr.error(e.getMessage());
        } finally {
            DbUtils.closeQuietly(connection, stmt, rs);
        }
        Pr.debug(localDebugOn, "closeConnection():", "Connection to SQLite has been closed.");
    }

    private void close(Statement stmt, ResultSet rs) {
        closeConnection(connection, stmt, rs);
    }

    /*
     * ***************************** * PRINT DATABASE TABLES METHODS *
     * *****************************
     */
    public void printAllTables() {
        openConnection();

        Statement s = null;
        ResultSet r = null;

        try {
            s = connection.createStatement();

            System.out.println("Nodes\n=====");
            r = s.executeQuery("SELECT * FROM Nodes");

            while (r.next()) {
                System.out.println(r.getInt("node_id") + "\n" + r.getString("story") + "\n\n");
            }

            System.out.println("Flags\n======");
            r = s.executeQuery("SELECT * FROM Flags");

            while (r.next()) {
                System.out.println(r.getInt("flag_id") + "\tFirst:  " + (r.getInt("first") == 1) + "\tSecond: "
                        + (r.getInt("second") == 1) + "\tThird:  " + (r.getInt("third") == 1));
            }

            System.out.println("\nNodesToFlags\n============");
            r = s.executeQuery("SELECT * FROM NodesToFlags");

            while (r.next()) {
                System.out.println(r.getInt("node_id") + " | " + r.getString("flag_id").charAt(0));
            }

            close(s, r);

        } catch (Exception e) {
            Pr.error(e.getMessage());

        } finally {
            close(s, r);
        }
    }

}
