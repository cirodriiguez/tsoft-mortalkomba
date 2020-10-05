import isaac.rodriguez.PeleaRaydenScorpion;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PeleaRaydenScorpionTest {
    private static PeleaRaydenScorpion peleaRaydenScorpion;

    @BeforeClass
    public static void beforeClass(){
        peleaRaydenScorpion = new PeleaRaydenScorpion();
    }

    @Test
    public void testGanador(){
        Assert.assertEquals("String", peleaRaydenScorpion.pelea().getClass().getSimpleName());
    }

    @Test
    public void testGanadorNoVacio(){
        Assert.assertTrue(peleaRaydenScorpion.pelea().length() > 0);
    }
}


