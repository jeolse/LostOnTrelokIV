package lostontrelokiv.logic;

import lostontrelokiv.userinterface.Pr;
import java.util.ArrayList;


/**
 * @author jedi
 */
public class Node implements Comparable<Node> {

    private int id;
    private boolean isTheEnd;
    private boolean isVoid;

    private Fork fork;

    private String story;
    private String storyQuestion;
    private ArrayList<String> questions;

    public static final int THE_END = 10000;
    public static final int VOID = 20000;

    private boolean localDebugOn = false;

    public Node(int nodeId) {
        this.id = nodeId;

        isTheEnd = (nodeId == THE_END);
        isVoid = (nodeId == VOID);

        fork = null;
        story = "";
        storyQuestion = "";
        questions = new ArrayList<>();
    }


    public void setFork(Fork fork) {
        if (id == THE_END) {
            Fork f = new Fork();
            f.setNextNode("A", new Node(THE_END));
            f.setNextNode("B", new Node(THE_END));
            f.setNextNode("C", new Node(THE_END));

        } else if (id == VOID) {
            Fork f = new Fork();
            f.setNextNode("A", new Node(VOID));
            f.setNextNode("B", new Node(VOID));
            f.setNextNode("C", new Node(VOID));
        }

        this.fork = fork;
    }


    public void setStory(String story) {
        if (isTheEnd) {
            this.story = "It is the end.";

        } else if (isVoid) {
            this.story = "";

        } else {
            this.story = story;
        }
    }


    public void setQuestions(String questionsString) {
        if (isTheEnd || isVoid) {
            storyQuestion = "Enter to quit";

        } else {
            storyQuestion = questionsString;
        }
    }


    /*
    public void setFlag(Flag flag) {
        this.flag.add(flag);
    }
     */
    public int getId() {
        return id;
    }


    public Fork getFork() {
        return fork;
    }


    public String getStory() {
        return story;
    }


    public String getQuestions() {
        return this.storyQuestion;
    }


    public boolean isTheEnd() {
        return isTheEnd;
    }


    public boolean isVoid() {
        return isVoid;
    }


    public boolean nextWillBeTheEnd() {
        return fork.switchTo("A").isTheEnd();
    }


    public boolean traversesToVoid(String switchStringLetter) {
        if (fork.switchTo(switchStringLetter).isVoid()) {
            return true;

        } else {
            return false;
        }

    }


    /*
    public ArrayList<Flag> getFlags() {
        return flag;
    }
     */
    public Node traverseTo(String switchStringLetter) throws IllegalArgumentException {
        return fork.switchTo(switchStringLetter);
    }


    @Override
    public int compareTo(Node compareNode) {
        return this.id - compareNode.getId(); // also for ender nodes
    }


    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Node: id: ");

        switch (id) {
            case THE_END:
                returnString.append("THE_END");
                break;
            default:
                returnString.append(this.id);
                break;
        }

        returnString.append("\n");

        if (fork == null) {
            // append nothing
        } else {
            returnString.append(fork.toString());
        }

        returnString.append("\nStory:\n");
        int maxLength = ((story.length() < 40) ? story.length() - 1 : 40);
        returnString.append(story.subSequence(0, maxLength).toString());
        returnString.append("\n");

        returnString.append("\nQuestion:\n");
        maxLength = ((storyQuestion.length() < 40) ? storyQuestion.length() - 1 : 40);
        returnString.append(storyQuestion.subSequence(0, maxLength).toString());
        returnString.append("\n");

        return returnString.toString();

    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }


}
