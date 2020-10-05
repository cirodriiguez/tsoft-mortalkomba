import isaac.rodriguez.PeleaRaydenScorpion;
import isaac.rodriguez.PeleaScorpionSubzero;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PeleaScorpionSubzeroTest {
    private static PeleaScorpionSubzero peleaScorpionSubzero;

    @BeforeClass
    public static void beforeClass(){
        peleaScorpionSubzero = new PeleaScorpionSubzero();
    }

    @Test
    public void testGanador(){
        Assert.assertEquals("String", peleaScorpionSubzero.pelea().getClass().getSimpleName());
    }

    @Test
    public void testGanadorNoVacio(){
        Assert.assertTrue(peleaScorpionSubzero.pelea().length() > 0);
    }
}
