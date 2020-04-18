/**
 * A program to play a game of Hangman.
 */

import java.util.*;

public class HangmanGame {

    // Instance variables
    private int numberOfLives = 6;
    private String wordSelected;
    private char[] wordToGuess = wordSelected.toCharArray(); // An array to hold the letters of wordToGuess variable
    private char letterGuessed;
    private char[] lettersGuessed;
    private char[] wordSoFar = wordSelected.toCharArray();
        //Arrays.fill(wordSoFar, '_'); // do something like this

    private int lettersLeft; // counts the underscores in the word so far // if = 0 then player has won the game


    

    /**
     * Break out the letters of the select word and put into the array wordLetters ?
     */


     



    /**
     * Creates a new HangmanGame object with a default word list.
     */
    public HangmanGame() {
        // TODO: FILL ME IN!


    }

    /**
     * Creates a new HangmanGame object, based on the given list of words.
     * 
     * @param wordList The list of words that the game chooses from.
     */
    public HangmanGame(String[] wordList) {
        // TODO: FILL ME IN!
    }

    /**
     * A method that plays Hangman. This method plays a full game of Hangman. When
     * the game is over (win or lose), the player is prompted to play again, which
     * restarts the game. The method returns when the player chooses not to play
     * again.
     */
    public void playGame() {
        // TODO: FILL ME IN!

        /* Need a loop that shows the user the word so far and then prompts them for a guess
        // a do while loop?

        // first read their guess using Scanner with nextLine()
        // Convert their response into a character by using the charAt() to get the first character

        // Second, check if the guessed letter is in the word-to-guess
        // If so, replace that letter in the word-so-far
        // If not, tell user they got a letter wrong and lose a life

        // Third check whether theya re out of lives or if they have
        // guessed all the letters - then they win

        // Ask the user to play again once the game loop is finished
        // this allows the PlayGame method to repeat multiple times

        */ // end of loop

        

        // do not call the method playGame() again from inside itself


    }

    private void resetGame() {
        // TODO

        // pick a random word from the list by selecting a random index from the Array created from the word file

        // Reset wordSoFar, lettersGuessed, numberOfLives
    }


    /**
     * 
     * @param word
     * @return a string of the char[] array
     */
      private String charToString (char[] word) {
        String wordSoFarOutput; 
        
        // TODO: figure out a way to get the characters from wordSoFar into this variable (probably a for loop)

        return wordSoFarOutput;

      }

      /**
       * 
       * @param word
       * @return 
       * This method could return both a) the fact that the letter is there (or not) as well as
       * b) the index of that letter in the char[] array
       * e.g. private int charSearch (char[] word) {a) look for the characters b) return the index(es) of that letter}
       */
      private boolean charSearch (char[] word) {
        boolean charInWord;
        
        // Use a for loop to go through each char of the char[] and see if that character equals
        // the letterGuessed variable
        // there may be multiple times the letter occurs and you want to keep track of all of those instances
        
        // potentially we'll also want to keep track of the indexes of those characters in this method too

      }

      private char[] replaceChar (char[] word) {
        
        //wordSoFar = something or the other

        // Note that you can do this with a single loop, but you'll need to consider both the word-so-far 
        // (to see if there is an '_' to replace) and the word-to-guess (to see if the '_' is one that should be replaced).

        return wordSoFar;

      }


} // HangmanGame
