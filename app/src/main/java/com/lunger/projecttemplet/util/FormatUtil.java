package com.lunger.projecttemplet.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Lunger on 2017/7/21.
 */

public class FormatUtil {

    /**
     * 把数字String转换成保留两位小数
     */
    public static String formatMoneyString(String s){
        BigDecimal bigDecimal = new BigDecimal(s);
        BigDecimal bd_half_even = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        return bd_half_even.toString();
    }
}
