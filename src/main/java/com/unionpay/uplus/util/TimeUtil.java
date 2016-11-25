package com.unionpay.uplus.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date: 2016/11/26 00:47
 * author: yueqi.shi
 */
public class TimeUtil {
    public static String getDate(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp * 1000);
        return simpleDateFormat.format(date);
    }

}
