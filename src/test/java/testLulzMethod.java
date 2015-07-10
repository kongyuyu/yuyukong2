import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Yuyu Kong on 7/10/2015.
 * Comcast Interview Question 2
 */
public class testLulzMethod {
    @Test(invocationCount = 1000)
    public void testMethod() {
        Assert.assertTrue(betweenOneAndTen(Main.randomScore()));
    }

    private boolean betweenOneAndTen(int lulz) {
        return (1 <= lulz) && (lulz <= 10);
    }
}
