package lostontrelokiv.logic;

import lostontrelokiv.database.*;
import lostontrelokiv.userinterface.Pr;


/**
 *
 * @author jedi
 */
public class NodeHandler {

    private Node currentNode;
    // private ArrayList<Flag> flags;
    // private HashMap<Integer, ArrayList<Character>> nodesToFlags;
    private boolean localDebugOn = true;

    public NodeHandler() {
        currentNode = null;
        //  flags = new ArrayList<>();
        //  nodesToFlags = new HashMap<>();
    }


    public void startGame() {
        GameLoader gameLoader = new GameLoader();
        currentNode = gameLoader.loadNodeGraph();

        // flags and nodes to flags to be implemented later
        // flags = gameLoader.loadFlags(); 
        // nodesToFlags = gameLoader.loadNodesFlags();
        // parseFlagsToNodes();
    }


    public String getStory() {
        return currentNode.getStory();
    }


    public String getQuestions() {
        return currentNode.getQuestions();
    }


    public boolean isOn() {
        return (!currentNode.isTheEnd());
    }


    public boolean proceed(String switchToLetter) {
        Pr.debug(localDebugOn, "NodeHandler.proceed()", "current node is " + currentNode.getId());

        if (currentNode.nextWillBeTheEnd()) {
            Pr.debug(localDebugOn, "NodeHandler.proceed()",
                    "Next will be the end. Any letter OK!"
                    + " I set the letter to \"A\"");
            switchToLetter = "A";
        }

        if (switchToLetter.equals("A")
                || switchToLetter.equals("B")
                || switchToLetter.equals("C")) {

            Pr.debug(localDebugOn, "NodeHandler.proceed()",
                    "Switching with letter " + switchToLetter);

            if (currentNode.traversesToVoid(switchToLetter)) {
                Pr.debug(localDebugOn, "NodeHandler.proceed()",
                        "Selection traverses to void! Cannot proceed, do another"
                        + " selection ");
                return false;
            }
            
            Node nextNode = null;

            try {
                nextNode = currentNode.traverseTo(switchToLetter);

            } catch (IllegalArgumentException exception) {
                Pr.error(exception.toString());
                return false; // fork didn't have suggested switchToLetter, shouldn't happen

            }

            currentNode = nextNode;
            Pr.debug(localDebugOn, "NodeHandler.proceed()",
                    "Switching to node: " + currentNode.getId());

            return true;
        }
        return false;

    }


}

/*
    private void parseFlagsToNodes() {
        TextUserInterface.printlnDebug("NodeHandler: parsing Flags to Nodes");
        // combine flags to nodes
    }
 */
/**
 *
 * @param node current node to be printed
 * @param visited all visited nodes
 *
 * public void printNodeGraph(Node node, ArrayList<Node> visited) {
 *
 * if (visited.contains(node)) { // been there - done that return; }
 *
 * if (node.isDeadEnd()) { //nothing to see here visited.add(node); return; }
 *
 * if (node.isEnderNode()) { // edge of graph visited.add(node);
 * TextUserInterface.printlnDebug("NodeHandler.printGraph():" +
 * node.toString()); return; }
 *
 * TextUserInterface.printlnDebug("NodeHandler.printGraph():" +
 * node.toString());
 *
 * printNodeGraph(node.getFork().getNextNode("A"), visited);
 * printNodeGraph(node.getFork().getNextNode("B"), visited);
 * printNodeGraph(node.getFork().getNextNode("C"), visited);
 *
 * visited.add(node); }
 */
