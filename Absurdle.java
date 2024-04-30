import java.util.Set;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;

/**
 * Absurdle is a word guessing game where the player has to guess a word by
 * guessing the pattern of the word.
 * The player has a limited number of guesses to guess the word.
 * The game will read in a list of words from a file and randomly select a word
 * for the player to guess.
 * The player will guess the pattern of the word by guessing the correct letters
 * in the correct position.
 * The game works against the player by ensuring the patterns with the most
 * possible answers are used.
 */
public class Absurdle {
    public static final String DICTIONARY_FILE = "short-words.txt";
    public static final int MAX_GUESSES = 6;

    public static void main(String[] args) throws FileNotFoundException {
        // Read in a txt or words and store in a set
        Set<String> words = new HashSet<>();
        // read from DICTIONARY_FILE
        Scanner scanner = new Scanner(new File("./" + DICTIONARY_FILE));
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        // start the game, print intro
        intro();

        int guesses = MAX_GUESSES;
        String patternsSoFar = "⬜";
        Scanner input = new Scanner(System.in);
        while (!gameOver(guesses, patternsSoFar)) {
            System.out.println("You have " + guesses + " guesses left.");
            // get user input
            System.out.println("Enter your guess: ");
            String guess = input.next();
            try {
                String pattern = makeMove(guess, words);
                patternsSoFar += pattern + "\n";
                System.out.println(pattern);
            } catch (IllegalArgumentException e) {
                System.out.println("Word must be five characters long, try again.");
                continue;
            }
            guesses--;
        }

        if (patternsSoFar.contains("⬜") || patternsSoFar.contains("🟨")) {
            System.out.println("You lose! The word was " + words.iterator().next());
        } else {
            System.out.println("Correct answer, You win!");
        }

        input.close();
    }

    // 🟩 ⬜ 🟨
    // Given a guess and a set of words, return the pattern of the word
    // @param String guess representing the user's guess on this turn
    // @param Set<String> words representing the set of words to guess from
    // @except IllegalArgumentException if the guess is too long or too short
    // @return String pattern representing the correctness of the word
    public static String makeMove(String guess, Set<String> words) {
        // YOUR CODE HERE
        return "⬜⬜⬜⬜⬜";
    }

    public static String patternFor(String word, String guess) {
        // YOUR CODE HERE
        return "⬜⬜⬜⬜⬜";
    }

    public static void intro() {
        System.out.println("Welcome to Absurdle!");
        System.out.println("The game where you guess the word by guessing the pattern of the word.");
        System.out.println("You have" + MAX_GUESSES + " guesses to guess the word.");
        System.out.println("Good luck!");
    }

    public static boolean gameOver(int guesses, String pattern) {
        return guesses == 0 || !(pattern.contains("⬜") || pattern.contains("🟨"));
    }
}