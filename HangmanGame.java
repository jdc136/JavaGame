
/**
 * A program to play a game of Hangman.
 * @author Jared Collier, Allison Roldan
 * @version 1.0
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
  private int playerLives; // Max errors before user loses game
  private char[] wordToGuess; // Word that user needs to guess // converted to char[] by toCharArray() from the randomly selected word
  private char[] wordSoFar; // The word so far as it is updated by correct user guesses
  private ArrayList<String> wordList; // This is the word list used for the game
  private Random rand = new Random(); // Random
  private String incorrectLetters = ""; // List of the already guessed letters

  // Variables not yet used
  private ArrayList<String> usedWords;

  /*
   * PUBLIC METHODS These are the methods you can access in OTHER clases (i.e. our
   * HangmanGameDemo class). These call on the private methods to do what they
   * need to do.
   */

  /**
   * Creates a new HangmanGame object with a default word list.
   */
  public HangmanGame() {

    this.wordList = new WordFile().getWordArrayList();

  }

  /**
   * Creates a new HangmanGame object, based on the given list of words.
   * 
   * @param wordList The list of words that the game chooses from.
   */
  public HangmanGame(ArrayList<String> wordList) {

    this.wordList = wordList;

  }

  /**
   * A method that plays Hangman. This method plays a full game of Hangman. When
   * the game is over (win or lose), the player is prompted to play again, which
   * restarts the game.
   */
  public void playGame() {

    System.out.println("\nWelcome to Hangman!");

    char guess; // The letter guessed by a user on a given turn
    int round = 1; // Round number

    do {

      System.out.printf("Round: %d\n", round);

      this.resetGame();

      while (this.playerLives > 0) {

        if (this.countLetters() == 0 && this.playerLives > 0) {

          System.out.println("You win!");
          System.out.println("The word was: " + this.charToString(wordToGuess).replace(" ", ""));
          round++;
          break; // jump out of the while-loop since playerLives will be > 0

        }

        System.out.printf("The word so far is: %s\n", this.charToString(wordSoFar));

        guess = this.askForGuess(); // there was an issue here when I closed Scanner

        // Checks to see if the guess was already guessed
        if (this.containsLetters(guess) == false || String.copyValueOf(wordToGuess).indexOf(guess) != -1) {
          this.incorrectLetters = this.incorrectLetters + guess;
        } // could make into separate method?

        this.replaceLetters(guess); // Replaces the letter if containsLetter is true

      }

      if (this.playerLives == 0 && this.countLetters() > 0) {

        System.out.println("You're completely hung.");
        System.out.println("The word was: " + this.charToString(wordToGuess).replace(" ", ""));
        System.out.println("You lose.");
        round++;

      }

    } while (this.askToPlayAgain() == true);

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

    this.playerLives = 8;
    this.incorrectLetters = "";
    this.wordToGuess = this.pickWord().toCharArray();
    this.wordSoFar = new char[this.wordToGuess.length]; // Initialize wordSoFar to have same length as wordToGuess
    Arrays.fill(wordSoFar, '_'); // Fill wordSoFar with underscores

  }

  /**
   * This method generates a random word selected from the given array/arralist
   * @return pickedWord
   */
  private String pickWord() {

    int randomInd = rand.nextInt(this.wordList.size());
    String pickedWord = this.wordList.get(randomInd);

    return pickedWord;

  }

  /**
   * This method converts the wordSoFar char[] array to a string to print back to
   * the user
   * 
   * @param word
   * @return wordSoFarOutput
   */
  private String charToString(char[] word) {
    
    String wordSoFarOutput; // variable that is returned to PlayGame() indicating the wordSoFar

    wordSoFarOutput = new String(word).replace("", " ").trim();

    return wordSoFarOutput;

  }

  /**
   * Method returns a boolean stating whether the letterGuessed is in the
   * wordToGuess array
   * 
   * @param word
   * @return charInWord
   */
  private boolean containsLetters(char letter) {

    boolean contains = false;

    for (char c : this.wordToGuess) {
      if (c == letter) {
        contains = true;
        break;
      } 
    }

    return contains;

  }

  /**
   * Method returns the wordSoFar with updates from letterGuessed (if
   * containsLetters returns true)
   * 
   * @param word
   * @return
   */
  private char[] replaceLetters(char letter) { // Seems like this method could be broken out into a true "replace letters" method along with a user prompt method

    if (this.containsLetters(letter) == true) {

      System.out.println("Your guess is correct!");

      for (int i = 0; i < this.wordSoFar.length; i++) {
        if (this.wordToGuess[i] == letter) {
          this.wordSoFar[i] = letter;
        }
      }

    } else {
      this.playerLives--;
      System.out.printf("Sorry, the word has no '%s'. You have %d lives left.\n", letter, this.playerLives);
    }

    return this.wordSoFar;

  }

  /**
   * This method asks the player to guess again
   * 
   * @return letterGuessed
   */
  private char askForGuess() {

    String letterGuessed;
    
    System.out.print("Guess a letter: ");
    letterGuessed = this.reader();

    while (true) {
      if (letterGuessed.length() > 1) {
        System.out.print("You can only guess one letter at a time. Try again: ");
        letterGuessed = this.reader();
      } else if (letterGuessed.length() == 1 && this.incorrectLetters.contains(letterGuessed)) {
        System.out.print("You already guessed that letter. Try again: ");
        letterGuessed = this.reader();
      } else if (letterGuessed.length() == 1) {
        break;
      } 
    }
    
    return letterGuessed.charAt(0);

  }


  /**
   * This method reads in the user input
   * 
   * @return letterGuessed
   */
  private String reader() {

    Scanner in = new Scanner(System.in);
    String letterGuessed;

    letterGuessed = in.nextLine();

    return letterGuessed;

  }

  /**
   * This method counts the '_' in wordSoFar to evaluate whether the player has
   * won or not
   * 
   * @param word
   * @return lettersLeft
   */
  private int countLetters() {

    int underscores = 0;

    for (int i = 0; i < this.wordSoFar.length; i++) {
      if (this.wordSoFar[i] == '_') {
        underscores++;
      }
    }

    return underscores;

  }

  /**
   * This method displays a "you won" message and asks the player if they would
   * like to play again
   * 
   * @return playAgain
   */
  private boolean askToPlayAgain() {

    boolean playAgain = true;
    char yayNay;

    Scanner input = new Scanner(System.in);
    System.out.print("Would you like to play again? Y/N: ");
    yayNay = input.nextLine().charAt(0);

    if (yayNay == 'y' || yayNay == 'Y') {
      playAgain = true;
    } else {
      playAgain = false;
    }
    
    return playAgain;

  }

} // HangmanGame
