package utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能：
 * Created by cgl on 2017/5/4 0004.
 */
public class RequestUtilTest {
    @Test
    public void post() throws Exception {
        String url = "https://ickuai.com/inquiry/ajax/getnewoffer.do";
        String relust = RequestUtil.post(url, null);
        System.out.println(relust);
    }

    @Test
    public void get(){
        String url="http://www.weather.com.cn/data/sk/101110101.html" ;
        String result=RequestUtil.get(url);
        System.out.println(result);
    }

}