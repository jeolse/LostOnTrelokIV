package lostontrelokiv.installer;

import lostontrelokiv.logic.Node;
import lostontrelokiv.userinterface.Pr;
import java.sql.PreparedStatement;
import java.sql.Connection;


/**
 *
 * @author jedi
 */
public class InstallNodes {

    private Connection connection;
    private boolean localDebugOn = true;

    public InstallNodes(Connection connection) {
        this.connection = connection;
    }


    public void install() {
        installFirstVersion();
        //installTester();
    }


    private void installFirstVersion() {

        StoryLine s = new StoryLine();

        addNode(1, 5, 2, Node.VOID, s.getStoryForNode(1), s.getQuestionForNode(1));
        addNode(2, 3, Node.VOID, Node.VOID, s.getStoryForNode(2), s.getQuestionForNode(2));
        addNode(3, Node.THE_END, Node.VOID, Node.VOID, s.getStoryForNode(3), s.getQuestionForNode(3));
        addNode(4, Node.THE_END, Node.VOID, Node.VOID, s.getStoryForNode(4), s.getQuestionForNode(4));
        addNode(5, 6, 7, Node.VOID, s.getStoryForNode(5), s.getQuestionForNode(5));
        addNode(6, Node.THE_END, Node.VOID, Node.VOID, s.getStoryForNode(6), s.getQuestionForNode(6));
        addNode(7, Node.THE_END, Node.VOID, Node.VOID, s.getStoryForNode(7), s.getQuestionForNode(7));
    }


    private void installTester() {

        StoryLineTester tester = new StoryLineTester();

        addNode(1, 2, 3, 4, tester.getStoryForNode(1), tester.getQuestionForNode(1));
        addNode(2, 1, 3, Node.VOID, tester.getStoryForNode(2), tester.getQuestionForNode(2));
        addNode(3, 4, Node.THE_END, Node.VOID, tester.getStoryForNode(3), tester.getQuestionForNode(3));
        addNode(4, Node.THE_END, Node.VOID, Node.VOID, tester.getStoryForNode(4), tester.getQuestionForNode(4));
    }


    public void addNode(int node_id, int A, int B, int C, String story, String questions) {
        String s = "INSERT INTO Nodes"
                + "(node_id, linkA, linkB, linkC, story, questions) VALUES (?,?,?,?,?,?)";

        Pr.debug(localDebugOn, "InstallNodes.addNode()", "SQL query:\n" + s);
        Pr.debug(localDebugOn, "InstallNodes.addNode()", " story to be installed:\n" + story);
        Pr.debug(localDebugOn, "InstallNodes.addNode()", " questions to be installed:\n" + questions);

        PreparedStatement p = null;

        try {
            p = this.connection.prepareStatement(s);
            p.setInt(1, node_id);
            p.setInt(2, A);
            p.setInt(3, B);
            p.setInt(4, C);
            p.setString(5, story);
            p.setString(6, questions);
            p.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


}
