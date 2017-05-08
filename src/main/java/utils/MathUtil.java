package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 功能：邮箱格式验证
 * Created by cgl on 2017/4/21
 */
public class MathUtil {
    static DecimalFormat decimalFormat = new DecimalFormat("0.00");


    /**
     * 格式化小数为两位
     *
     * @param d
     * @return
     */
    public static String NumberFormat(double d) {
        return decimalFormat.format(d);
    }

    /**
     * 返回double数组的乘积
     *
     * @param doubles 可变参数列表
     * @return 所有参数的乘积
     */
    public static Double getMulit(double... doubles) {
        BigDecimal sum = new BigDecimal(0.0);
        if (doubles != null && doubles.length > 0) {
            BigDecimal b;
            for (double d : doubles) {
                b = new BigDecimal(d);
                sum = b.multiply(sum);
            }
        }
        return sum.doubleValue();
    }


}
