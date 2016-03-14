import io.bgroup.calc.model.Calc;
import org.junit.Assert;
import org.junit.Test;

public class CalcTest {
    @Test
    public void calcTest(){
        Calc calc = new Calc();
        Assert.assertEquals("6",calc.getResult("3+3"));
        Assert.assertEquals("6",calc.getResult("3+2"));
    }
}
