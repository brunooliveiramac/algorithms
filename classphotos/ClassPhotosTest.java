import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ClassPhotosTest {

    @Test
    public void simpleTest(){

        List<Integer> blueShirtHeights = Arrays.asList(2, 4, 7, 5, 1, 6);
        List<Integer> redShirtHeights = Arrays.asList(3, 5, 6, 8, 2, 1);

        boolean result = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);

        Assert.assertFalse(result);

    }


}
