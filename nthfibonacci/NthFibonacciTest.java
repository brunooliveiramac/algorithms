import org.junit.Assert;
import org.junit.Test;

public class NthFibonacciTest {


    @Test
    public void NonCachedFib(){

        int nthFib = NthFibonacci.getNthFib(6);

        Assert.assertEquals(5, nthFib);

    }

    @Test
    public void CachedFib(){

        int nthFib = NthFibonacci.getNthFibWithCache(6);

        Assert.assertEquals(5, nthFib);

    }



}
