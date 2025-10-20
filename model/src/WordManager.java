import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordManager {
    private List<Word> words;

    public WordManager(String filePath) throws Exception {
        String json = Files.readString(Path.of(filePath));
        Gson gson = new Gson();

        words = gson.fromJson(
                gson.fromJson(json, JsonObject.class).get("words"),
                new com.google.gson.reflect.TypeToken<List<Word>>(){}.getType()
        );
    }

    public Word getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void main(String[] args) throws Exception {
        WordManager wordManager = new WordManager("model/words.json");
        Word randomWord = wordManager.getRandomWord();

        System.out.println("ORD: " + randomWord.getWord());
        System.out.println("HINT: " + randomWord.getHint());
    }
}

