package lostontrelokiv.installer;

import java.sql.Statement;
import java.sql.Connection;
import lostontrelokiv.userinterface.Pr;
import java.util.ArrayList;


/**
 *
 * @author jedi
 */
public class CreateTables {

    private final String nodesCreateString
            = "CREATE TABLE Nodes "
            + " (id INTEGER PRIMARY KEY, "
            + " node_id INT, "
            + " linkA INT, "
            + " linkB INT, "
            + " linkC INT, "
            + " story TEXT, "
            + " questions TEXT)";
   

/*
    private final String flagsCreatesString
            = "CREATE TABLE Flags"
            + " (id INTEGER PRIMARY KEY,"
            + " flag_id INT, "
            + " first BOOLEAN, "
            + " second BOOLEAN, "
            + " third BOOLEAN, "
            + " flag_description TEXT)";
    private final String nodesToFlagsCreateString
            = "CREATE TABLE NodesToFlags"
            + " (node_id INT,"
            + " flag_id CHAR)";
*/
    private Connection connection;
    private boolean localDebugOn = true;

    public CreateTables(Connection connection) {
        this.connection = connection;

        Pr.debug(localDebugOn, "CreateTables", nodesCreateString);

    }


    public void createTables() {
        dropExistingTables();

        create(nodesCreateString, "Nodes");
     //   create(nodesToQuestionsAndLinksCreateString, "Nodes to Questions and Links");
     //   create(questionsAndLinksCreateString, "Questions and Links");
    }


    private void dropExistingTables() {
        try {

            ArrayList<String> statementStrings = new ArrayList<>();
            statementStrings.add("DROP TABLE IF EXISTS Nodes");
       //     statementStrings.add("DROP TABLE IF EXISTS NodesToQuestionsAndLinks");
        //    statementStrings.add("DROP TABLE IF EXISTS questionsAndLinksCreateString");

            for (String statementString : statementStrings) {
                Statement s = connection.createStatement();
                s.execute(statementString);
            }
        } catch (Exception e) {
            Pr.error("CreateTables.dropExistingTable(): " + e.getMessage());
        }

        Pr.debug(localDebugOn, "dropExistigTables()", "Tables dropped");
    }


    private void create(String createString, String name) {
        try {

            Statement s = connection.createStatement();
            s.execute(createString);
            Pr.debug(localDebugOn, "create()", "Database table: " + name + " created");

        } catch (Exception e) {
            Pr.debug(localDebugOn, "create()", "CreateTables.create(): " + e.getMessage());
        }

    }


}
