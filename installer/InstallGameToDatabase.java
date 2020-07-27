package lostontrelokiv.installer;

import java.sql.Connection;
import lostontrelokiv.database.DataBaseHandler;



public class InstallGameToDatabase {

  
    public static void main(String[] args) {
        installGameSQLLiteDatabase();
    }


    /* ********************************************* *
     * INSTALL GAME DATABASE ONLY FOR THE FIRST TIME *
     * ********************************************* */
    public static void installGameSQLLiteDatabase() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        Connection connection = dataBaseHandler.openConnection();

        new CreateTables(connection).createTables();

        new InstallNodes(connection).install();
        

        //new InstallFlags(connection).install();
        //   new InstallNodesToFlags(connection).install();

        dataBaseHandler.closeConnection(connection, null, null);
        dataBaseHandler.printAllTables();
    }


}
