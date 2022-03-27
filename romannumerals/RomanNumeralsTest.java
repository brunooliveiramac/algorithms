import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void whenInputIs1ShouldConvertToRomanI(){
        Assert.assertEquals("I", RomanNumerals.convert(1));
    }

    @Test
    public void whenInputIs2ShouldConvertToRomanII(){
        Assert.assertEquals("II", RomanNumerals.convert(2));
    }

    @Test
    public void whenInputIs3ShouldConvertToRomanIII(){
        Assert.assertEquals("III", RomanNumerals.convert(3));
    }


}
