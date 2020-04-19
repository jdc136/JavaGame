# Pseudocode for Java Hangman Game

do {

    Beginning of Game (may make into separate method):
    1. Display the word so far (variable: wordSoFar) to user (method: charToString). The word so far will just be underscores.
    2. Prompt user for a guess (method: askForGuess).
    3. Read in user guess (variable: letterGuessed) using scanner with nextLine(), then convert to char using charAt() (index 0).
    
    Middle of Game
    4. Check whether the word-to-guess (variable: wordToGuess) has the character guessed by the user (method: containsLetters).
        a. If containsLetters returns false, let the user know, then prompt the user for a guess (methods: charToString, askForGuess), steps 3-5. The player also loses a life (variable: playerLives--).
        b. If containsLetters returns true, continue to the next step.
    5. containsLetters method could return 'true' for two reasons:
        a. The guessed-letter is a letter that is in the word-to-guess, but the user already guessed it before.
            i. If this is the case, let the user know, then start over again (methods: charToString, askForGuess), steps 3-5.
        b. The guessed-letter is a letter that is in the word-to-guess, and the user has NOT already guessed it.
            i. If this is the case, then do the following:
                I. Replace each '_' in the word-so-far with guessed-letter from user ONLY where the letter in the word-to-guess is at the
                   SAME index of the '_' from the word-so-far that you are trying to replace (method: replace).
                II. Up to this point, the game has had two opportunities to stop prematurely: because a) containsLetters returned false OR b) it returned true but it was a letter that had ALREADY been guessed. At this point, however, the user has successfully guessed a letter and the game proceeds to the next step.
    6. Round is over and the preliminary checks start, steps 1-2. At those points, the end of the game will be determined.

    Checks
    7. Check whether the player has any lives left (variable: playerLives).
        a. If playerLives = 0, then the user is informed they lost and asked to play again (method: askToPlay).
        b. If playerLives > 0, then the program continues on to the next step.
    8. Check whether the word-so-far (variable: wordSoFar) has any underscores left (method: countLetters).
        a. If countLetters = 0, then the user is informed they won and asked to play again (method: askToPlay).
        b. If countLetters is > 0, then the program continues on to the next step.

} while (playAgain == true)

Notes:
- Check whether they are out of lives or if they have guessed all the letters - then they win
- Ask the user to play again once the game loop is finished this allows the PlayGame method to repeat multiple times