import isaac.rodriguez.Campeonato;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        FighterTest.class,
        RaydenTest.class,
        ScorpionTest.class,
        SubzeroTest.class,
        PeleaRaydenScorpionTest.class,
        PeleaSubzeroRaydenTest.class,
        PeleaScorpionSubzeroTest.class,
        CampeonatoTest.class
})
public class SuiteTest {

}
