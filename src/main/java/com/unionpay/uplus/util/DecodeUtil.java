package com.unionpay.uplus.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * date: 2016/11/26 04:51
 * author: yueqi.shi
 */
public class DecodeUtil {
    public static String decode(String content) {
        try {
            String decodeContent = URLDecoder.decode(content, "utf-8");

            return decodeContent;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return content;
    }

}
