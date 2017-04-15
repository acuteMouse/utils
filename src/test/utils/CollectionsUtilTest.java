package utils;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class CollectionsUtilTest {
    @Test
    public void isNotNull() throws Exception {
        List list=new ArrayList();
        CollectionsUtil.isNotNull(list);
    }

}