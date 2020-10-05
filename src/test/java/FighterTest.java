import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FighterTest {
    private static FighterTestClass fighterTest;

    @BeforeClass
    public static void beforeClass(){
        fighterTest = new FighterTestClass("pepe");
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("pepe", fighterTest.getName());
    }

    @Test
    public void getHealth(){
        Assert.assertEquals(300, (int) (fighterTest.getHealth()));
    }

    @Test
    public void setHealth(){
        fighterTest.setHealth(300);
        Assert.assertEquals(300, (int) (fighterTest.getHealth()));
    }

    @Test
    public void testRangoIntencidadGolpe(){
        float intencidad = fighterTest.Golpe();
        Assert.assertTrue(intencidad >= 50 && intencidad <= 140);
    }

    @Test
    public void testRangoIntencidadPatada(){
        float intencidad = fighterTest.Patada();
        Assert.assertTrue(intencidad >= 30 && intencidad <= 140);
    }

    @Test
    public void testSalto(){
        Assert.assertEquals(0, fighterTest.Salto());
    }

    @Test
    public void testCritico(){
        if (fighterTest.Critico()){
            Assert.assertTrue(true);
        }else{
            Assert.assertFalse(false);
        }
    }
}
