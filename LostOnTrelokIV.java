/**
 * Main for Java
 * 
 */

package lostontrelokiv;

import java.util.Scanner;
import lostontrelokiv.userinterface.TextUserInterface;

public class LostOnTrelokIV {

    public static void main(String[] args) {
        new TextUserInterface(new Scanner(System.in)).run();
    }


}
