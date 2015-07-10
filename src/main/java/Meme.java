import com.sun.istack.internal.NotNull;

/**
 * Created by Yuyu Kong on 7/10/2015.
 * Comcast Interview Question 2
 */
public class Meme  implements Comparable<Meme>{
    private String name;
    private String text;
    private int lulz;

    public Meme(){
        this.name = "sample name";
        this.text = "sample text";
        this.lulz = 1;
    }

    public Meme(String name, String text){
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public String getText() {
        return text;
    }

    public boolean setText(String text) {
        if(!text.isEmpty()) {
            this.text = text;
            return true;
        } else {
            return false;
        }
    }

    public int getLulz() {
        return lulz;
    }

    public boolean setLulz(int lulz) {
        if(1 <= lulz && lulz <= 10) {
            this.lulz = lulz;
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Meme o) {
        return this.getName().compareTo(o.getName());
    }
}
