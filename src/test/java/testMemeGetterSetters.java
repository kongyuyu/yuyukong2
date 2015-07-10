import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Yuyu Kong on 7/10/2015.
 * Comcast Interview Question 2
 */
public class testMemeGetterSetters {
    @Test(dataProvider = "passingDp")
    public void passingTestGetterSetters(String name, String text, int lulz) {
        Meme meme = new Meme();
        Assert.assertTrue(meme.setName(name));
        Assert.assertTrue(meme.setText(text));
        Assert.assertTrue(meme.setLulz(lulz));
        Assert.assertEquals(meme.getName(), name);
        Assert.assertEquals(meme.getText(), text);
        Assert.assertEquals(meme.getLulz(), lulz);
    }

    @Test(dataProvider = "failingDp")
    public void failingTestGetterSetters(String name, String text, int lulz) {
        Meme meme = new Meme();
        Assert.assertFalse(meme.setName(name));
        Assert.assertFalse(meme.setText(text));
        Assert.assertFalse(meme.setLulz(lulz));
        Assert.assertNotEquals(meme.getName(), name);
        Assert.assertNotEquals(meme.getText(), text);
        Assert.assertNotEquals(meme.getLulz(), lulz);
    }

    @DataProvider
    public Object[][] passingDp() {
        return new Object[][] {
                {"Crazy Girlfriend Praying Mantis", "It took you 15 minutes to get home! Google maps said, it should take 12. Who is she?", 1},
                {"Socially Awesome Penguin", "Called the plice to join my party.", 2},
                {"Redneck Randall", "Hey Randy is that your sister or your wife? BOTH", 5},
                {"Karate Kyle", "some text", 9},
                {"Good Guy Greg", "Goes to the bathroom, puts the toilet seat back down.", 10},
        };
    }

    @DataProvider
    public Object[][] failingDp() {
        return new Object[][] {
                {"", "", 0},
                {"", "", 11},
        };
    }
}
