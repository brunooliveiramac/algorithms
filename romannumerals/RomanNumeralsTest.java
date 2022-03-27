import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void whenInputIs1ShouldConvertToRomanI(){
        Assert.assertEquals(RomanNumerals.convert(1), "I");
    }

    @Test
    public void whenInputIs2ShouldConvertToRomanII(){
        Assert.assertEquals(RomanNumerals.convert(2), "II");
    }

    @Test
    public void whenInputIs3ShouldConvertToRomanIII(){
        Assert.assertEquals(RomanNumerals.convert(3), "III");
    }


}
