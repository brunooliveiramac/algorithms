import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void shouldConvertToRoman(){
        Assert.assertEquals(RomanNumerals.convert(1), "I");
    }


}
