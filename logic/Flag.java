package lostontrelokiv.logic;

import java.util.ArrayList;


/**
 *
 * @author jedi
 */
public class Flag  {

    private char id;
    private ArrayList<Boolean> state;
    private ArrayList<Node> nodes;
    

    public Flag(char id) {
        state = new ArrayList<>(3); // max options for a state is now 3
    }


    public ArrayList<Boolean> getState() {
        return state;
    }


    public void setFlag(boolean state1, boolean state2, boolean state3) {
        this.state.add(state1);
        this.state.add(state2);
        this.state.add(state3);
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        final Flag other = (Flag) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


}
