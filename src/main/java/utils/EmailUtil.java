package utils;

import java.util.regex.Pattern;

/**
 * 功能：邮箱格式验证
 * Created by cgl on 2017/4/16
 */
public class EmailUtil {
    /**
     * 验证邮箱格式是否正确
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (null == email || "".equals(email))
            return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//匹配
        return p.matcher(email).matches();
    }


}
