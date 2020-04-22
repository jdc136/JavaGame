/**
 * A tester for the HangmanGame program
 */

import java.util.*;

public class HangmanGameDemo {
    public static void main(String[] args) {
        
        ArrayList<String> testingWordList = new ArrayList<String>();
        testingWordList.add("computer");
        testingWordList.add("doge");
        testingWordList.add("class");

        // Test array object
        HangmanGame game = new HangmanGame(testingWordList);
        //game.playGame();

        
        // Final ArrayList Object
        HangmanGame game2 = new HangmanGame();
        game2.playGame();

    }
}
