import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Yuyu Kong on 7/10/2015.
 * Comcast Interview Question 2
 */
public class Main {
    public static void main(String[] args) {
        //read the json file into a string. Then use gson to deserialize it into memes, an arraylist of meme.
        String memeJson = new Scanner(Main.class.getResourceAsStream("internetMemes.json")).useDelimiter("\\Z").next();
        List<Meme> memes = new Gson().fromJson(memeJson, new TypeToken<ArrayList<Meme>>() {}.getType());

        //show memes
        System.out.println("Unsorted Memes: ");
        for(Meme meme : memes) {
            System.out.println(meme.getName() + ": " + meme.getText() + ": " + meme.getLulz());
        }

        //sort memes with comparable and show them. Comparable implemented in class Meme.
        Collections.sort(memes);
        System.out.println("\nSorted Memes: ");
        for(Meme meme : memes) {
            System.out.println(meme.getName() + ": " + meme.getText() + ": " + meme.getLulz());
        }

        //assign random score to memes and show them
        for(Meme meme : memes) {
            meme.setLulz(randomScore());
        }
        System.out.println("\nSorted Memes with lulz score: ");
        for(Meme meme : memes) {
            System.out.println(meme.getName() + ": " + meme.getText() + ": " + meme.getLulz());
        }

        //use GsonBuilder to serialize memes into readable json string
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        memeJson = prettyGson.toJson(memes);

        //print memeJson back into the original file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("src/main/resources/internetMemes.json");
            writer.println(memeJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    //return a random int between [1 - 10]
    public static int randomScore() {
        return (int)(Math.random() * 10 + 1);                           //1 - 10.99, but (int) would round it down to 1 - 10
    }
}
