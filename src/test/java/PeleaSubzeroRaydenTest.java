import isaac.rodriguez.PeleaRaydenScorpion;
import isaac.rodriguez.PeleaSubzeroRayden;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PeleaSubzeroRaydenTest {
    private static PeleaSubzeroRayden peleaSubzeroRayden;

    @BeforeClass
    public static void beforeClass(){
        peleaSubzeroRayden = new PeleaSubzeroRayden();
    }

    @Test
    public void testGanador(){
        Assert.assertEquals("String", peleaSubzeroRayden.pelea().getClass().getSimpleName());
    }

    @Test
    public void testGanadorNoVacio(){
        Assert.assertTrue(peleaSubzeroRayden.pelea().length() > 0);
    }
}
