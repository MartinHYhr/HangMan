import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> words = loadWords("word.json");
        System.out.println("Loaded " + words.size() + " words.");

        do {
            Game game = new Game(randomWord(words), 6, true);
            play(game);
        }while (askYesNo("play again? (y/n): "));
    }
}
    private static void play(Game game){
    while (!game.isGameOver()){
        System.out.println("\nWord: " + game.getHiddenWord());
        System.out.println("wrong guesses: " + game.getWrongGuesses());
        System.out.println("Lives left: " + game.getLives());

        System.out.println("Enter a letter or '?' for hint: ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("?")){
            if (!game.revealHint())
                System.out.println("No hint available.");
            continue;
        }
        if (!input.matches("^[a-z]$")){
            System.out.println("invalid input.");
            continue;
        }
    }
    }
