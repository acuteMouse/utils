package utils;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {


        return (str!=null&&str.trim().length()>0 );
//        if (str == null || str.trim().length() < 1) {
//            return false;
//        }
//        return  true;
    }
}
