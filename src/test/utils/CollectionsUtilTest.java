package utils;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Assert;
import org.junit.Test;
import utils.CollectionsUtil;

import java.util.*;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class CollectionsUtilTest {
    @Test
    public void isNotNull01() throws Exception {
        List list=new ArrayList();
        Assert.assertFalse(CollectionsUtil.isNotNull(list));
    }
    @Test
    public void isNotNull02() throws Exception {
        List<String> list=new ArrayList();
        list.add("list");
       Assert.assertTrue( CollectionsUtil.isNotNull(list));
    }
    @Test
    public void isNotNull03() throws Exception {
        Set set=new LinkedHashSet();
        Assert.assertFalse(CollectionsUtil.isNotNull(set));
    }
    @Test
    public void isNotNull04() throws Exception {
        Set<String> set=new LinkedHashSet();
        Assert.assertFalse(CollectionsUtil.isNotNull(set));
    }
    @Test
    public void isNotNull05() throws Exception {
        Queue<String> queue=new PriorityQueue<String>();
        Assert.assertFalse(CollectionsUtil.isNotNull(queue));
    }
    @Test
    public void isNotNull06() throws Exception {
        Queue queue=new PriorityQueue<String>();
        Assert.assertFalse(CollectionsUtil.isNotNull(queue));
    }

    @Test
    public void mapIsNotNull01() throws Exception {
        Map map=new HashedMap();
        Assert.assertFalse(CollectionsUtil.mapIsNotNull(map));
    }
    @Test
    public void mapIsNotNull02() throws Exception {
        Map map=null;
        Assert.assertFalse(CollectionsUtil.mapIsNotNull(map));
    }
    @Test
    public void mapIsNotNull03()  {
        Map<String,Integer> map=new HashMap();
        map.put("1",1);
        Assert.assertTrue(CollectionsUtil.mapIsNotNull(map));
    }

}