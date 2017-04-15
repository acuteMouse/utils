import org.junit.Assert;
import org.junit.Test;
import utils.StringUtil;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class StringUtilTest {
    @Test
    public void testIsNull01(){
        String s=null;
        Assert.assertFalse(StringUtil.isNotNull(s));
    }
    @Test
    public void testIsNull02(){
        String s="    ";
        Assert.assertFalse(StringUtil.isNotNull(s));
    }
    @Test
    public void testIsNull03(){
        String s="   string";
        Assert.assertTrue(StringUtil.isNotNull(s));
    }
}
