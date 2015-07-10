import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Yuyu Kong on 7/10/2015.
 * Comcast Interview Question 2
 */
public class testMemeCompareTo {
    @Test(dataProvider = "dp")
    public void test(Meme thisMeme, Meme compareToMeme, int result) {
        Assert.assertEquals(thisMeme.compareTo(compareToMeme), result);
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                {new Meme("1 meme", "some text"), new Meme("2 meme", "some text"), -1},
                {new Meme("1 meme", "some text"), new Meme("1 meme", "some text"), 0},
                {new Meme("2 meme", "some text"), new Meme("1 meme", "some text"), 1},
                {new Meme("a meme", "some text"), new Meme("b meme", "some text"), -1},
                {new Meme("a meme", "some text"), new Meme("a meme", "some text"), 0},
                {new Meme("b meme", "some text"), new Meme("a meme", "some text"), 1},
                {new Meme("A meme", "some text"), new Meme("B meme", "some text"), -1},
                {new Meme("A meme", "some text"), new Meme("A meme", "some text"), 0},
                {new Meme("B meme", "some text"), new Meme("A meme", "some text"), 1}
        };
    }
}
