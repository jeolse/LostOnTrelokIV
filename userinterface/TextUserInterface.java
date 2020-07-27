package lostontrelokiv.userinterface;

import java.util.Scanner;
import lostontrelokiv.logic.NodeHandler;
import org.apache.commons.text.WordUtils;


/**
 *
 * @author jedi
 */
public class TextUserInterface {

    private Scanner reader;
    private final int OUTPUT_WIDTH = 75;
    private boolean localDebugOn = true;

    public TextUserInterface(Scanner reader) {
        this.reader = reader;
    }


    public void run() {

        NodeHandler game = new NodeHandler();
        game.startGame();

        while (game.isOn()) {
            Pr.debug(localDebugOn, "UI.run()", "game is on");

            System.out.println(WordUtils.wrap(game.getStory(), OUTPUT_WIDTH));

            while (true) {
                System.out.println(WordUtils.wrap(game.getQuestions(), OUTPUT_WIDTH));

                if (game.proceed(reader.nextLine().toUpperCase())) {
                    Pr.debug(localDebugOn, "UI.run()", "correct input, proceeding");
                    break; // to outer while loop
                } else {
                    Pr.debug(localDebugOn, "UI.run()", "wrong input, try again");
                    continue; // showing this while loop
                }
            }
            System.out.println("");

        } // game over
    }


}
