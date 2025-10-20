import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {

    private final String word;
    private final Set<Character> guessed = new HashSet<>();
    private final Set<Character> wrong = new HashSet<>();
    private int lives;
    private final boolean hintCostLife;
    private final Random rng = new Random();

    public Game (String word, int lives, boolean hintCostLife){

        this.word = word;
        this.lives = lives;
        this.hintCostLife = hintCostLife;

    }

    public boolean hasWon(){
        for (char c : word.toCharArray()){
            if (!guessed.contains(c)) return false;
        }
        return true;

    }

    public boolean hasLost(){
        return lives <= 0;
    }
    public boolean isGameOver(){
        return hasWon() || hasLost();
    }
    public boolean guess(char letter){
        letter = Character.toLowerCase(letter);
        if(word.indexOf(letter) >= 0){

        }

    }




}
