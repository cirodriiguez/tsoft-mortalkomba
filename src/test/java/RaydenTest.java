import isaac.rodriguez.Rayden;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RaydenTest{

    private Rayden objRayden;
    @Before
    public void setUp(){
        objRayden = new Rayden("Rayden");
    }

    @Test
    public void nivelDeRayo40(){
        Assert.assertEquals(40, objRayden.nivelRayo());
    }

    @Test
    public void datosGetted(){
        Assert.assertNotEquals(5, objRayden.getDatos());//devuelve un array
    }
}
