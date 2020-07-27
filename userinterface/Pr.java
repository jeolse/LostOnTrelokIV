package lostontrelokiv.userinterface;


/**
 *
 * @author jedi
 */
public class Pr {

    private static final boolean DEBUG_ON = true;
    private static final boolean ERROR_VERBOSE = true;

    public static void debug(boolean localDebugOn, String method, String debugString) {
        if (DEBUG_ON) {
            if (localDebugOn) {
                System.out.println("DEBUG: " + method + ": " + debugString + "\n");
            }
        }

    }


    public static void error(String errorString) {
        if (ERROR_VERBOSE) {
            System.out.println("ERROR: " + errorString + "\n");
        }
    }


}
