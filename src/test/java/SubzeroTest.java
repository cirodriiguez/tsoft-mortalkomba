import isaac.rodriguez.Subzero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class SubzeroTest {
    private Subzero objsubz;
    @Before
    public void setUp(){
        objsubz = new Subzero("Subzero");
    }

    @Test
    public void congelamiento40(){
        Assert.assertEquals(40, objsubz.congelamiento());
    }
}
