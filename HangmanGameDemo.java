/**
 * A tester for the HangmanGame program
 */
public class HangmanGameDemo {
    public static void main(String[] args) {
        String[] testingWordList = { "class", "doge", "computer" };

        HangmanGame game = new HangmanGame(testingWordList);

        game.playGame();

    }
}
