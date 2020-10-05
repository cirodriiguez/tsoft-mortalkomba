import isaac.rodriguez.Scorpion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScorpionTest {
    private Scorpion objScorpion;

    @Before
    public void setUpR() {
        objScorpion = new Scorpion("Scorpion");
    }

    @Test
    public void nivelDeLanzallamas(){
        Assert.assertEquals(40, objScorpion.Lanzallamas());
    }

    @Test
    public void datosGet(){
        Assert.assertNotEquals(5, objScorpion.getDatos());
    }
}
