package lostontrelokiv.logic;

import java.util.HashMap;
import org.apache.commons.text.TextStringBuilder;


/**
 *
 * @author jedi
 */
public class Fork {

    private int forkSwitchIntA;
    private int forkSwitchIntB;
    private int forkSwitchIntC;

    private HashMap<String, Node> forkedNodes;

    private boolean localDebugOn = false;

    public Fork() {
        forkSwitchIntA = 0;
        forkSwitchIntB = 0;
        forkSwitchIntC = 0;
        forkedNodes = new HashMap<>();
    }


    public Node switchTo(String forkSwitch) throws IllegalArgumentException {

        if (forkedNodes.containsKey(forkSwitch)) {
            return forkedNodes.get(forkSwitch);

        } else {
            throw new IllegalArgumentException("ERROR: switchTo() cannot"
                    + " switch, missing node!");
        }

    }



    /* ***************************************** *
     * METHODS FOR CREATING NEW INTEGER SWITCHES *
     * AND CONVERTING INT FORKSWITCHES TO NODES  *
     * ***************************************** *
     */
    /**
     *
     * @param forkSwitch Character 'A', 'B' or 'C'
     * @param followUpNodeId
     */
    public void addForkSwitch(Character forkSwitch, int followUpNodeId) {

        switch (forkSwitch) {
            case 'A':
                forkSwitchIntA = followUpNodeId;
                break;
            case 'B':
                forkSwitchIntB = followUpNodeId;
                break;
            case 'C':
                forkSwitchIntC = followUpNodeId;
                break;
            default:
                throw new IllegalArgumentException("FATAL ERROR: addForking() "
                        + "Tried to assign wrong switch: " + forkSwitch);
        }
    }


    public int getNodeAint() {
        if (forkSwitchIntA == 0) {
            throw new IllegalArgumentException("FATAL ERROR: getNodeAint() must"
                    + " be set for all cases");
        }
        return forkSwitchIntA;
    }


    public int getNodeBint() {
        if (forkSwitchIntA == 0) {
            throw new IllegalArgumentException("FATAL ERROR: getNodeBint() must"
                    + " be set for all cases");
        }
        return forkSwitchIntB;
    }


    public int getNodeCint() {
        if (forkSwitchIntA == 0) {
            throw new IllegalArgumentException("FATAL ERROR: getNodeCint() must"
                    + " be set for all cases");
        }
        return forkSwitchIntC;
    }


    public void setNextNode(String nodeSelection, Node node) {
        if (nodeSelection.equals("A") || nodeSelection.equals("B") || nodeSelection.equals("C")) {
            forkedNodes.put(nodeSelection, node);
        } else {
            throw new IllegalArgumentException("FATAL ERROR: setNextNode():"
                    + " Must be A, B or C. Tried to set node name: "
                    + nodeSelection);
        }
    }


    @Override
    public String toString() {

        TextStringBuilder builder = new TextStringBuilder();
        builder.append("Forks to: {");

        forkedNodes.values().stream()
                .map(n -> n.getId())
                .forEach(s -> builder.append(s).append(" "));

        builder.append("}\n");

        return builder.toString();
    }


}
