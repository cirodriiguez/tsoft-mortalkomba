import isaac.rodriguez.Campeonato;
import isaac.rodriguez.PeleaSubzeroRayden;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CampeonatoTest {
    private static Campeonato campeonato;

    @BeforeClass
    public static void beforeClass(){
        campeonato = new Campeonato();
    }

    @Test
    public void testGanador(){
        Assert.assertEquals("String", campeonato.pelea().getClass().getSimpleName());
    }

    @Test
    public void testGanadorNoVacio(){
        Assert.assertTrue(campeonato.pelea().length() > 0);
    }
}
