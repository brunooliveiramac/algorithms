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

    @Test
    public void whenInputIs5ShouldConvertToRomanV(){
        Assert.assertEquals("V", RomanNumerals.convert(5));
    }

    @Test
    public void whenInputIs6ShouldConvertToRomanVI(){
        Assert.assertEquals("VI", RomanNumerals.convert(6));
    }

    @Test
    public void whenInputIs7ShouldConvertToRomanVII(){
        Assert.assertEquals("VII", RomanNumerals.convert(7));
    }


    @Test
    public void whenInputIs4ShouldConvertToRomanIV(){
        Assert.assertEquals("IV", RomanNumerals.convert(4));
    }


}
