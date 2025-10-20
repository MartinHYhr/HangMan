import java.util.*;

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
            guessed.add(letter);
            return true;
        }else {
            wrong.add(letter);
            lives--;
            return false;
        }

    }
    public String getHiddenWord(){
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()){
            if (guessed.contains(c)) sb.append(c).append(' ');
            else sb.append("_ ");
        }
        return sb.toString().trim();
    }

    public Set<Character> getWrongGuesses(){
        return wrong;
    }

    public int getLives(){
        return lives;
    }
    public boolean revealHint(){
        List<Character> hidden = new ArrayList<>();
        for (char c : word.toCharArray()){
            if (!guessed.contains(c)) hidden.add(c);
        }
        if (hidden.isEmpty()) return false;
        char reveal = hidden.get(rng.nextInt(hidden.size()));
        guessed.add(reveal);
        if (hintCostLife) lives--;
        System.out.println("Hint reveals: " + reveal);
        return true;
    }
    public String getWord(){
        return word;
    }
}
