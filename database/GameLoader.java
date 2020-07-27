package lostontrelokiv.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import lostontrelokiv.logic.*;
import lostontrelokiv.userinterface.Pr;


/**
 *
 * @author jedi
 */
public class GameLoader {

    private DataBaseHandler dataBaseHandler;
    private ArrayList<Node> nodes; // all nodes from the database  
    private boolean localDebugOn = false;

    public GameLoader() {
        this.dataBaseHandler = new DataBaseHandler();
        nodes = new ArrayList<>();
    }


    /* ***************************** *
     * LOAD DATA STRUCTURE TO MEMORY *
     * ***************************** */
    /**
     * @return returns the starting node of the game graph
     */
    public Node loadNodeGraph() {

        for (int i = 1; i <= numberOfNodeRows(); i++) {
            loadNodes(i);
        }

        createGraph();

        return nodes.get(0);
    }


    /**
     *
     * @param nodeId starting node id of game
     * @return game graph (starting node)
     */
    private void loadNodes(int rowIndex) {

        Connection connection = dataBaseHandler.openConnection();

        PreparedStatement p = null;
        ResultSet r = null;

        Node node = null;

        try { // tämä hakee vain yhden linkin!
            p = connection.prepareStatement(
                    "SELECT node_id, linkA, linkB, linkC, story, questions"
                    + " FROM Nodes WHERE id=?");

            p.setInt(1, rowIndex);
            r = p.executeQuery();

            if (r.next()) {
                Pr.debug(localDebugOn, "loadNodes()", "nodeId: " + r.getString("node_id"));
                Fork fork = new Fork();
                fork.addForkSwitch('A', r.getInt("linkA"));
                fork.addForkSwitch('B', r.getInt("linkB"));
                fork.addForkSwitch('C', r.getInt("linkC"));

                node = new Node(r.getInt("node_id"));
                node.setFork(fork);
                node.setStory(r.getString("story"));
                node.setQuestions(r.getString("questions"));

                nodes.add(node);

            }

        } catch (SQLException e) {
            Pr.error(e.getMessage());

        } finally {
            dataBaseHandler.closeConnection(connection, p, r);
        }

    }


    private void createGraph() {

        nodes.add(new Node(Node.THE_END));
        nodes.add(new Node(Node.VOID));

        convertIntForksToNodes();

    }


    private void convertIntForksToNodes() {

        for (Node node : nodes) {
            Fork f = node.getFork();

            if (f == null) {
                // then just continue

            } else {
                f.setNextNode("A", findNodeFor(f.getNodeAint()));
                f.setNextNode("B", findNodeFor(f.getNodeBint()));
                f.setNextNode("C", findNodeFor(f.getNodeCint()));

            }
        }
    }


    private Node findNodeFor(int forkInteger) {
        boolean found = false;

        for (Node node : nodes) {
            if (node.getId() == forkInteger) {
                found = true;
                return node;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("FATAL ERROR: findNodeFor(" + forkInteger + ")");
        }
        return null;
    }


    /**
     *
     * @return number of nodes in the database
     */
    private int numberOfNodeRows() {
        Connection connection
                = this.dataBaseHandler.openConnection();
        int nodesCount = 0;
        PreparedStatement p = null;
        ResultSet r = null;

        try {
            r = connection.prepareStatement(
                    "SELECT count(*) AS count FROM Nodes")
                    .executeQuery();

            if (r.next()) {
                nodesCount = r.getInt("count");
            }

        } catch (SQLException e) {
            Pr.error(e.getMessage());

        } finally {
            dataBaseHandler.closeConnection(connection, p, r);
        }

        return nodesCount;
    }


    /**
     * will be implemented later
     *
     * @return loaded list of flags
     *
     * public ArrayList<Flag> loadFlags() {
     *
     * Connection connection = dataBaseHandler.openConnection();
     * PreparedStatement p = null; ResultSet r = null;
     *
     * ArrayList<Flag> flags = new ArrayList<>();
     *
     * try { p = connection.prepareStatement( "SELECT flag_id, first, second,
     * third" + " FROM Flags?"); r = p.executeQuery();
     *
     * if (r.next()) { Flag newFlag = new
     * Flag(r.getString("flag_id").charAt(0));
     *
     * newFlag.setFlag( (r.getInt("first") == 1), (r.getInt("second") == 1),
     * (r.getInt("third") == 1)); }
     *
     * } catch (SQLException e) {
     * TextUserInterface.printlnError(e.getMessage());
     *
     * } finally { dataBaseHandler.closeConnection(connection, p, r); }
     *
     * return flags;
     *
     * }
     *
     */
    /**
     *      * will be implemented later
     *
     * @return hashmapped integer -> arraylist of characters
     *
     * public HashMap<Integer, ArrayList<Character>> loadNodesFlags() {
     *
     * Connection connection = dataBaseHandler.openConnection(); ResultSet r =
     * null;
     *
     * PreparedStatement p = null; HashMap<Integer, ArrayList<Character>>
     * nodesFlags = new HashMap<>();
     *
     * try { p = connection.prepareStatement("SELECT node_id, flag_id FROM
     * Flags"); r = p.executeQuery();
     *
     * if (r.next()) { int nodeId = r.getInt("node_id"); Character flag_id =
     * r.getString("flag_id").charAt(0);
     *
     * if (nodesFlags.containsKey(nodeId)) {
     * nodesFlags.get(nodeId).add(flag_id); } else { ArrayList<Character> tmp =
     * new ArrayList<>(); tmp.add(flag_id); nodesFlags.put(nodeId, tmp); }
     *
     * }
     *
     * } catch (SQLException e) {
     * TextUserInterface.printlnError(e.getMessage());
     *
     * } finally { dataBaseHandler.closeConnection(connection, p, r); }
     *
     * return nodesFlags; }
     */
}
