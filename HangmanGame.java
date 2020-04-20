
/**
 * A program to play a game of Hangman.
 * @author Jared Collier, Allison Roldan
 * @version 0.1
 */

import java.util.*;

public class HangmanGame {

  /*
   * CLASS VARIABLES (instance variables) These are variables that are used by any
   * given instance (object) of the Hangman class. Think of these as the variables
   * you'd want for each and every game. They are distinct from the local
   * variables you'll find in the various methods below. Additionally, these are
   * not STATIC variables as they would differ from instance to instance.
   */

  // General game play (number will vary instance to instance, so not static)
  private int playerLives = 6; // Max errors before user loses game
  private char[] wordToGuess; // Word that user needs to guess // converted to char[] by toCharArray() from
                              // the randomly selected word
  private char[] wordSoFar; // The word so far as it is updated by correct user guesses

  // Variables that Jared is NOT certain should be instance variables
  private char[] lettersGuessed; // The letters the user has guessed so far, from previous turns
  private int lettersLeft; // Counts the underscores left in wordSoFar // if = 0, and playerlives != 0,
                           // player has won
  private ArrayList<String> usedWords; // saves a copy of the words that had been used in previous rounds of a given
                                       // instance. This may be simply correlated to the "list" variable in our
                                       // WordFile class.

  /*
   * PUBLIC METHODS These are the methods you can access in OTHER clases (i.e. our
   * HangmanGameDemo class). These call on the private methods to do what they
   * need to do.
   */

  /**
   * Creates a new HangmanGame object with a default word list.
   */
  public HangmanGame() {
    // TODO: FILL ME IN!


    // I think this is all you need to do here (but my usb was having issues so it was difficult to check)
    ArrayList<String> wordList;

    WordFile words = new WordFile();

    wordList = words.getWordArrayList();
    
    // This constructor will need to fetch the list of possible words to guess from
    // a new WordFile object

  }

  /**
   * Creates a new HangmanGame object, based on the given list of words.
   * 
   * @param wordList The list of words that the game chooses from.
   */
  public HangmanGame(String[] wordList) {

    String[] wordList2;

    wordList2 = wordList;

    // This constructor will provide the list of words for all games played.
    // It should be used for testing and grading. A smaller word list will make it
    // easy to see if your program is working

  }

  /**
   * A method that plays Hangman. This method plays a full game of Hangman. When
   * the game is over (win or lose), the player is prompted to play again, which
   * restarts the game. The method returns when the player chooses not to play
   * again.
   */
  public void playGame() {
    // TODO: FILL ME IN!
    char letterGuessed; // The letter guessed by a user on a given turn
    String[] wordList;

    

    // DEBUG
    // This line merely demonstrates how to get a given list
    
    
    for (int i = 0; i < .length; i++) {
      System.out.println([i].toString());
    }

    // See pseudocode for description of algorithm here

    // do not call the method playGame() again from inside itself

  }

  /*
   * PRIVATE METHODS These are the methods that are used by the public methods
   * within HangmanGame class. You CANNOT access them inside other classes with
   * the package (which is our three classes).
   */

  /**
   * Assigns new game values to the instance variables. Utilizes local variables
   * to assist in this.
   */
  private void resetGame() {
    // TODO

    int wordFileArraySize; // Variable that keeps track of the size of the array (array.length - 1) // may
                           // need to set up a getter for this
    Random rand = new Random(); // generates random whole number in the range of the size of the wordFile array
                                // to grab an index
    int index; // Randomly generated number in the range of the word list array length
    String wordSelected; // Word selected from WordFile

    /*
     * Assigns new game values to the instance variables: Randomly select an index
     * from the WordFile list and the word at that index becomes wordToGuess by a
     * wordSelected.toCharArray() method wordSoFar variable is filled with
     * underscores '_', something like Arrays.fill() method playerLives is reset to
     * 6 lettersLeft is set to the count of underscores for the new word
     * lettersGuessed[] is emptied
     */

  }

  /**
   * This method converts the wordSoFar char[] array to a string to print back to
   * the user
   * 
   * @param word
   * @return wordSoFarOutput
   */
  private String charToString(char[] word) {
    // TODO

    String wordSoFarOutput; // variable that is returned to PlayGame() indicating the wordSoFar

    /*
     * For loop: Go through the entries in the array and add each letter to end of a
     * string (the wordSoFarOutput)
     */

    return wordSoFarOutput;

  }

  /**
   * Method returns a boolean stating whether the letterGuessed is in the
   * wordToGuess array
   * 
   * @param word
   * @return charInWord
   * 
   */
  private boolean containsLetters(char[] word) {

    boolean charInWord = false;

    /*
     * Uses a for loop to go through each char of the wordToGuess char[] and see if
     * letterGuesed character equals any of them. Uses a linear search method. There
     * may be multiple instances the letter occurs. More an issue for the method
     * below.
     */

    return charInWord;

  }

  /**
   * Method returns the wordSoFar with updates from letterGuessed (if
   * containsLetters returns true)
   * 
   * @param word
   * @return
   */
  private char[] replaceLetters(char[] word) {

    char[] wordSoFarUpdated;

    /*
     * When user correctly finds a letter, this method considers both wordToGuess
     * and wordSoFar. Replace each underscore '_' in wordSoFar with guessed letter
     * only if the letter in wordToGuess at the index of the '_' is the one you're
     * trying to replace. In other words, you'll need to consider whether there is
     * an '_' in wordSoFar to replace and if the '_' in wordToGuess is the one that
     * should be replaced.
     */

    return wordSoFarUpdated;

  }

  /**
   * This method counts the '_' in wordSoFar to evaluate whether the player has
   * won or not
   * 
   * @param word
   * @return lettersLeft
   */
  private int countLetters(char[] word) {

    int lettersLeft;

    return lettersLeft;

  }

  /**
   * This method asks the player to guess again
   */
  private void askForGuess() {

    System.out.println("Guess a letter: ");

  }

  /**
   * This method displays a "you won" message and asks the player if they would
   * like to play again
   */
  private boolean askToPlayAgain() {

    boolean playAgain = true;
    char yayNay;

    System.out.println("You won!");

    Scanner input = new Scanner(System.in);
    System.out.println("Would you like to play again? Y/N: ");
    yayNay = input.nextLine().charAt(0);

    if (yayNay == 'y' || yayNay == 'Y') {
      playAgain = true;
    } else {
      playAgain = false;
    }

    return playAgain;
  }

} // HangmanGame
