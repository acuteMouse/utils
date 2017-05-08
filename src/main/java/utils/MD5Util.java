package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * 功能：邮箱格式验证
 * Created by cgl on 2017/4/19
 */
public class MD5Util {

    /**
     * 返回md5加密值
     *
     * @param strObj
     * @return
     */
    public static String GetMD5Code(String strObj) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            byte[] bytes = md.digest(strObj.getBytes());
            for (byte b : bytes) {
                result.append(b);
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result.toString();
    }

}
